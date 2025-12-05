package com.htn.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class GroupCodeDtlSearchDTO {
    @NotBlank(message = "Cannot be blank")
    private String groupCd;
    private String codeCd;
    private String codeNm;

    @Pattern(regexp = "^([YN])?$", message = "Must be [null|Y|N] only")
    private String usedYn;
}
