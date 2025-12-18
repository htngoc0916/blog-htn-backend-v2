create table roles
(
    ID        int auto_increment
        primary key,
    ROLE_CODE varchar(32)  not null,
    ROLE_NAME varchar(64)  not null,
    ROLE_DES  varchar(255) null,
    ROLE_ICON varchar(50)  null,
    constraint ROLE_NAME
        unique (ROLE_NAME)
);

INSERT INTO `blog-htngoc`.roles (ROLE_CODE, ROLE_NAME, ROLE_DES, ROLE_ICON) VALUES ('USER', 'Người dùng', 'Chi xem nội dung công khai', null);
INSERT INTO `blog-htngoc`.roles (ROLE_CODE, ROLE_NAME, ROLE_DES, ROLE_ICON) VALUES ('ADMIN', 'Quản trị', 'Toàn quyền truy cập hệ thống', null);
INSERT INTO `blog-htngoc`.roles (ROLE_CODE, ROLE_NAME, ROLE_DES, ROLE_ICON) VALUES ('EDITOR', 'Biên tập viên', 'Quản lý nội dung, media và bình luận', null);
INSERT INTO `blog-htngoc`.roles (ROLE_CODE, ROLE_NAME, ROLE_DES, ROLE_ICON) VALUES ('MODERATOR', 'Người kiểm duyệt', 'Duyệt bài viết và quản lý báo cáo', null);
