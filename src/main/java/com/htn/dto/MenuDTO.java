package com.htn.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuDTO {
    private Long id;
    private String menuCode;
    private String menuName;
    private String menuNameEng;
    private String parentCd;
    private String menuType;
    private Integer menuOrd;
    private String menuUrl;
    private String menuIcon;

    //update info
    private String usedYn;
    private Long regId;
    private Long modId;

    //permission
    private List<String> permissions;
}
