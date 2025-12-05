package com.htn.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GroupCodeMstDTO {
    private Long id;
    @NotEmpty(message = "Cannot be blank")
    private String groupCd;
    @NotEmpty(message = "Cannot be blank")
    private String groupNm;
    private String groupNmEng;
    @NotEmpty(message = "Cannot be blank")
    private Integer codeLength;
    private String groupDes;
    private String groupOrd;
    private String usedYn;
}
