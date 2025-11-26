package com.htn.dto;

import com.htn.constant.RoleConstant;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserDTO {
    private Long id;
    private String email;
    private String password;
    private String userName;
    private String avatar;
    private String loginType;
    private String ssoId;
    @Builder.Default
    private String verifyYn = "N";
    private Date verifyDt;
    @Builder.Default
    private String usedYn = "Y";
    @Builder.Default
    private String role = RoleConstant.ROLE_USER.toString();
}
