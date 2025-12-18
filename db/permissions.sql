create table permissions
(
    ID            int auto_increment
        primary key,
    PERMISSION_CD varchar(50)                        not null comment 'VIEW, CREATE, UPDATE, DELETE',
    PERMISSION_NM varchar(100)                       not null,
    REG_DT        datetime default CURRENT_TIMESTAMP null,
    constraint PER_CODE
        unique (PERMISSION_CD)
);

INSERT INTO `blog-htngoc`.permissions (PERMISSION_CD, PERMISSION_NM, REG_DT) VALUES ('FULL', 'Toàn quyền', '2025-12-18 14:35:48');
INSERT INTO `blog-htngoc`.permissions (PERMISSION_CD, PERMISSION_NM, REG_DT) VALUES ('CREATE', 'Tạo mới', '2025-12-18 14:35:48');
INSERT INTO `blog-htngoc`.permissions (PERMISSION_CD, PERMISSION_NM, REG_DT) VALUES ('EDITOR', 'Chỉnh sửa', '2025-12-18 14:35:48');
INSERT INTO `blog-htngoc`.permissions (PERMISSION_CD, PERMISSION_NM, REG_DT) VALUES ('DELETE', 'Xóa', '2025-12-18 14:35:48');
INSERT INTO `blog-htngoc`.permissions (PERMISSION_CD, PERMISSION_NM, REG_DT) VALUES ('APPROVE', 'Phê duyệt', '2025-12-18 14:35:48');
INSERT INTO `blog-htngoc`.permissions (PERMISSION_CD, PERMISSION_NM, REG_DT) VALUES ('RELEASE', 'Xuất bản', '2025-12-18 14:35:48');
INSERT INTO `blog-htngoc`.permissions (PERMISSION_CD, PERMISSION_NM, REG_DT) VALUES ('DOWNLOAD', 'Tải xuống', '2025-12-18 14:35:48');
INSERT INTO `blog-htngoc`.permissions (PERMISSION_CD, PERMISSION_NM, REG_DT) VALUES ('VIEW', 'Xem', '2025-12-18 15:06:14');
