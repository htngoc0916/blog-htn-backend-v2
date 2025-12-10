create table group_code_dtl
(
    ID          int auto_increment
        primary key,
    GROUP_CD    varchar(32)                          not null,
    PARENT_CD   varchar(32)                          null,
    CODE_CD     varchar(32)                          not null,
    CODE_NM     varchar(128)                         not null,
    CODE_NM_ENG varchar(128)                         null,
    CODE_DES    varchar(256)                         null,
    CODE_ORD    int                                  null,
    ECT_1       varchar(10)                          null,
    ECT_2       varchar(10)                          null,
    ECT_3       varchar(10)                          null,
    ECT_4       varchar(10)                          null,
    USED_YN     varchar(1) default 'Y'               null,
    REG_DT      datetime   default CURRENT_TIMESTAMP null,
    REG_ID      int                                  null,
    MOD_DT      datetime                             null,
    MOD_ID      int                                  null,
    constraint CODE_CD
        unique (CODE_CD),
    constraint KF_CODE_GROUP_CODE_DETAIL
        foreign key (GROUP_CD) references group_code_mst (GROUP_CD)
);

INSERT INTO `blog-htngoc`.group_code_dtl (GROUP_CD, PARENT_CD, CODE_CD, CODE_NM, CODE_NM_ENG, CODE_DES, CODE_ORD, ECT_1, ECT_2, ECT_3, ECT_4, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('PAGE_STATUS', '', 'PUB', 'Xuất bản', 'PUBLIC', 'Bài viết đã được xuất bản', 1, null, null, null, null, 'Y', '2025-12-09 04:42:45', 1, null, null);
INSERT INTO `blog-htngoc`.group_code_dtl (GROUP_CD, PARENT_CD, CODE_CD, CODE_NM, CODE_NM_ENG, CODE_DES, CODE_ORD, ECT_1, ECT_2, ECT_3, ECT_4, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('PAGE_STATUS', '', 'DRA', 'Bản nháp', 'DRAFT', 'Bài đang viết', 2, null, null, null, null, 'Y', '2025-12-09 04:46:26', 1, null, null);
INSERT INTO `blog-htngoc`.group_code_dtl (GROUP_CD, PARENT_CD, CODE_CD, CODE_NM, CODE_NM_ENG, CODE_DES, CODE_ORD, ECT_1, ECT_2, ECT_3, ECT_4, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('PAGE_STATUS', '', 'REV', 'Đang duyệt', 'REVIEW', 'Bài viết đang duyệt', 3, '', '', '', null, 'Y', '2025-12-09 04:52:37', 1, '2025-12-09 05:27:33', 1);
INSERT INTO `blog-htngoc`.group_code_dtl (GROUP_CD, PARENT_CD, CODE_CD, CODE_NM, CODE_NM_ENG, CODE_DES, CODE_ORD, ECT_1, ECT_2, ECT_3, ECT_4, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('PAGE_STATUS', '', 'DEL', 'Lưu trữ', 'DELETED', 'Bài viết đã được gỡ xuống', 4, null, null, null, null, 'Y', '2025-12-09 04:53:44', 1, null, null);
INSERT INTO `blog-htngoc`.group_code_dtl (GROUP_CD, PARENT_CD, CODE_CD, CODE_NM, CODE_NM_ENG, CODE_DES, CODE_ORD, ECT_1, ECT_2, ECT_3, ECT_4, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('PAGE_STATUS', '', 'REJ', 'Từ chối', 'REJECT', 'Bài viết bị từ chối', 5, null, null, null, null, 'Y', '2025-12-09 04:54:57', 1, null, null);
INSERT INTO `blog-htngoc`.group_code_dtl (GROUP_CD, PARENT_CD, CODE_CD, CODE_NM, CODE_NM_ENG, CODE_DES, CODE_ORD, ECT_1, ECT_2, ECT_3, ECT_4, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('TES_MASTER', '', 'DTL_01', 'test code detail 01', '', '', 0, null, null, null, null, 'Y', '2025-12-09 05:00:50', 1, null, null);
INSERT INTO `blog-htngoc`.group_code_dtl (GROUP_CD, PARENT_CD, CODE_CD, CODE_NM, CODE_NM_ENG, CODE_DES, CODE_ORD, ECT_1, ECT_2, ECT_3, ECT_4, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('TES_MASTER', '', 'DTL_02', 'test code detail 02 __update', 'english name --update', null, 0, '_etc1', '_etc2', '_etc3', null, 'Y', '2025-12-09 05:01:00', 1, '2025-12-09 05:38:01', 1);
INSERT INTO `blog-htngoc`.group_code_dtl (GROUP_CD, PARENT_CD, CODE_CD, CODE_NM, CODE_NM_ENG, CODE_DES, CODE_ORD, ECT_1, ECT_2, ECT_3, ECT_4, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('TES_MASTER', 'DTL_01', 'DTL_01_01', 'test code detail _01_01', '', null, 0, 'etc1', 'etc2', 'etc3', null, 'Y', '2025-12-09 05:03:28', 1, null, null);
INSERT INTO `blog-htngoc`.group_code_dtl (GROUP_CD, PARENT_CD, CODE_CD, CODE_NM, CODE_NM_ENG, CODE_DES, CODE_ORD, ECT_1, ECT_2, ECT_3, ECT_4, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('TES_MASTER', 'DTL_01_01', 'DTL_01_01_01', 'test code detail _01_01_01', '', null, 0, 'etc1', 'etc2', 'etc3', null, 'Y', '2025-12-09 09:30:36', 1, null, null);
INSERT INTO `blog-htngoc`.group_code_dtl (GROUP_CD, PARENT_CD, CODE_CD, CODE_NM, CODE_NM_ENG, CODE_DES, CODE_ORD, ECT_1, ECT_2, ECT_3, ECT_4, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('TES_MASTER', 'DTL_01', 'DTL_01_02', 'test code detail _01_02', '', null, 0, 'etc1', 'etc2', 'etc3', null, 'Y', '2025-12-10 03:58:54', 1, null, null);
