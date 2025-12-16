create table media_relation
(
    ID            bigint auto_increment
        primary key,
    MEDIA_ID      bigint                               not null,
    RELATION_ID   bigint                               not null,
    RELATION_CD   varchar(32)                          not null comment 'USER | POST | CATEGORY | BANNER',
    RELATION_TYPE varchar(30)                          not null comment 'Mục đích: AVATAR | THUMBNAIL | COVER | CONTENT',
    MEDIA_ORDER   int        default 0                 null,
    IS_PRIMARY    varchar(1) default 'N'               null comment 'avatar chính, thumbnail chính',
    REG_DT        datetime   default CURRENT_TIMESTAMP null,
    constraint FK_MEDIA_RELATION_MASTER
        foreign key (MEDIA_ID) references media_master (ID)
);

