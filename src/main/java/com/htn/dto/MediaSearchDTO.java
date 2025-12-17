package com.htn.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MediaSearchDTO extends BaseDTO{
    String mediaType;
}
