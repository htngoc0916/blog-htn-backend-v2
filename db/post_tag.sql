create table post_tag
(
    ID      int auto_increment
        primary key,
    POST_ID int                                not null,
    TAG_ID  int                                not null,
    REG_DT  datetime default CURRENT_TIMESTAMP null,
    constraint FK_POST_ID_TAG_ID
        foreign key (POST_ID) references posts (ID),
    constraint FK_TAG_ID_POST_ID
        foreign key (TAG_ID) references tags (ID)
);

