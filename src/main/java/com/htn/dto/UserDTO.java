package com.htn.dto;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String email;
    private String password;
    private String userName;
    private String avatar;
    @Builder.Default
    private String usedYn = "Y";
    private String role;

    private String loginType;
    private String ssoId;
    @Builder.Default
    private String verifyYn = "N";
    private Date verifyDt;
}
