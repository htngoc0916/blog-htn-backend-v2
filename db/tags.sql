create table tags
(
    ID        int auto_increment
        primary key,
    TAG_NAME  varchar(50)                          not null,
    TAG_SLUG  varchar(256)                         not null,
    TAG_TYPE  varchar(32)                          null,
    TAG_COLOR varchar(32)                          null,
    TAG_ORD   int                                  null,
    TAG_DES   varchar(256)                         null,
    USED_YN   varchar(1) default 'Y'               null,
    REG_DT    datetime   default CURRENT_TIMESTAMP null,
    REG_ID    int                                  null,
    MOD_DT    datetime                             null,
    MOD_ID    int                                  null,
    constraint TAG_SLUG
        unique (TAG_SLUG)
);

INSERT INTO `blog-htngoc`.tags (TAG_NAME, TAG_SLUG, TAG_TYPE, TAG_COLOR, TAG_ORD, TAG_DES, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('Backend', 'backend', null, 'indigo', null, null, 'Y', '2024-03-14 02:57:47', null, '2024-06-10 04:25:42', 2);
INSERT INTO `blog-htngoc`.tags (TAG_NAME, TAG_SLUG, TAG_TYPE, TAG_COLOR, TAG_ORD, TAG_DES, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('Frontend', 'frontend', null, 'lime', null, null, 'Y', '2024-03-14 02:58:05', 1, null, null);
INSERT INTO `blog-htngoc`.tags (TAG_NAME, TAG_SLUG, TAG_TYPE, TAG_COLOR, TAG_ORD, TAG_DES, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('Java', 'java', null, 'cyan', null, null, 'Y', '2024-03-14 02:58:32', null, '2024-06-10 04:25:45', 2);
INSERT INTO `blog-htngoc`.tags (TAG_NAME, TAG_SLUG, TAG_TYPE, TAG_COLOR, TAG_ORD, TAG_DES, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('React', 'react', null, 'pink', null, null, 'Y', '2024-03-14 02:58:40', null, '2024-06-10 04:25:49', 2);
INSERT INTO `blog-htngoc`.tags (TAG_NAME, TAG_SLUG, TAG_TYPE, TAG_COLOR, TAG_ORD, TAG_DES, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('Visa', 'visa', null, 'green', null, null, 'Y', '2024-03-14 02:58:57', null, '2024-06-10 04:25:54', 2);
INSERT INTO `blog-htngoc`.tags (TAG_NAME, TAG_SLUG, TAG_TYPE, TAG_COLOR, TAG_ORD, TAG_DES, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('Bằng lái xe', 'bang-lai-xe', null, 'red', null, null, 'Y', '2024-03-14 04:13:50', null, '2024-06-10 04:25:56', 2);
INSERT INTO `blog-htngoc`.tags (TAG_NAME, TAG_SLUG, TAG_TYPE, TAG_COLOR, TAG_ORD, TAG_DES, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('Hàn Quốc', 'han-quoc', null, 'cyan', null, null, 'Y', '2024-03-26 11:31:59', null, '2024-06-10 04:25:59', 2);
INSERT INTO `blog-htngoc`.tags (TAG_NAME, TAG_SLUG, TAG_TYPE, TAG_COLOR, TAG_ORD, TAG_DES, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('Xin việc', 'xin-viec', null, 'purple', null, null, 'Y', '2024-05-15 20:30:52', 3, null, null);
INSERT INTO `blog-htngoc`.tags (TAG_NAME, TAG_SLUG, TAG_TYPE, TAG_COLOR, TAG_ORD, TAG_DES, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('Thực tập', 'thuc-tap', null, 'yellow', null, null, 'Y', '2024-05-15 20:31:13', null, '2024-06-10 04:26:02', 2);
INSERT INTO `blog-htngoc`.tags (TAG_NAME, TAG_SLUG, TAG_TYPE, TAG_COLOR, TAG_ORD, TAG_DES, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('elastic', 'elastic', null, 'pink', null, null, 'Y', '2024-06-10 04:19:53', null, '2024-06-10 04:26:04', 2);
