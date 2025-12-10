create table file_relation
(
    ID             int auto_increment
        primary key,
    RELATED_CODE   varchar(20) null,
    RELATED_ID     int         null,
    FILE_MASTER_ID int         null,
    constraint FK_FILE_MASTER_ID
        foreign key (FILE_MASTER_ID) references file_master (ID)
);

INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 1, 29);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 2, 30);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 1, 29);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 2, 30);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('USER', 1, 31);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('USER', 3, 32);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 4, 33);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 4, 33);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 4, 33);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 4, 33);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 4, 33);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 4, 33);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 4, 33);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 5, 36);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 5, 36);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 6, 37);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('USER', 2, 38);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 6, 37);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 6, 37);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 6, 37);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 6, 37);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 6, 37);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 1, 29);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 6, 37);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 7, 41);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 7, 41);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 7, 41);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 7, 41);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 7, 41);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 7, 41);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 7, 41);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 7, 41);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 7, 41);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 7, 41);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 7, 41);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 7, 41);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 7, 41);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 7, 41);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 7, 41);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 7, 41);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 7, 41);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 6, 37);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 6, 37);
INSERT INTO `blog-htngoc`.file_relation (RELATED_CODE, RELATED_ID, FILE_MASTER_ID) VALUES ('POST', 6, 37);
