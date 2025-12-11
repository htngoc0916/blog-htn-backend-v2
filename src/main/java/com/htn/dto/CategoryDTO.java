package com.htn.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDTO {
    private Long id;
    @NotEmpty(message = "Cannot be blank")
    private String categoryCd;
    @NotEmpty(message = "Cannot be blank")
    private String categoryNm;
    private String categoryDes;
    private int categoryOrd;
    private String parentCd;
    @Pattern(regexp = "^([YN])?$", message = "Must be [null|Y|N] only")
    private String usedYn;
}
