create table posts
(
    ID              int auto_increment
        primary key,
    TITLE           varchar(100)                         not null,
    SLUG            varchar(150)                         null,
    SUMMARY         text                                 null,
    SUMMARY_HTML    text                                 null,
    CONTENT         longtext                             null comment 'HTML / Markdown / JSON',
    PUBLISH_DT      datetime                             null,
    STATUS          varchar(3) default 'DRF'             null comment 'DRF : Draft, PUB : Publish',
    CATEGORY_ID     int                                  not null,
    AUTHOR_ID       int                                  not null,
    EDITOR_ID       int                                  null,
    MEDIA_ID        mediumtext                           null,
    FILE_PATH       varchar(256)                         null,
    FILE_NAME_ORG   varchar(256)                         null,
    FILE_NAME       varchar(256)                         null,
    FILE_NAME_THUMB varchar(256)                         null,
    FILE_NAME_COVER varchar(256)                         null,
    VIEW_CNT        int        default 0                 null,
    COMMENT_CNT     int        default 0                 null,
    LIKE_CNT        int        default 0                 null,
    USED_YN         varchar(1) default 'Y'               null comment 'N: deleted article',
    REG_DT          datetime   default CURRENT_TIMESTAMP null,
    REG_ID          int                                  null,
    MOD_DT          datetime                             null,
    MOD_ID          int                                  null,
    constraint TITLE
        unique (TITLE),
    constraint FK_CATEGORY_POST
        foreign key (CATEGORY_ID) references categories (ID)
);

