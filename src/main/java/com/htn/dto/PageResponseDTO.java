package com.htn.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageResponseDTO<T> {
    private List<T> items;
    private Integer page;
    private Integer pageSize;
    //tổng các rows có trong DB
    private Long totalElements;
    //tổng trang
    private Integer totalPage;
    private boolean last;

    //khai báo ntn để ko phải tạo object trước, rồi mới gọi.
    //mà gọi trực tiếp luôn
    public static <T> PageResponseDTO<T> of(Page<T> page) {
        return PageResponseDTO.<T>builder()
                .items(page.getContent())
                .page(page.getNumber() + 1)
                .pageSize(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPage(page.getTotalPages())
                .last(page.isLast())
                .build();
    }

    public static <T> PageResponseDTO<T> of(List<T> data, Pageable pageable, long total) {
        int page = pageable.getPageNumber() + 1 ;
        int pageSize = pageable.getPageSize();
        int totalPage = (int) Math.ceil((double) total / pageSize);
        boolean isLast = page >= totalPage;


        return  PageResponseDTO.<T>builder()
                .items(data)
                .page(page)
                .pageSize(pageSize)
                .totalElements(total)
                .totalPage(totalPage)
                .last(isLast)
                .build();
    }
}
