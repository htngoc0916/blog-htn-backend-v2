package com.htn.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TagDTO {
    private Long id;
    @NotEmpty(message = "Cannot be blank")
    private String tagName;
    private String tagType;
    private String tagColor;
    private Integer tagOrd;
    private String tagDes;
    private String usedYn;
}
