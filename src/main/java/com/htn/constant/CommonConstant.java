package com.htn.constant;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Setter
@Getter
public class CommonConstant {
    @Value( "${common.password}")
    public static String PASSWORD;

    //pagination
    @Value( "${common.page-size}")
    public static int PAGE_SIZE_DEFAULT;
    @Value( "${common.page-number}")
    public static int PAGE_NUMBER_DEFAULT;
    @Value( "${common.page-sort}")
    public static String PAGE_SORT_DEFAULT;

    //token
    @Value( "${common.max-auth-token}")
    public static int MAX_AUTH_TOKEN;
}
