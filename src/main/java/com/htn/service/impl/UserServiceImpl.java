package com.htn.service.impl;

import com.htn.dto.PageResponseDTO;
import com.htn.dto.UserDTO;
import com.htn.dto.UserSearchDTO;
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
import com.htn.utils.PagingUtil;
import com.htn.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Value("${auth.verify-code-expire-time}")
    private int verifyCodeExpireTime;

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new NotFoundException(i18n.translate(UserMessages.USER_NOT_FOUND))
        );
    }
    @Override
    public User getUserByEmail(String email){
        return userRepository.findByEmail(email).orElseThrow(
                () -> new NotFoundException(i18n.translate(UserMessages.USER_NOT_FOUND))
        );
    }

    @Override
    public PageResponseDTO<User> getPaginationUsers(UserSearchDTO searchDTO, Pageable pageable) {

        //validation
        PagingUtil.paginationValidate(pageable);

        //check search params
        Page<User> resultPage;
        if (StringUtils.hasText(searchDTO.getUserName()) && StringUtils.hasText(searchDTO.getUsedYn())) {
            //tìm kiếm theo tên và usedYn
            resultPage = userRepository.findByUserNameContainingAndUsedYn(searchDTO.getUserName(), searchDTO.getUsedYn(), pageable);
        } else if (StringUtils.hasText(searchDTO.getUserName())) {
            //tìm kiếm theo tên
            resultPage = userRepository.findByUserNameContaining(searchDTO.getUserName(), pageable);
        } else if (StringUtils.hasText(searchDTO.getUsedYn())) {
            //tìm kiếm theo usedYn
            resultPage = userRepository.findByUsedYn(searchDTO.getUsedYn(), pageable);
        } else {
            //không có đk
            resultPage = userRepository.findAll(pageable);
        }

        return PageResponseDTO.of(resultPage);
    }

    @Override
    public User addUser(UserDTO userDTO) {
        //set user info
        User user = mappingUser(userDTO);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User clientAddUser(UserDTO userDTO) {
        User user = mappingUser(userDTO);

        //set user info
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setVerifyYn("N");
        user.setVerifyCode(SecurityUtil.generateVerificationCode());
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long userId, UserDTO userDTO) {
        User user = getUserById(userId);
        userMapper.updateFromDto(userDTO, user);

        return userRepository.save(user);
    }

    @Override
    public boolean deleteUser(Long userId) {
        User user = getUserById(userId);
        user.setUsedYn("N");
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean existsEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean sendVerifyCode(String email) {
        User user = getUserByEmail(email);
        user.setEmailSendYn("N");
        user.setVerifyYn("N");
        user.setEmailSendDt(new Date());
        user.setVerifyCode(SecurityUtil.generateVerificationCode());
        userRepository.save(user);
        return true;
    }


    @Override
    public boolean verifyCode(VerifyCodeDTO verifyCodeDTO) {
        User user = getUserByEmail(verifyCodeDTO.getEmail());
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
            if (diffInMinutes > verifyCodeExpireTime) {
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
                () -> new NotFoundException(i18n.translate(CommonMessages.COMMON_NOT_FOUND_WITH, userDTO.getRole()))
        );

        //set user info
        User user = userMapper.toEntity(userDTO);
        user.setRoles(List.of(role));
        return user;
    }
}
