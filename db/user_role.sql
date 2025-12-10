create table user_role
(
    user_id int not null,
    role_id int not null,
    primary key (user_id, role_id),
    constraint FK_ROLE_ID_USER_ID
        foreign key (role_id) references roles (ID),
    constraint FK_USER_ID_ROLE_ID
        foreign key (user_id) references users (ID)
);

INSERT INTO `blog-htngoc`.user_role (user_id, role_id) VALUES (4, 1);
INSERT INTO `blog-htngoc`.user_role (user_id, role_id) VALUES (5, 1);
INSERT INTO `blog-htngoc`.user_role (user_id, role_id) VALUES (6, 1);
INSERT INTO `blog-htngoc`.user_role (user_id, role_id) VALUES (29, 1);
INSERT INTO `blog-htngoc`.user_role (user_id, role_id) VALUES (43, 1);
INSERT INTO `blog-htngoc`.user_role (user_id, role_id) VALUES (44, 1);
INSERT INTO `blog-htngoc`.user_role (user_id, role_id) VALUES (45, 1);
INSERT INTO `blog-htngoc`.user_role (user_id, role_id) VALUES (46, 1);
INSERT INTO `blog-htngoc`.user_role (user_id, role_id) VALUES (47, 1);
INSERT INTO `blog-htngoc`.user_role (user_id, role_id) VALUES (48, 1);
INSERT INTO `blog-htngoc`.user_role (user_id, role_id) VALUES (49, 1);
INSERT INTO `blog-htngoc`.user_role (user_id, role_id) VALUES (50, 1);
INSERT INTO `blog-htngoc`.user_role (user_id, role_id) VALUES (51, 1);
INSERT INTO `blog-htngoc`.user_role (user_id, role_id) VALUES (52, 1);
INSERT INTO `blog-htngoc`.user_role (user_id, role_id) VALUES (53, 1);
INSERT INTO `blog-htngoc`.user_role (user_id, role_id) VALUES (54, 1);
INSERT INTO `blog-htngoc`.user_role (user_id, role_id) VALUES (55, 1);
INSERT INTO `blog-htngoc`.user_role (user_id, role_id) VALUES (56, 1);
INSERT INTO `blog-htngoc`.user_role (user_id, role_id) VALUES (57, 1);
INSERT INTO `blog-htngoc`.user_role (user_id, role_id) VALUES (58, 1);
INSERT INTO `blog-htngoc`.user_role (user_id, role_id) VALUES (59, 1);
INSERT INTO `blog-htngoc`.user_role (user_id, role_id) VALUES (60, 1);
INSERT INTO `blog-htngoc`.user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO `blog-htngoc`.user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO `blog-htngoc`.user_role (user_id, role_id) VALUES (3, 2);
