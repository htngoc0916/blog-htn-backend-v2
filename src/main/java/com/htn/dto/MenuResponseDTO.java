package com.htn.dto;

import com.htn.entity.Permission;
import com.htn.module.TreeNode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuResponseDTO implements TreeNode<MenuResponseDTO> {
    private Long id;
    private String menuCode;
    private String menuName;
    private String menuNameEng;
    private String parentCd;
    private Integer menuOrder;
    private String menuUrl;
    private String menuIcon;
    private String usedYn;

    //children
    private List<MenuResponseDTO> children;

    private List<PermissionConfigDTO> permissions;

    @Override
    public String getCode() {
        return menuCode;
    }
    @Override
    public String getParentCode() {
        return parentCd;
    }
}
