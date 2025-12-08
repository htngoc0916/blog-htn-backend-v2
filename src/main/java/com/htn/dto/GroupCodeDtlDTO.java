package com.htn.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GroupCodeDtlDTO {
    private Long id;
    @NotBlank(message = "Cannot be blank")
    private String groupCd;
    @NotBlank(message = "Cannot be blank")
    private String codeCd;
    @NotBlank(message = "Cannot be blank")
    private String codeNm;
    private String codeNmEng;
    private String description;
    private String parentCd;
    private String ect1;
    private String ect2;
    private String ect3;
    private String etc4;
}
