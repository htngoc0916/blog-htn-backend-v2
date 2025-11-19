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
public class PageResponseDTO<T> {
    private List<T> data;
    private Integer pageNo;
    private Integer pageSize;
    private Long totalElements;
    private Integer totalPage;
    private boolean last;
}
