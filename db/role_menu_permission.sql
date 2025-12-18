create table role_menu_permission
(
    ROLE_ID       int not null,
    MENU_ID       int not null,
    PERMISSION_ID int not null,
    primary key (ROLE_ID, MENU_ID, PERMISSION_ID),
    constraint role_menu_permission_ibfk_1
        foreign key (ROLE_ID) references roles (ID),
    constraint role_menu_permission_ibfk_2
        foreign key (MENU_ID) references menus (ID),
    constraint role_menu_permission_ibfk_3
        foreign key (PERMISSION_ID) references permissions (ID)
);

create index MENU_ID
    on role_menu_permission (MENU_ID);

create index PERMISSION_ID
    on role_menu_permission (PERMISSION_ID);

