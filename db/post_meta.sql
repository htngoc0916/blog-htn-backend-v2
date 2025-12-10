create table post_meta
(
    ID      int auto_increment
        primary key,
    TITLE   varchar(100) not null,
    SLUG    varchar(150) not null,
    REMARK  varchar(100) null,
    POST_ID int          not null,
    constraint FK_POST_META_POST
        foreign key (POST_ID) references posts (ID)
);

INSERT INTO `blog-htngoc`.post_meta (TITLE, SLUG, REMARK, POST_ID) VALUES ('1. Quy trình thi lấy bằng lái xe ô tô tại Hàn Quốc', '1.-Quy-trinh-thi-lay-bang-lai-xe-o-to-tai-Han-Quoc', null, 1);
INSERT INTO `blog-htngoc`.post_meta (TITLE, SLUG, REMARK, POST_ID) VALUES ('2. Một số lưu ý', '2.-Mot-so-luu-y', null, 1);
INSERT INTO `blog-htngoc`.post_meta (TITLE, SLUG, REMARK, POST_ID) VALUES ('3. Các điểm thi bằng lái được quy định tại Hàn Quốc', '3.-Cac-djiem-thi-bang-lai-djuoc-quy-djinh-tai-Han-Quoc', null, 1);
INSERT INTO `blog-htngoc`.post_meta (TITLE, SLUG, REMARK, POST_ID) VALUES ('1. Ôn phần thi lý thuyết đạt hiệu quả.', '1.-On-phan-thi-ly-thuyet-djat-hieu-qua.', null, 2);
INSERT INTO `blog-htngoc`.post_meta (TITLE, SLUG, REMARK, POST_ID) VALUES ('2. Kinh nghiệm để thi thực hành đạt hiệu quả', '2.-Kinh-nghiem-dje-thi-thuc-hanh-djat-hieu-qua', null, 2);
INSERT INTO `blog-htngoc`.post_meta (TITLE, SLUG, REMARK, POST_ID) VALUES ('1. Frontend Developer là gì? ?', '1.-Frontend-Developer-la-gi', null, 4);
INSERT INTO `blog-htngoc`.post_meta (TITLE, SLUG, REMARK, POST_ID) VALUES ('2. Frontend Developer cần phải học gì??', '2.-Frontend-Developer-can-phai-hoc-gi', null, 4);
INSERT INTO `blog-htngoc`.post_meta (TITLE, SLUG, REMARK, POST_ID) VALUES ('3. Tìm tòi thêm Thư Viện và Framework ?', '3.-Tim-toi-them-Thu-Vien-va-Framework', null, 4);
INSERT INTO `blog-htngoc`.post_meta (TITLE, SLUG, REMARK, POST_ID) VALUES ('4. Cập nhật liên tục kiến thức mới ?', '4.-Cap-nhat-lien-tuc-kien-thuc-moi', null, 4);
INSERT INTO `blog-htngoc`.post_meta (TITLE, SLUG, REMARK, POST_ID) VALUES ('5. Thực hành là chìa khoá thành công ?', '5.-Thuc-hanh-la-chia-khoa-thanh-cong', null, 4);
INSERT INTO `blog-htngoc`.post_meta (TITLE, SLUG, REMARK, POST_ID) VALUES ('6. Không ngừng học hỏi ?', '6.-Khong-ngung-hoc-hoi', null, 4);
INSERT INTO `blog-htngoc`.post_meta (TITLE, SLUG, REMARK, POST_ID) VALUES ('1. ? Nắm Vững Java Cơ Bản và Nâng Cao', '1.-Nam-Vung-Java-Co-Ban-va-Nang-Cao', null, 5);
INSERT INTO `blog-htngoc`.post_meta (TITLE, SLUG, REMARK, POST_ID) VALUES ('2. ? Công Cụ và Môi Trường Phát Triển Phần Mềm (IDE)', '2.-Cong-Cu-va-Moi-Truong-Phat-Trien-Phan-Mem-(IDE)', null, 5);
INSERT INTO `blog-htngoc`.post_meta (TITLE, SLUG, REMARK, POST_ID) VALUES ('3. ?️ Framework và Thư Viện', '3.-Framework-va-Thu-Vien', null, 5);
INSERT INTO `blog-htngoc`.post_meta (TITLE, SLUG, REMARK, POST_ID) VALUES ('4. ?️ Cơ Sở Dữ Liệu và SQL', '4.-Co-So-Du-Lieu-va-SQL', null, 5);
INSERT INTO `blog-htngoc`.post_meta (TITLE, SLUG, REMARK, POST_ID) VALUES ('5. ? API và Dịch Vụ Web', '5.-API-va-Dich-Vu-Web', null, 5);
INSERT INTO `blog-htngoc`.post_meta (TITLE, SLUG, REMARK, POST_ID) VALUES ('6. ? Hiểu Biết về DevOps (nâng cao)', '6.-Hieu-Biet-ve-DevOps-(nang-cao)', null, 5);
INSERT INTO `blog-htngoc`.post_meta (TITLE, SLUG, REMARK, POST_ID) VALUES ('1. Mình Đã Xin Việc Như Thế Nào? ?', '1.-Minh-DJa-Xin-Viec-Nhu-The-Nao', null, 6);
INSERT INTO `blog-htngoc`.post_meta (TITLE, SLUG, REMARK, POST_ID) VALUES ('2. Trang Bị Kiến Thức Cần Thiết Cho Bản Thân ?', '2.-Trang-Bi-Kien-Thuc-Can-Thiet-Cho-Ban-Than', null, 6);
INSERT INTO `blog-htngoc`.post_meta (TITLE, SLUG, REMARK, POST_ID) VALUES ('3. Chuẩn Bị CV Xin Việc ?', '3.-Chuan-Bi-CV-Xin-Viec', null, 6);
INSERT INTO `blog-htngoc`.post_meta (TITLE, SLUG, REMARK, POST_ID) VALUES ('4. Tìm Kiếm Cơ Hội ?️‍♀️', '4.-Tim-Kiem-Co-Hoi', null, 6);
INSERT INTO `blog-htngoc`.post_meta (TITLE, SLUG, REMARK, POST_ID) VALUES ('5. Kết Luận', '5.-Ket-Luan', null, 6);
INSERT INTO `blog-htngoc`.post_meta (TITLE, SLUG, REMARK, POST_ID) VALUES ('1. Phần Cơ Bản: Nền tảng cần nắm vững', '1.-Phan-Co-Ban:-Nen-tang-can-nam-vung', null, 7);
INSERT INTO `blog-htngoc`.post_meta (TITLE, SLUG, REMARK, POST_ID) VALUES ('2.  Phần Tiếp Theo ?', '2.-Phan-Tiep-Theo', null, 7);
INSERT INTO `blog-htngoc`.post_meta (TITLE, SLUG, REMARK, POST_ID) VALUES ('3. Phần Nâng Cao ?', '3.-Phan-Nang-Cao', null, 7);
INSERT INTO `blog-htngoc`.post_meta (TITLE, SLUG, REMARK, POST_ID) VALUES ('Lời Kết  ?', 'Loi-Ket', null, 7);
