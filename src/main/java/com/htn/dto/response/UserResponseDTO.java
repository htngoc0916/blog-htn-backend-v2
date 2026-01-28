package com.htn.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDTO {
    Long id;
    private String email;
    private String userName;
    private String avatar;
    private String verifyYn;
    private String usedYn;
    private List<String> roles;
}
