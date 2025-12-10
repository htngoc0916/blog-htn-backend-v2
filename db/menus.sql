create table menus
(
    ID        int auto_increment
        primary key,
    MENU_CODE varchar(10)                          not null,
    MENU_NAME varchar(30)                          not null,
    PARENT_ID int                                  null,
    MENU_ORD  int                                  null,
    MENU_URL  varchar(100)                         null,
    USED_YN   varchar(1) default 'Y'               null,
    REG_DT    datetime   default CURRENT_TIMESTAMP null,
    REG_ID    int                                  null,
    MOD_DT    datetime                             null,
    MOD_ID    int                                  null,
    MENU_ICON varchar(40)                          null,
    constraint uq_menu_code_url
        unique (MENU_CODE, MENU_URL)
);

INSERT INTO `blog-htngoc`.menus (MENU_CODE, MENU_NAME, PARENT_ID, MENU_ORD, MENU_URL, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID, MENU_ICON) VALUES ('PUBLIC', 'Home', 0, 1, '/', 'Y', '2023-12-08 06:54:29', 1, null, null, null);
INSERT INTO `blog-htngoc`.menus (MENU_CODE, MENU_NAME, PARENT_ID, MENU_ORD, MENU_URL, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID, MENU_ICON) VALUES ('PUBLIC', 'About', 0, 2, '/about', 'Y', '2023-12-08 06:57:17', 1, null, null, null);
INSERT INTO `blog-htngoc`.menus (MENU_CODE, MENU_NAME, PARENT_ID, MENU_ORD, MENU_URL, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID, MENU_ICON) VALUES ('PRIVATE', 'Dashboard', 0, 1, '/auth/dashboard', 'Y', '2023-12-08 06:58:15', 1, null, null, 'IconDashboard');
INSERT INTO `blog-htngoc`.menus (MENU_CODE, MENU_NAME, PARENT_ID, MENU_ORD, MENU_URL, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID, MENU_ICON) VALUES ('PRIVATE', 'Users', 0, 2, '/auth/users', 'Y', '2023-12-08 06:58:44', 1, null, null, 'IconUsers');
INSERT INTO `blog-htngoc`.menus (MENU_CODE, MENU_NAME, PARENT_ID, MENU_ORD, MENU_URL, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID, MENU_ICON) VALUES ('PRIVATE', 'Categories', 0, 3, '/auth/categories', 'Y', '2023-12-08 06:59:39', 1, null, null, 'IconCategories');
INSERT INTO `blog-htngoc`.menus (MENU_CODE, MENU_NAME, PARENT_ID, MENU_ORD, MENU_URL, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID, MENU_ICON) VALUES ('PRIVATE', 'Posts', 0, 4, '/auth/posts', 'Y', '2023-12-08 06:59:55', 1, null, null, 'IconPosts');
INSERT INTO `blog-htngoc`.menus (MENU_CODE, MENU_NAME, PARENT_ID, MENU_ORD, MENU_URL, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID, MENU_ICON) VALUES ('PRIVATE', 'Tags', 0, 5, '/auth/tags', 'Y', '2023-12-08 07:02:11', 1, null, null, 'IconTags');
INSERT INTO `blog-htngoc`.menus (MENU_CODE, MENU_NAME, PARENT_ID, MENU_ORD, MENU_URL, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID, MENU_ICON) VALUES ('PRIVATE', 'Contacts', 0, 6, '/auth/contacts', 'Y', '2023-12-08 07:02:39', 1, '2023-12-08 07:06:42', 1, 'IconContacts');
INSERT INTO `blog-htngoc`.menus (MENU_CODE, MENU_NAME, PARENT_ID, MENU_ORD, MENU_URL, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID, MENU_ICON) VALUES ('PRIVATE', 'Systems', 0, 99, '/auth/systems', 'Y', '2023-12-08 07:09:33', 1, null, null, 'IconSystem');
