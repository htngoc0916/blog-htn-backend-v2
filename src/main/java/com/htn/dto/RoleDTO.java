package com.htn.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleDTO {
    private Long id;
    @NotEmpty(message = "Cannot be blank")
    private String roleCode;
    @NotEmpty(message = "Cannot be blank")
    private String roleName;
    private String roleDes;
    private String roleIcon;
}