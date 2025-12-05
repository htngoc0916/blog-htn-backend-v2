package com.htn.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CategorySearchDTO {
    private String categoryNm;

    @Pattern(regexp = "^([YN])?$", message = "Must be [null|Y|N] only")
    private String usedYn;
}
