create table media_master
(
    ID            bigint auto_increment
        primary key,
    FILE_TITLE    varchar(256)                         null,
    FILE_PATH     varchar(255)                         not null,
    FILE_NAME     varchar(255)                         not null comment 'Tên file unique, đã rename',
    FILE_NAME_ORG varchar(255)                         not null comment 'Tên file gốc',
    FILE_TYPE     varchar(20)                          null comment 'Đuôi file',
    FILE_SIZE     bigint     default 0                 null,
    MEDIA_TYPE    varchar(100)                         null comment 'image, video, audio, file',
    STORAGE_TYPE  varchar(20)                          null comment 'NAS | S3 | GCS',
    WIDTH         int                                  null comment 'Chiều rộng (pixel), chỉ áp dụng cho IMAGE',
    HEIGHT        int                                  null comment 'Chiều cao (pixel), chỉ áp dụng cho IMAGE',
    DURATION      float                                null comment 'Thời lượng (giây), chỉ áp dụng cho VIDEO / AUDIO',
    USED_YN       varchar(1) default 'Y'               null comment 'N: deleted, Y: active',
    REG_DT        datetime   default CURRENT_TIMESTAMP null,
    REG_ID        int                                  null,
    MOD_DT        datetime                             null,
    MOD_ID        int                                  null
);

