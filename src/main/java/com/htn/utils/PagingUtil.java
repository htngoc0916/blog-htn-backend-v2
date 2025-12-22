package com.htn.utils;

import com.htn.constant.CommonConstant;
import com.htn.exception.GlobalException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PagingUtil {
    //validation pageSize
    public static void paginationValidate(Pageable pageable) {
        int page = pageable.getPageNumber();
        int size = pageable.getPageSize();

        if (page < 0) {
            throw new GlobalException("Page number cannot be less than 0");
        }

        if (size < 0) {
            throw new GlobalException("Size number cannot be less than 0");
        }

        if (size > CommonConstant.MAX_PAGE_SIZE) {
            throw new GlobalException("Page size must not be greater than " + CommonConstant.MAX_PAGE_SIZE);
        }
    }

    //get offset
    public static int offset(Pageable pageable) {
        return pageable.getPageNumber() * pageable.getPageSize();
    }

    //get limit
    public static int limit(Pageable pageable) {
        return pageable.getPageSize();
    }

    //sort sql
    public static String sortSql(Pageable pageable) {
        if (!pageable.getSort().isSorted()) return null;

        Sort.Order order = pageable.getSort().iterator().next();
        return order.getProperty() + " " + order.getDirection().name();
    }

}
