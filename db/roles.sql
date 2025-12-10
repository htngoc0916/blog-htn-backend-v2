create table roles
(
    ID        int auto_increment
        primary key,
    ROLE_NAME varchar(20) not null,
    constraint ROLE_NAME
        unique (ROLE_NAME)
);

INSERT INTO `blog-htngoc`.roles (ROLE_NAME) VALUES ('ROLE_ADMIN');
INSERT INTO `blog-htngoc`.roles (ROLE_NAME) VALUES ('ROLE_USER');
