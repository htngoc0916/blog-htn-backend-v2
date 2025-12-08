package com.htn.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GroupCodeMstDTO {
    private Long id;
    @NotBlank(message = "Cannot be blank")
    private String groupCd;
    @NotBlank(message = "Cannot be blank")
    private String groupNm;
    private String groupNmEng;
    @Min(value = 3, message = "Must be greater than 3")
    private int codeLength;
    private String groupDes;
    private String groupOrd;
    private String usedYn;
}
