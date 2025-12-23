package com.htn.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.htn.module.TreeNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupCodeDtlResponseDTO implements TreeNode<GroupCodeDtlResponseDTO> {
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

    @Override
    @JsonIgnore
    public String getCode() {
        return codeCd;
    }

    @Override
    @JsonIgnore
    public String getParentCode() {
        return parentCd;
    }
}
