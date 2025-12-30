package com.htn.dto.search;

import com.htn.dto.BaseDTO;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MediaSearchDTO extends BaseDTO {
    String mediaType;
}
