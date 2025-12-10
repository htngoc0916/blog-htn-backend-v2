create table group_code_mst
(
    ID           int auto_increment
        primary key,
    GROUP_CD     varchar(32)                          not null,
    GROUP_NM     varchar(128)                         null,
    GROUP_NM_ENG varchar(32)                          null,
    GROUP_LENGTH int                                  null,
    GROUP_DES    varchar(256)                         null,
    GROUP_ORD    int                                  null,
    USED_YN      varchar(1) default 'Y'               null,
    REG_DT       datetime   default CURRENT_TIMESTAMP null,
    REG_ID       int                                  null,
    MOD_DT       datetime                             null,
    MOD_ID       int                                  null,
    constraint GROUP_CD
        unique (GROUP_CD)
);

INSERT INTO `blog-htngoc`.group_code_mst (GROUP_CD, GROUP_NM, GROUP_NM_ENG, GROUP_LENGTH, GROUP_DES, GROUP_ORD, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('PAGE_STATUS', 'Trạng thái bài viết', null, 3, 'DRF: (Draft) Bản nháp, SUB: (Submitted) Đã gửi duyệt, REJ: (Rejected) Bị trả về / Từ chối, APP: (Approved) Được duyệt, PUB: (Published) Đã xuất bản, UNP: (Unpublished) Gỡ xuống', 1, 'Y', '2025-12-05 07:53:29', 1, null, null);
INSERT INTO `blog-htngoc`.group_code_mst (GROUP_CD, GROUP_NM, GROUP_NM_ENG, GROUP_LENGTH, GROUP_DES, GROUP_ORD, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('TAG_COLORS', 'Màu của thẻ tags', null, 32, '', 2, 'Y', '2025-12-05 07:56:59', 1, null, null);
INSERT INTO `blog-htngoc`.group_code_mst (GROUP_CD, GROUP_NM, GROUP_NM_ENG, GROUP_LENGTH, GROUP_DES, GROUP_ORD, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('TES_MASTER', 'test code mst', null, 15, '', 4, 'Y', '2025-12-09 04:58:40', 1, null, null);
