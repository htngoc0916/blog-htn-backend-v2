package com.htn.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class TagSearchDTO {
    private String tagNm;
    private String tagType;

    @Pattern(regexp = "^([YN])?$", message = "Must be [null|Y|N] only")
    private String usedYn;
}
