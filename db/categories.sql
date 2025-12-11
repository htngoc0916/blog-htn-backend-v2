create table categories
(
    ID           int auto_increment
        primary key,
    CATEGORY_CD  varchar(32)                          not null,
    CATEGORY_NM  varchar(256)                         not null,
    CATEGORY_DES varchar(256)                         null,
    CATEGORY_ORD int                                  null,
    PARENT_CD    varchar(32)                          null,
    USED_YN      varchar(1) default 'Y'               null,
    REG_DT       datetime   default CURRENT_TIMESTAMP null,
    REG_ID       int                                  null,
    MOD_DT       datetime                             null,
    MOD_ID       int                                  null,
    constraint CATEGORY_CD
        unique (CATEGORY_CD)
);

INSERT INTO `blog-htngoc`.categories (CATEGORY_CD, CATEGORY_NM, CATEGORY_DES, CATEGORY_ORD, PARENT_CD, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('LT', 'Lập trình', 'Những bài viết về IT và lập trình', null, null, 'Y', '2024-03-14 02:47:32', 1, null, null);
INSERT INTO `blog-htngoc`.categories (CATEGORY_CD, CATEGORY_NM, CATEGORY_DES, CATEGORY_ORD, PARENT_CD, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('CSHQ', 'Cuộc sống Hàn Quốc', 'Những bài viết về Hàn Quốc, chía sẽ kinh nghiệm', null, null, 'Y', '2024-03-14 02:48:21', 1, null, null);
INSERT INTO `blog-htngoc`.categories (CATEGORY_CD, CATEGORY_NM, CATEGORY_DES, CATEGORY_ORD, PARENT_CD, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('KNLV', 'Kinh nghiệm làm việc', 'Chia sẽ các bài viết liên quan đến kinh nghiệm làm việc của bản thân', null, null, 'Y', '2024-03-14 02:56:37', 1, null, null);
INSERT INTO `blog-htngoc`.categories (CATEGORY_CD, CATEGORY_NM, CATEGORY_DES, CATEGORY_ORD, PARENT_CD, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('TEST01', 'category test', 'test category 5', null, null, 'Y', '2025-12-04 07:36:57', 1, null, null);
INSERT INTO `blog-htngoc`.categories (CATEGORY_CD, CATEGORY_NM, CATEGORY_DES, CATEGORY_ORD, PARENT_CD, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('TEST01_02', 'category test 01_02', 'test category 5', null, 'TEST01', 'Y', '2025-12-04 09:22:56', 1, null, null);
INSERT INTO `blog-htngoc`.categories (CATEGORY_CD, CATEGORY_NM, CATEGORY_DES, CATEGORY_ORD, PARENT_CD, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('TEST01_03', 'category test 01_03', 'test category 5', null, 'TEST01', 'Y', '2025-12-04 09:24:03', 1, null, null);
