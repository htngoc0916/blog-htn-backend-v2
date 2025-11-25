package com.htn.dto;

import com.htn.constant.RoleConstant;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String email;
    private String password;
    private String userName;
    private String avatar;
    @Builder.Default
    private String usedYn = "Y";
    @Builder.Default
    private String role = RoleConstant.ROLE_USER.toString();

    private String loginType;
    private String ssoId;
    @Builder.Default
    private String verifyYn = "N";
    private Date verifyDt;
}
