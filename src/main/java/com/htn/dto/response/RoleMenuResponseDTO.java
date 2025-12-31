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
public class RoleMenuResponseDTO {
    private Long id;
    private String roleCode;
    private String roleName;
    private String roleDes;
    private String roleIcon;

    List<MenuResponseDTO> menus;
}
