create table comments
(
    ID            int auto_increment
        primary key,
    COMMENT_NAME  varchar(50)                          not null,
    COMMENT_EMAIL varchar(100)                         not null,
    CONTENT       varchar(1000)                        null,
    POST_ID       int                                  not null,
    USED_YN       varchar(1) default 'Y'               null,
    REG_DT        datetime   default CURRENT_TIMESTAMP null,
    REG_ID        int                                  null,
    MOD_DT        datetime                             null,
    MOD_ID        int                                  null,
    constraint FK_POST_COMMENT
        foreign key (POST_ID) references posts (ID)
);

