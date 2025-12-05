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
public class GroupCodeMstResponseDTO {
    private Long id;
    private String groupCd;
    private String groupNm;
    private Integer codeLength;
    private String groupDes;
    private List<GroupCodeDtlDTO> groupCodeDtls;
}
