create table user_menu_permission
(
    USER_ID       int                    not null,
    MENU_ID       int                    not null,
    PERMISSION_ID int                    not null,
    IS_ALLOWED    varchar(1) default 'Y' null comment 'Y: cho phép, N: cấm',
    primary key (USER_ID, MENU_ID, PERMISSION_ID),
    constraint user_menu_permission_ibfk_1
        foreign key (USER_ID) references users (ID),
    constraint user_menu_permission_ibfk_2
        foreign key (MENU_ID) references menus (ID),
    constraint user_menu_permission_ibfk_3
        foreign key (PERMISSION_ID) references permissions (ID)
);

create index MENU_ID
    on user_menu_permission (MENU_ID);

create index PERMISSION_ID
    on user_menu_permission (PERMISSION_ID);

