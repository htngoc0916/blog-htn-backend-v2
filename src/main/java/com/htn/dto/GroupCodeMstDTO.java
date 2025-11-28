package com.htn.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GroupCodeMstDTO {
    private Long id;
    private String groupCd;
    private String groupNm;
    private Integer codeLength;
    private String groupDes;
}
