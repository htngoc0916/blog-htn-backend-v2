create table post_tag
(
    POST_ID int not null,
    TAG_ID  int not null,
    primary key (POST_ID, TAG_ID),
    constraint FK_POST_ID_TAG_ID
        foreign key (POST_ID) references posts (ID),
    constraint FK_TAG_ID_POST_ID
        foreign key (TAG_ID) references tags (ID)
);

INSERT INTO `blog-htngoc`.post_tag (POST_ID, TAG_ID) VALUES (5, 1);
INSERT INTO `blog-htngoc`.post_tag (POST_ID, TAG_ID) VALUES (7, 1);
INSERT INTO `blog-htngoc`.post_tag (POST_ID, TAG_ID) VALUES (4, 2);
INSERT INTO `blog-htngoc`.post_tag (POST_ID, TAG_ID) VALUES (5, 3);
INSERT INTO `blog-htngoc`.post_tag (POST_ID, TAG_ID) VALUES (7, 3);
INSERT INTO `blog-htngoc`.post_tag (POST_ID, TAG_ID) VALUES (1, 6);
INSERT INTO `blog-htngoc`.post_tag (POST_ID, TAG_ID) VALUES (2, 6);
INSERT INTO `blog-htngoc`.post_tag (POST_ID, TAG_ID) VALUES (1, 7);
INSERT INTO `blog-htngoc`.post_tag (POST_ID, TAG_ID) VALUES (2, 7);
INSERT INTO `blog-htngoc`.post_tag (POST_ID, TAG_ID) VALUES (6, 8);
INSERT INTO `blog-htngoc`.post_tag (POST_ID, TAG_ID) VALUES (6, 9);
