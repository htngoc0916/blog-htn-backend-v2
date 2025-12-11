package com.htn.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponseDTO {
    private Long id;
    private String categoryCd;
    private String categoryNm;
    private String categoryDes;
    private int categoryOrd;
    private String parentCd;
    private String usedYn;

    private List<CategoryResponseDTO> children;
}
