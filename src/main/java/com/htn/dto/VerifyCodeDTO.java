package com.htn.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VerifyCodeDTO {
    @NotBlank(message = "email is required")
    private String email;
    @NotBlank(message = "Verification code cannot be blank")
    private String code;
}
