create table contacts
(
    ID           int auto_increment
        primary key,
    CONTACT_CODE varchar(20)                          not null,
    EMAIL        varchar(100)                         not null,
    FULL_NAME    varchar(50)                          null,
    CONTENT      varchar(500)                         null,
    REPLY_YN     varchar(1) default 'N'               null,
    USED_YN      varchar(1) default 'Y'               null,
    REG_DT       datetime   default CURRENT_TIMESTAMP null,
    REG_ID       int                                  null,
    MOD_DT       datetime                             null,
    MOD_ID       int                                  null
);

INSERT INTO `blog-htngoc`.contacts (CONTACT_CODE, EMAIL, FULL_NAME, CONTENT, REPLY_YN, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('CONTACT', 'htngoc@gmail.com', null, 'tôi muốn liên hệ với bạn', 'N', null, '2024-03-26 07:55:32', null, null, null);
INSERT INTO `blog-htngoc`.contacts (CONTACT_CODE, EMAIL, FULL_NAME, CONTENT, REPLY_YN, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('CONTACT', 'spamabc@gmail.com', null, 'Demo nhập thử có nhận được mail không.', 'N', null, '2024-05-13 19:14:07', null, null, null);
INSERT INTO `blog-htngoc`.contacts (CONTACT_CODE, EMAIL, FULL_NAME, CONTENT, REPLY_YN, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('CONTACT', 'spamabc@gmail.com', null, 'Demo nhập thử có nhận được mail không.', 'N', null, '2024-05-13 19:22:58', null, null, null);
