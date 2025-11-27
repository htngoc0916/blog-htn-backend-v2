package com.htn.service.impl;

import com.htn.constant.CommonConstant;
import com.htn.dto.UserDTO;
import com.htn.dto.VerifyCodeDTO;
import com.htn.entity.Role;
import com.htn.entity.User;
import com.htn.exception.GlobalException;
import com.htn.exception.NotFoundException;
import com.htn.i18n.AuthMessages;
import com.htn.i18n.CommonMessages;
import com.htn.i18n.LocalizationService;
import com.htn.i18n.UserMessages;
import com.htn.mapper.UserMapper;
import com.htn.repository.RoleRepository;
import com.htn.repository.UserRepository;
import com.htn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.htn.utils.Utils.generateVerificationCode;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private LocalizationService i18n;
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean existsEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public User addUser(UserDTO userDTO) {
        //set user info
        User user = mappingUser(userDTO);
        return userRepository.save(user);
    }


    @Override
    public User clientAddUser(UserDTO userDTO) {
        User user = mappingUser(userDTO);
        //set user info
        user.setVerifyYn("N");
        user.setVerifyCode(generateVerificationCode());
        return userRepository.save(user);
    }

    @Override
    public boolean sendVerifyCode(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new NotFoundException(i18n.translate(UserMessages.USER_NOT_FOUND))
        );
        user.setEmailSendYn("N");
        user.setVerifyYn("N");
        user.setEmailSendDt(new Date());
        user.setVerifyCode(generateVerificationCode());
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean verifyCode(VerifyCodeDTO verifyCodeDTO) {
        User user = userRepository.findByEmail(verifyCodeDTO.getEmail()).orElseThrow(
                () -> new NotFoundException(i18n.translate(UserMessages.USER_NOT_FOUND))
        );
        //check verify code
        if(verifyCodeDTO.getCode().length() != 6 ||
                !verifyCodeDTO.getCode().equals(user.getVerifyCode())){
            throw new NotFoundException(i18n.translate(AuthMessages.AUTH_VERIFY_CODE_INCORRECT));
        }
        //check expired code (10p)
        if(user.getEmailSendDt() != null){
            Date sendDt = user.getEmailSendDt();
            Date currentTime = new Date();
            long time = currentTime.getTime() - sendDt.getTime();
            long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(time);
            if (diffInMinutes > CommonConstant.VERIFY_CODE_EXPIRE_TIME) {
                throw new NotFoundException(i18n.translate(AuthMessages.AUTH_VERIFY_CODE_INCORRECT));
            }
        }

        //verify user ok
        user.setVerifyYn("Y");
        user.setVerifyDt(new Date());
        userRepository.save(user);

        return true;
    }

    private User mappingUser(UserDTO userDTO){
        //check email exists
        if(existsEmail(userDTO.getEmail())){
            throw new GlobalException(i18n.translate(UserMessages.USER_EMAIL_EXISTS));
        }
        //check role exists
        Role role = roleRepository.findByRoleName(userDTO.getRole()).orElseThrow(
                () -> new NotFoundException(i18n.translate(CommonMessages.COMMON_NOT_FOUND, userDTO.getRole()))
        );

        //set user info
        User user = userMapper.toEntity(userDTO);
        user.setRoles(List.of(role));
        return user;
    }
}
