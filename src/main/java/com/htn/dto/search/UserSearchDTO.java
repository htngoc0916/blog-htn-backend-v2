package com.htn.dto.search;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserSearchDTO {
    private String userName;

    @Pattern(regexp = "^([YN])?$", message = "Must be [null|Y|N] only")
    private String usedYn;
}
