package com.htn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupCodeDtlResponseDTO {
    private Long id;
    private String groupCd;
    private String parentCd;

    private String codeCd;
    private String codeNm;
    private String codeNmEng;
    private String codeDes;
    private int codeOrd;
    private String ect1;
    private String ect2;
    private String ect3;
    private String etc4;

    private List<GroupCodeDtlResponseDTO> children;
}
