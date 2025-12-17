package com.htn.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BaseDTO {
    private String usedYn;
    private String regDt;
    private String regId;
    private String modId;
    private String modDt;
}
