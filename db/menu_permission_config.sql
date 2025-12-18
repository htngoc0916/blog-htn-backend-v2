create table menu_permission_config
(
    ID            int auto_increment
        primary key,
    MENU_ID       int                                  not null,
    PERMISSION_ID int                                  not null,
    DESCRIPTION   varchar(255)                         null,
    SORT_ORDER    int        default 0                 null,
    USED_YN       varchar(1) default 'Y'               null,
    REG_DT        datetime   default CURRENT_TIMESTAMP null,
    REG_ID        int                                  null,
    MOD_DT        datetime                             null,
    MOD_ID        int                                  null,
    constraint UK_MENU_PERMISSION
        unique (MENU_ID, PERMISSION_ID),
    constraint FK_MPC_MENU
        foreign key (MENU_ID) references menus (ID)
            on delete cascade,
    constraint FK_MPC_PERMISSION
        foreign key (PERMISSION_ID) references permissions (ID)
            on delete cascade
)
    comment 'Cấu hình quyền cho từng menu';

