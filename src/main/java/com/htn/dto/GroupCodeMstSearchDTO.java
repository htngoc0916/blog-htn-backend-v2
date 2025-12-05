package com.htn.dto;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupCodeMstSearchDTO {
    private String groupNm;

    @Pattern(regexp = "^([YN])?$", message = "Must be [null|Y|N] only")
    private String usedYn;
}
