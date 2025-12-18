create table menus
(
    ID            int auto_increment
        primary key,
    MENU_CODE     varchar(32)                          not null,
    MENU_NAME     varchar(64)                          not null,
    MENU_NAME_ENG varchar(64)                          null,
    PARENT_CD     varchar(32)                          null,
    MENU_TYPE     varchar(20)                          null,
    MENU_ORD      int                                  null,
    MENU_URL      varchar(100)                         null,
    MENU_ICON     varchar(40)                          null,
    USED_YN       varchar(1) default 'Y'               null,
    REG_DT        datetime   default CURRENT_TIMESTAMP null,
    REG_ID        int                                  null,
    MOD_DT        datetime                             null,
    MOD_ID        int                                  null,
    constraint uq_menu_code_url
        unique (MENU_CODE)
);

