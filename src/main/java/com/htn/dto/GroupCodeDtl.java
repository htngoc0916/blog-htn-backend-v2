package com.htn.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GroupCodeDtl {
    private Long id;
    private String groupCd;
    private String codeCd;
    private String codeNm;
    private String codeNmEng;
    private String description;
    private String parentCd;
    private String ect1;
    private String ect2;
    private String ect3;
    private String etc4;
}
