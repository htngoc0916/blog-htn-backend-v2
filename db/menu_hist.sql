create table menu_hist
(
    ID          int auto_increment
        primary key,
    MENU_ID     int                                not null,
    MENU_CODE   varchar(32)                        not null,
    HIST_TYPE   varchar(1)                         not null comment 'I|U|D',
    BEFORE_DATA json                               null comment 'Dữ liệu menu trước khi thay đổi (JSON)',
    AFTER_DATA  json                               null comment 'Dữ liệu menu sau khi thay đổi (JSON)',
    REG_DT      datetime default CURRENT_TIMESTAMP null,
    REG_ID      int                                null
);

create index idx_menu_hist_changed_dt
    on menu_hist (REG_DT);

create index idx_menu_hist_menu_code
    on menu_hist (MENU_CODE);

create index idx_menu_hist_menu_id
    on menu_hist (MENU_ID);

INSERT INTO `blog-htngoc`.menu_hist (MENU_ID, MENU_CODE, HIST_TYPE, BEFORE_DATA, AFTER_DATA, REG_DT, REG_ID) VALUES (28, 'TEST_MENU_01_04', 'U', '{"id": 28, "modDt": "2025-12-26T06:13:59.000+00:00", "modId": 1, "regDt": "2025-12-23T08:57:42.000+00:00", "regId": 1, "usedYn": null, "menuOrd": 3, "menuUrl": "/static-pages", "menuCode": "TEST_MENU_01_03", "menuIcon": "", "menuName": "QL Trang tĩnh 01_02", "menuType": "TEST", "parentCd": "TEST_MENU_01", "menuNameEng": "Static pages"}', '{"id": 28, "modDt": "2025-12-26T06:13:59.000+00:00", "modId": null, "regDt": "2025-12-23T08:57:42.000+00:00", "regId": null, "usedYn": null, "menuOrd": 3, "menuUrl": "/static-pages", "menuCode": "TEST_MENU_01_04", "menuIcon": "", "menuName": "QL Trang tĩnh 01_04", "menuType": "TEST", "parentCd": "TEST_MENU_01", "menuNameEng": "Static pages 04"}', '2025-12-30 06:09:14', 1);
INSERT INTO `blog-htngoc`.menu_hist (MENU_ID, MENU_CODE, HIST_TYPE, BEFORE_DATA, AFTER_DATA, REG_DT, REG_ID) VALUES (29, 'TEST_MENU_01_05', 'I', null, '{"id": 29, "modDt": null, "modId": null, "regDt": "2025-12-30T06:10:13.854+00:00", "regId": 1, "usedYn": "Y", "menuOrd": 3, "menuUrl": "/static-pages", "menuCode": "TEST_MENU_01_05", "menuIcon": "", "menuName": "QL Trang tĩnh 01_05", "menuType": "TEST", "parentCd": "TEST_MENU_01", "menuNameEng": "Static pages 05"}', '2025-12-30 06:10:14', 1);
