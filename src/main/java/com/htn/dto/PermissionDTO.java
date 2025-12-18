package com.htn.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PermissionDTO {
    private Long id;
    @NotBlank(message = "Cannot be blank")
    private String permissionCd;
    @NotBlank(message = "Cannot be blank")
    private String permissionNm;
}
