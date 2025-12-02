package com.htn.security.custom;

import com.htn.entity.User;
import com.htn.i18n.LocalizationService;
import com.htn.i18n.UserMessages;
import com.htn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LocalizationService i18n;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(
                        i18n.translate(UserMessages.USER_NOT_FOUND)
                ));
        return CustomUserDetails.build(user);
    }

}
