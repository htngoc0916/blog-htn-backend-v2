create table posts
(
    ID           int auto_increment
        primary key,
    TITLE        varchar(100)                         not null,
    SLUG         varchar(150)                         null,
    DESCRIPTION  varchar(255)                         null,
    CONTENT      text                                 null,
    VIEW_CNT     int        default 0                 null,
    CATEGORY_ID  int                                  null,
    THUMBNAIL    varchar(255)                         null,
    THUMBNAIL_ID int                                  null,
    USER_ID      int                                  null,
    USED_YN      varchar(1) default 'Y'               null,
    REG_DT       datetime   default CURRENT_TIMESTAMP null,
    REG_ID       int                                  null,
    MOD_DT       datetime                             null,
    MOD_ID       int                                  null,
    constraint TITLE
        unique (TITLE),
    constraint FK_CATEGORY_POST
        foreign key (CATEGORY_ID) references categories (ID)
);

INSERT INTO `blog-htngoc`.posts (TITLE, SLUG, DESCRIPTION, CONTENT, VIEW_CNT, CATEGORY_ID, THUMBNAIL, THUMBNAIL_ID, USER_ID, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('Thi bằng lái xe ô tô tại Hàn Quốc - Đỗ 100% [part_1]', 'thi-bang-lai-xe-o-to-tai-han-quoc-djo-100percent-part_1', 'Bài viết này mình xin chia sẻ kinh nghiệm của bản thân đã thi bằng lái xe ôtô tại Hàn Quốc, mong rằng sẽ hữu ích cho các bạn.', '<p class="post-meta">Một số lưu &yacute; trước khi tham gia thi bằng l&aacute;i</p>
<blockquote>
<p class="post-meta"><strong>C&oacute; 2 loại bằng l&aacute;i thường đăng k&yacute; nhất l&agrave;:</strong></p>
<p>제1종보통: xe dưới 15 chỗ ngồi, c&oacute; trọng tải dưới 10 tấn.</p>
<p>제2종보통: xe dưới 10 chỗ ngồi, c&oacute; trọng tải dưới 3.5 tấn. (Đ&acirc;y l&agrave; loại bằng phổ biến nhất được đa số người lựa chọn nhất)</p>
</blockquote>
<h3 id="1.-Quy-trinh-thi-lay-bang-lai-xe-o-to-tai-Han-Quoc" class="post-meta">1. Quy tr&igrave;nh thi lấy bằng l&aacute;i xe &ocirc; t&ocirc; tại H&agrave;n Quốc</h3>
<p>Trước ti&ecirc;n bạn h&atilde;y t&igrave;m đến trung t&acirc;m s&aacute;t hạch bằng l&aacute;i xe gần nhất, c&oacute; thể t&igrave;m kiếm từ kh&oacute;a 면허시험장 tr&ecirc;n naver map, kakao map...vvv</p>
<p>Tại đ&acirc;y, Bạn sẽ phải l&agrave;m tuần tự c&aacute;c bước như sau:</p>
<p><img style="display: block; margin-left: auto; margin-right: auto;" src="https://res.cloudinary.com/blog-htn/image/upload/v1710394931/images/1710394930481_9f52ca1612df4ce9bfc23a693c801a0e.png" width="954" height="639"></p>
<p>&nbsp;</p>
<p><strong>Bước 1: Học an to&agrave;n giao th&ocirc;ng trước khi ứng thi</strong></p>
<p>Ở bước n&agrave;y, bạn sẽ phải học an to&agrave;n giao th&ocirc;ng trong v&ograve;ng 1 tiếng. Tại trung t&acirc;m s&aacute;t hạch bạn t&igrave;m đến ph&ograve;ng 교통안전 교육장 thời gian bắt đầu học an to&agrave;n v&agrave;o l&uacute;c 9h30. Bắt buộc phải mang theo thẻ cư tr&uacute; người nước ngo&agrave;i để đăng k&yacute;.<br>Lệ ph&iacute;: miễn ph&iacute;</p>
<p><strong>Bước 2: Kiểm tra thể chất</strong></p>
<ul>
<li>Sau khi ho&agrave;n th&agrave;nh bước 1, bạn sẽ được ph&aacute;t cho phiếu đăng k&yacute; dự thi. H&atilde;y điền đầy đủ th&ocirc;ng tin v&agrave;o phiếu, sau đ&oacute; bạn t&igrave;m đến ph&ograve;ng 신체검사 để kiểm tra t&igrave;nh trạng thể chất. C&aacute;c mục kiểm tra bao gồm kiểm tra mắt, c&acirc;n nặng, chiều cao, kiểm tra xem tay ch&acirc;n c&oacute; bị dị tật hay kh&ocirc;ng</li>
<li>Bạn cần phải chuẩn bị 3 ảnh 4x6 trong đ&oacute; 2 ảnh để l&agrave;m hồ sơ v&agrave; 1 ảnh c&ograve;n lại sau khi nhận bằng bạn sẽ nộp tiếp. Nếu bạn qu&ecirc;n kh&ocirc;ng mang theo ảnh th&igrave; c&oacute; thể chụp tại địa điểm thi.</li>
<li>Lệ ph&iacute;: 6,000 krw</li>
</ul>
<p><strong>Bước 3: Phần thi l&yacute; thuyết bằng l&aacute;i xe &ocirc; t&ocirc;</strong></p>
<ul>
<li>Đ&acirc;y l&agrave; phần thi kh&oacute; nhất đối với một số bạn kh&ocirc;ng c&oacute; thời gian nhiều để &ocirc;n trước bộ đề. B&agrave;i viết sau m&igrave;nh sẽ chia sẽ tiếp về phước ph&aacute;p &ocirc;n luyện thi l&yacute; thuyết hiệu quả v&agrave; một số mẹo để nhớ được l&acirc;u c&aacute;c đ&aacute;p &aacute;n.</li>
<li>V&igrave; thưởng buổi s&aacute;ng bắt đầu thi l&yacute; thuyết v&agrave;o l&uacute;c 11h30 n&ecirc;n khi bạn học xong lớp an to&agrave;n giao th&ocirc;ng (Bước 1) th&igrave; thời gian c&ograve;n lại sẽ kh&ocirc;ng c&ograve;n nhiều. Sau khi bạn kiểm tra thể chất ở bước số 2 xong th&igrave; n&ecirc;n nhanh ch&oacute;ng v&agrave;o đăng k&yacute; dự thi l&yacute; thuyết.</li>
<li>Phần thi l&yacute; thuyết sẽ thi tr&ecirc;n m&aacute;y t&iacute;nh, bao gồm 40 c&acirc;u hỏi trong v&ograve;ng 30 ph&uacute;t. Bạn c&oacute; thể lựa chọn ng&ocirc;n ngữ tiếng việt để thi. Trong l&uacute;c l&agrave;m b&agrave;i thi nếu như c&ograve;n thừa thời gian, bạn c&oacute; thể quay lại c&aacute;c c&acirc;u hỏi đ&atilde; chọn trước đ&oacute; m&agrave; m&igrave;nh chưa chắc chắn để c&oacute; thể đọc kỷ lại một lần nữa trước khi nộp b&agrave;i.</li>
<li>Sau khi nộp b&agrave;i th&igrave; sẽ c&oacute; liền kết quả hiển thị số điểm tr&ecirc;n m&agrave;n h&igrave;nh. Bạn sẽ biết được cuộc đời nở hoa hay cuộc sống bế tắc ngay sau khi nhấn v&agrave;o n&uacute;t nộp b&agrave;i. Đối với bằng l&aacute;i 1종보통 bạn phải đạt được 70/100đ v&agrave; 2종보통 th&igrave; bạn chỉ cần đạt được 60/100đ th&igrave; coi như đ&atilde; đậu.</li>
<li>Lệ ph&iacute;: 10,000 krw</li>
<li>Nếu như thi trượt: sẽ phải mất 01 ng&agrave;y sau mới c&oacute; thể thi lại.</li>
<li>Nếu như thi đậu: Bạn sẽ c&oacute; 2 lựa chọn như sau:</li>
</ul>
<p style="padding-left: 40px;"><em>Trường hợp 1: </em>&nbsp;Đối với người chưa biết l&aacute;i xe th&igrave; n&ecirc;n t&igrave;m đến c&aacute;c trung t&acirc;m dạy l&aacute;i xe 운전전문학원 gần nh&agrave; nhất để đăng k&yacute; v&agrave; l&agrave;m thủ tục nhập học rồi sau đ&oacute; tiến h&agrave;nh thi thực h&agrave;nh lu&ocirc;n tại trung t&acirc;m m&agrave; m&igrave;nh đăng k&yacute;.</p>
<p style="padding-left: 40px;">Như m&igrave;nh cũng chọn phương &aacute;n n&agrave;y, sau khi thi đậu phần l&yacute; thuyết được 96đ/100đ. M&igrave;nh sẽ l&ecirc;n mạng v&agrave; t&igrave;m hiểu một số 학원 để học sau đ&oacute; tiến h&agrave;nh thi thực h&agrave;nh tại trung tr&acirc;m m&agrave; m&igrave;nh đ&atilde; đăng k&yacute; lu&ocirc;n.</p>
<p style="padding-left: 40px;">L&agrave;m như vậy bạn sẽ c&oacute; thể quen đường thi v&igrave; đ&atilde; được luyện tập trước đ&oacute; nhiều lần, mặc d&ugrave; ph&iacute; học c&oacute; đắt hơn một ch&uacute;t.</p>
<p style="padding-left: 40px;"><em>Trường hợp 2: </em>&nbsp;Đối với người đ&atilde; biết l&aacute;i xe trước đ&oacute;, v&agrave; tự tin v&agrave;o khả năng của bản th&acirc;n th&igrave; c&oacute; thể đăng k&yacute; thi thực h&agrave;nh lu&ocirc;n trong ng&agrave;y.</p>
<p><strong>Bước 4: Phần thi kỹ năng trong s&acirc;n</strong></p>
<ul>
<li>Đối với phần thi n&agrave;y bạn n&ecirc;n l&ecirc;n youtube t&igrave;m hiểu trước về nội dung thi của phần thi n&agrave;y để khỏi bở ngỡ.</li>
<li>Nội dung thi bao gồm: Phần thi khởi động xe: bật đ&egrave;n pha + đ&egrave;n trước + đ&egrave;n sau, bật đ&egrave;n xi nhanh, cần gạt nước, cần số. Bạn sẽ thực hiện ngẫu nhi&ecirc;n 2 trong số c&aacute;c mục tr&ecirc;n. Phần thi khi xe di chuyển: cho xe di chuyển, dừng khẩn cấp, dừng đ&egrave;n đỏ, rẽ tr&aacute;i, rẽ phải, đỗ xe.</li>
<li>M&aacute;y t&iacute;nh tự động chấm điểm v&agrave; cần đạt tối thiểu 80đ/ 100đ.</li>
<li>Lệ ph&iacute;: 22,000 krw đối với loại bằng phổ th&ocirc;ng 1, 2</li>
<li>Nếu trượt chờ 03 ng&agrave;y để thi lại.</li>
</ul>
<p><strong>Bước 5: Cấp bằng l&aacute;i xe tạm thời</strong></p>
<ul>
<li>Sau khi thi đậu phần thi kỹ năng bạn quay lại quầy đăng k&yacute; để cấp bằng l&aacute;i xe tạm thời 연습면허 c&oacute; hạn trong v&ograve;ng 1 năm (lệ ph&iacute; 4,000 krw).</li>
</ul>
<p><strong>Bước 6: Phần thi l&aacute;i xe ngo&agrave;i đường</strong></p>
<ul>
<li>Đ&acirc;y l&agrave; phần thi kh&oacute; nhất, v&igrave; c&oacute; 4 đường A,B,C,D bạn buộc phải chọn ngẫu nhi&ecirc;n 1 trong 4 đường được quy định để thi bằng việc nhấn n&uacute;t chọn tr&ecirc;n m&aacute;y t&iacute;nh, tr&uacute;ng đoạn đường n&agrave;o thi đoạn đường đ&oacute; kh&ocirc;ng được ph&eacute;p đổi. Bạn n&ecirc;n t&igrave;m hiểu trước về c&aacute;c video hướng dẫn l&aacute;i xe theo c&aacute;c đoạn đường đ&atilde; quy đinh đ&oacute; để đạt được kết quả tốt. Mỗi trung t&acirc;m thi sẽ c&oacute; c&aacute;c đoạn đường kh&aacute;c nhau.</li>
<li>Lệ ph&iacute;: 25,000 krw / lần thi</li>
<li>Nếu thi trượt: Bạn cần phải chờ 03 ng&agrave;y sau mới c&oacute; thể thi lại.</li>
</ul>
<p><strong>Bước 7: Cấp ph&aacute;t bằng l&aacute;i xe</strong></p>
<ul>
<li>Sau khi đ&otilde; phần thi ngo&agrave;i đường. Bạn cầm theo bảng điểm đi đến trung t&acirc;m để nhận bằng.</li>
<li>Nộp th&ecirc;m 01 ảnh c&ograve;n lại để nhận bằng.</li>
<li>Lệ ph&iacute;: 8,000 krw</li>
</ul>
<h3 id="2.-Mot-so-luu-y" class="post-meta">2. Một số lưu &yacute;</h3>
<p>- Nhớ mang theo thẻ người nước ngo&agrave;i trước khi đi thi</p>
<p>- Phần thi l&yacute; thuyết kh&ocirc;ng kh&oacute;, nếu kh&ocirc;ng c&oacute; thời gian nhiều. Bạn chỉ cần xem qua trước c&aacute;c c&acirc;u hỏi về tranh, h&igrave;nh ảnh, biển b&aacute;o, v&agrave; video trong bộ đề thi, c&ograve;n nếu c&oacute; thời gian bạn n&ecirc;n xem qua một lần tất cả c&aacute;c c&acirc;u hỏi trong bộ đề thi ly thuyết gồm 1000 c&acirc;u.</p>
<p>- Phần thi thực h&agrave;nh: xem trước c&aacute;c video hướng dẫn, học thuộc c&aacute;c quy tăc chuẩn bị kiểm tra trước khi bắt đầu phần thi v&agrave; c&aacute;ch thức khởi động xe.</p>
<p>- Chỉ c&oacute; phần thi cuối c&ugrave;ng - phần thi ngo&agrave;i đường l&agrave; kh&oacute; c&ograve;n lại kh&aacute; dễ.&nbsp;</p>
<h3 id="3.-Cac-djiem-thi-bang-lai-djuoc-quy-djinh-tai-Han-Quoc" class="post-meta">3. C&aacute;c điểm thi bằng l&aacute;i được quy định tại H&agrave;n Quốc</h3>
<p>Bạn c&oacute; thể kiểm tra c&aacute;c địa điểm <a title="C&aacute;c địa điểm thi bằng l&aacute;i xe" href="https://www.safedriving.or.kr/main.do" target="_blank" rel="noopener">tại đ&acirc;y</a></p>
<p><img style="display: block; margin-left: auto; margin-right: auto;" src="https://res.cloudinary.com/blog-htn/image/upload/v1710393331/images/1710393330758_031843a5f2454fb2a2e5ca7c1b9d6722.png"></p>
<p>Hoặc bạn c&oacute; thể l&ecirc;n bản đồ v&agrave; nhập từ kh&oacute;a sau: 운전면허시험장 t&igrave;m đia điểm gần nhất để đăng k&yacute; thi bằng l&aacute;i xe.</p>
<p><img style="display: block; margin-left: auto; margin-right: auto;" src="https://res.cloudinary.com/blog-htn/image/upload/v1713334889/images/1713334886816_d8556ae72e0a43e2917b6bfc96b8b00d.png" width="1012" height="487"></p>
<p>&nbsp;</p>
<p>Ch&uacute;c c&aacute;c bạn th&agrave;nh c&ocirc;ng ?</p>
<p>&nbsp;</p>
<div class="ddict_btn" style="top: 900px; left: 473.812px;">&nbsp;</div>
<div class="ddict_btn" style="top: 1163px; left: 651.625px;">&nbsp;</div>
<div class="ddict_btn" style="top: 1368px; left: 174.012px;">&nbsp;</div>', 590, 5, '20240514/1715667361877_0b8419335bf84b67a1dfa7825dcdd925.jpg', 29, 1, 'Y', '2024-03-14 04:47:29', 1, '2024-05-22 02:17:11', 3);
INSERT INTO `blog-htngoc`.posts (TITLE, SLUG, DESCRIPTION, CONTENT, VIEW_CNT, CATEGORY_ID, THUMBNAIL, THUMBNAIL_ID, USER_ID, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('Thi bằng lái xe ô tô tại Hàn Quốc - Đỗ 100% [part_2]', 'thi-bang-lai-xe-o-to-tai-han-quoc-djo-100percent-part_2', 'Bài viết này mình xin chia sẻ về kinh nghiệm thi bằng lái, một số mẹo thi lý thuyết và thực hành đề có thể đậu một cách dễ dàng.', '<p>B&agrave;i viết trước m&igrave;nh đ&atilde; chia sẻ về c&aacute;c bước để tiến h&agrave;nh đăng k&yacute; thi bằng l&aacute;i xe &ocirc; t&ocirc; tại H&agrave;n Quốc v&agrave; cũng như một số quy định v&agrave; lưu &yacute; trước khi thi bằng l&aacute;i.&nbsp;<br>Tham khảo b&agrave;i viết trước tại đ&acirc;y <a title="Thi bằng l&aacute;i xe &ocirc;-t&ocirc; tại H&agrave;n Quốc đỗ 100% - [Part 1]" href="../../post/thi-bang-lai-xe-o-to-tai-han-quoc-djo-100percent-part-1" target="_blank" rel="noopener">click v&agrave;o đ&acirc;y</a> để c&oacute; thể hiểu về quy tr&igrave;nh thi bằng l&aacute;i xe.</p>
<p>B&acirc;y giờ ch&uacute;ng ta c&ugrave;ng đi tiếp n&agrave;o. Les\'t go ?</p>
<h3 id="1.-On-phan-thi-ly-thuyet-djat-hieu-qua." class="post-meta">1. &Ocirc;n phần thi l&yacute; thuyết đạt hiệu quả.</h3>
<p>Đầu ti&ecirc;n để &ocirc;n tập hiệu quả, bạn n&ecirc;n tải app 운전명허 plush theo đường link sau đ&acirc;y</p>
<p>- ios&nbsp;<a title="운전명허 plush tr&ecirc;n điện thoại iphone" href="https://apps.apple.com/kr/app/%EC%9A%B4%EC%A0%84%EB%A9%B4%ED%97%88-plus-%EC%9A%B4%EC%A0%84%EB%A9%B4%ED%97%88-%ED%95%84%EA%B8%B0%EC%8B%9C%ED%97%98-2024%EC%B5%9C%EC%8B%A0%ED%8C%90/id644223359" target="_blank" rel="noopener">tải app 운전명허 plush</a> (điện thoại iphone)</p>
<p>- android&nbsp;<a title="tải app 운전명허 plush tr&ecirc;n điện thoại android" href="https://play.google.com/store/apps/details?id=com.adrock.driverlicense300&amp;hl=ko&amp;gl=US&amp;pli=1" target="_blank" rel="noopener">tải app 운전명허 plush</a></p>
<p>Bạn mở app vừa tải xong, sẽ c&oacute; c&aacute;c phần như sau:<br><img style="display: block; margin-left: auto; margin-right: auto;" src="https://res.cloudinary.com/blog-htn/image/upload/v1713505362/images/1713505362313_a99d6534127447618b88b1f83f63babf.png" width="296" height="599"></p>
<p><strong>Mục 1:&nbsp; 유형벌 학습하기 -&nbsp; &Ocirc;n luyện bộ đề thi</strong></p>
<p>Phần n&agrave;y l&agrave; to&agrave;n bộ đề thi l&yacute; thuyết l&aacute;i xe, bao gồm 1000 c&acirc;u hỏi, click v&agrave;o bạn sẽ thấy bộ đề thi như sau:</p>
<p><img style="display: block; margin-left: auto; margin-right: auto;" src="https://res.cloudinary.com/blog-htn/image/upload/v1713840521/images/1713840520132_9c414a27f9dd4e49bdf247675f2f56c7.png" width="402" height="405"></p>
<ul>
<li>C&acirc;u hỏi t&igrave;nh huống - (513 c&acirc;u hỏi) C&oacute; 4 đ&aacute;p &aacute;n / chọn 1 đ&aacute;p &aacute;n đ&uacute;ng. Mỗi c&acirc;u trả lời đ&uacute;ng được 2điểm.&nbsp;</li>
<li>C&acirc;u hỏi t&igrave;nh huống - (97 c&acirc;u hỏi) C&oacute; 5 đ&aacute;p &aacute;n / chọn 2 đ&aacute;p &aacute;n đ&uacute;ng. Mỗi c&acirc;u trả lời đ&uacute;ng được 3điểm.</li>
<li>C&acirc;u hỏi bức ảnh - (100 c&acirc;u hỏi) C&oacute; 5 đ&aacute;p &aacute;n / chọn 2 đ&aacute;p &aacute;n đ&uacute;ng. Mỗi c&acirc;u trả lời đ&uacute;ng được 3điểm. Đ&acirc;y l&agrave; mục c&acirc;u hỏi về c&aacute;c t&igrave;nh huống được chụp bằng ảnh thực tế ngo&agrave;i đường.</li>
<li>C&acirc;u hỏi bức tranh - (85 c&acirc;u hỏi) C&oacute; 5 đ&aacute;p &aacute;n / chọn 2 đ&aacute;p &aacute;n đ&uacute;ng. Mỗi c&acirc;u trả lời đ&uacute;ng được 3điểm. Đ&acirc;y l&agrave; mục c&acirc;u hỏi về c&aacute;c t&igrave;nh huống được vẽ lại bằng tranh.</li>
<li>C&acirc;u hỏi b&igrave;a an to&agrave;n - (100 c&acirc;u hỏi) C&oacute; 4 đ&aacute;p &aacute;n / chọn 1 đ&aacute;p &aacute;n đ&uacute;ng. Mỗi c&acirc;u trả lời đ&uacute;ng được 2điểm. Đ&acirc;y l&agrave; c&aacute;c c&acirc;u hỏi về c&aacute;c biển b&aacute;o khi tham gia giao th&ocirc;ng.</li>
<li>C&acirc;u hỏi video - (35 c&acirc;u hỏi) C&oacute; 4 đ&aacute;p &aacute;n / chọn 1 đ&aacute;p &aacute;n đ&uacute;ng. Mỗi c&acirc;u trả lời đ&uacute;ng được 5điểm. Đ&acirc;y l&agrave; c&acirc;u hỏi về c&aacute;c t&igrave;nh huống c&oacute; thể xảy ra khi tham gia giao th&ocirc;ng được được dựng th&agrave;nh video.</li>
</ul>
<p><strong>Mục 2: 급할때 200문제 - Học nhanh 200 c&acirc;u hỏi.</strong></p>
<p>Nh&igrave;n t&ecirc;n l&agrave; c&aacute;c bạn đ&atilde; biết mục n&agrave;y l&agrave; g&igrave; rồi phải kh&ocirc;ng? V&acirc;ng, đ&acirc;y ch&iacute;nh l&agrave; mục chứa c&aacute;c c&acirc;u hỏi thường xuy&ecirc;n xuất hiện khi thi. D&agrave;nh cho c&aacute;c bạn kh&ocirc;ng c&oacute; nhiều thời gian để &ocirc;n to&agrave;n bộ đề thi l&yacute; thuyết thi bằng l&aacute;i xe &ocirc; t&ocirc; tại H&agrave;n Quốc, c&oacute; thể v&agrave;o học nhanh mục n&agrave;y để đi thi.</p>
<p><strong>Mục 3: 모의고사 - Thi thử<br></strong>Bạn c&oacute; thể v&agrave;o mục n&agrave;y để thi thử trước một v&agrave;i lần trước khi thi ch&iacute;nh thức để xem kết quả của bạn đạt được bao nhi&ecirc;u điểm. V&agrave; cần phải khắc phục th&ecirc;m những phần n&agrave;o.</p>
<p>Bấm v&agrave;o chữ <code><span style="background-color: rgb(185, 106, 217);">&nbsp;GO&nbsp;</span></code> để bắt đầu&nbsp;</p>
<p><img style="display: block; margin-left: auto; margin-right: auto;" src="https://res.cloudinary.com/blog-htn/image/upload/v1713845354/images/1713845352851_a96f5755dbb9461f8144e769ef14a5fd.png" width="341" height="480"></p>
<p>Mỗi lần thi thử sẽ c&oacute; 40 c&acirc;u hỏi trong v&ograve;ng 40 ph&uacute;t.</p>
<p><img style="display: block; margin-left: auto; margin-right: auto;" src="https://res.cloudinary.com/blog-htn/image/upload/v1713841168/images/1713841165597_53d7d536a1d847ed8e13c169312f0055.png" width="376" height="395"></p>
<p>Sau khi kết th&uacute;c phần thi thử m&aacute;y sẽ tự động chấm điểm. Bạn phải đạt tr&ecirc;n 60 điểm mới đậu.</p>
<p><img style="display: block; margin-left: auto; margin-right: auto;" src="https://res.cloudinary.com/blog-htn/image/upload/v1713845655/images/1713845653455_1721f29b06884846a1baaae2e99090f2.png" width="379" height="565"></p>
<p>Như bạn thấy th&igrave; phần l&yacute; thuyết kh&ocirc;ng hề kh&oacute;. Chủ yếu l&agrave; cần thời gian để &ocirc;n tập v&agrave; ghi nhớ nhanh c&aacute;c đ&aacute;p &aacute;n.</p>
<p>Một số mẹo để &ocirc;n tập hiệu quả phần l&yacute; thuyết:</p>
<ul>
<li>Bạn n&ecirc;n đọc qua một lần c&aacute;c c&acirc;u hỏi của to&agrave;n bộ đề thi.&nbsp;</li>
<li>Nếu kh&ocirc;ng c&oacute; thời gian, bạn c&oacute; thể học phần &ocirc;n tập nhanh 200 c&acirc;u hỏi (mục 2)</li>
<li>Để tiết kiệm thời gian, bạn c&oacute; thể học qua trước c&aacute;c phần về video, ảnh, tranh, v&agrave; biển b&aacute;o giao th&ocirc;ng. V&igrave; c&aacute;c c&acirc;u hỏi của c&aacute;c phần n&agrave;y lu&ocirc;n c&oacute; điểm cao, v&agrave; dễ nhớ hơn l&agrave; c&aacute;c c&acirc;u hỏi t&igrave;nh huống.&nbsp;</li>
<li>Phần c&aacute;c c&acirc;u hỏi t&igrave;nh huống, bạn c&oacute; thể tự suy luận: C&aacute;c trường hợp l&aacute;i xe nhanh để vượt l&ecirc;n, b&oacute;p c&ograve;i, chạy thẳng m&agrave; kh&ocirc;ng tạm dừng ở phần vạch kẻ đường d&agrave;nh cho người đi bộ th&igrave; đảm bảo auto l&agrave; sai nh&eacute;.</li>
</ul>
<p>Khi &ocirc;n luyện l&yacute; thuyết tr&ecirc;n app bạn n&ecirc;n chọn chế độ hiển thị đ&aacute;p &aacute;n 문제풀이 MODE.&nbsp;</p>
<ul>
<li>Ở chế độ n&agrave;y bạn c&oacute; thể ghi nhớ nhanh c&acirc;u hỏi v&agrave; đ&aacute;p &aacute;n.</li>
<li>Tr&aacute;nh trường hợp đọc tất cả c&aacute;c đ&aacute;p &aacute;n rất dễ bị nhầm lẫn.</li>
<li>M&igrave;nh đ&atilde; &aacute;p dụng phương ph&aacute;p n&agrave;y v&agrave; rất hiệu quả trong việc &ocirc;n luyện l&yacute; thuyết.</li>
</ul>
<p><img style="display: block; margin-left: auto; margin-right: auto;" src="https://res.cloudinary.com/blog-htn/image/upload/v1713846508/images/1713846507037_9928c8c7c32e4e34b5777742bb9e473a.png" width="410" height="436"></p>
<h3 id="2.-Kinh-nghiem-dje-thi-thuc-hanh-djat-hieu-qua" class="post-meta">2. Kinh nghiệm để thi thực h&agrave;nh đạt hiệu quả</h3>
<p>Đối với phần thi thực h&agrave;nh c&oacute; 2 phần thi đ&oacute; l&agrave; l&aacute;i xe trong s&acirc;n, v&agrave; l&aacute;i xe thực tế ngo&agrave;i đường. Đối với phần l&aacute;i xe trong s&acirc;n th&igrave; kh&aacute; đơn giản, chỉ kh&oacute; ở phần thi ngo&agrave;i đường.&nbsp;</p>
<p><strong>Phần thi trong s&acirc;n:&nbsp;</strong>Như b&agrave;i viết trước m&igrave;nh c&oacute; chia sẽ, th&igrave; phần thi trong s&acirc;n sẽ gồm phần thi l&uacute;c xe đứng im (phần thi chuẩn bị trước khi chạy) v&agrave; phần thi khi xe lăn b&aacute;nh (cho xe chạy).</p>
<ul>
<li>Phần thi chuẩn bị:&nbsp;Bật đ&egrave;n xe &ocirc; t&ocirc;, bật đ&egrave;n xi nhan, bật cần gạt nước, điều khiển cần số. Bạn sẽ thực hiện ngẫu nhi&ecirc;n 2 trong 4 mục tr&ecirc;n t&ugrave;y thuộc v&agrave;o hiệu lệch của m&aacute;y chấm điểm để thực hiện. Phần n&agrave;y bạn c&oacute; thể tham khảo th&ecirc;m tr&ecirc;n youtube để biết th&ecirc;m chi tiết.</li>
<li>N&ecirc;n để m&aacute;y đọc hết c&acirc;u v&agrave; l&uacute;c nghe đến c&acirc;u <strong>하세요</strong> th&igrave; mới bắt đầu thực hiện, tr&aacute;nh thực hiện sớm hơn so với hiệu lệnh của m&aacute;y như thế sẽ kh&ocirc;ng được t&iacute;nh điểm.</li>
<li>
<p>Phần thi khi xe lăn b&aacute;nh: Tạm dừng ở dốc, tạm dừng đ&egrave;n đỏ, đổ xe, tăng tốc, dừng khẩn cấp... Bạn phải đạt từ 80điểm trở l&ecirc;n mới được đậu.</p>
</li>
</ul>
<p><strong>Phần thi ngo&agrave;i đường:&nbsp;</strong>Phần n&agrave;y kh&oacute; hơn c&aacute;c phần c&ograve;n lại, v&igrave; bạn phải chạy v&agrave; xử l&yacute; c&aacute;c t&igrave;nh huống thực tế ngo&agrave;i đường. Đối với phần n&agrave;y c&aacute;c bạn sẽ được chọn 1 trong 4 đoạn đường để thi. Bốc thăm tr&ecirc;n m&aacute;y t&iacute;nh.</p>
<p><img style="display: block; margin-left: auto; margin-right: auto;" src="https://res.cloudinary.com/blog-htn/image/upload/v1713849026/images/1713849021737_c36b12696b2f4120a11096fc4e9f8d22.png" width="677" height="923"></p>
<p><strong>Phần n&agrave;y bạn cần lưu &yacute;:</strong><br>Cần kiểm tra xe trước khi thi: Điều chỉnh gương chiếu hậu, chỉnh ghế ngồi hợp l&yacute;, thắt gi&acirc;y an to&agrave;n (nếu kh&ocirc;ng thắt gi&acirc;y an to&agrave;n bạn sẽ bị trật ngay lập tức)</p>
<ul>
<li>Xem trước c&aacute;c đoạn đường thi: Bạn n&ecirc;n học thuộc đoạn 4 đoạn đường thi, kh&ocirc;ng n&ecirc;n bỏ qua đoạn đường n&agrave;o hết. V&igrave; phần thi n&agrave;y sẽ bốc thăm chọn 1 trong 4 đoạn đường quy định để thi.</li>
<li>Bạn n&ecirc;n chủ động t&igrave;m c&aacute;c video hướng dẫn về phần thi ngo&agrave;i đường của trung t&acirc;m m&agrave; bạn muốn đăng k&yacute; thi. Xem đoạn đường đ&oacute; kết hợp với nghe hiệu lệnh của m&aacute;y. Chỉ cần nghe được m&aacute;y n&oacute;i c&aacute;ch bao m&eacute;t nữa sẽ bắt đầu rẻ phải, rẻ tr&aacute;i, chạy thẳng hay quay đầu th&igrave; bạn đ&atilde; th&agrave;nh c&ocirc;ng được 60% rồi, c&ograve;n lại l&agrave; phụ thuộc v&agrave;o c&aacute;c t&iacute;nh huống thực tế ngo&agrave;i đường như dừng đ&egrave;n đỏ, rẻ phải đ&uacute;ng quy định hay kh&ocirc;ng, vv....</li>
<li>Phần n&agrave;y bạn đạt 60điểm l&agrave; đậu.</li>
</ul>
<p><strong>Cuối c&ugrave;ng xin ch&uacute;c c&aacute;c bạn b&igrave;nh tĩnh, tự tin v&agrave; đạt được kết quả tốt. ?</strong></p>
<p><img style="display: block; margin-left: auto; margin-right: auto;" src="https://res.cloudinary.com/blog-htn/image/upload/v1713850408/images/1713850404510_851a68b7520c4b75afeff2c1782bfab8.png" width="568" height="504"></p>
<div class="ddict_btn" style="top: 204px; left: 143.213px;">&nbsp;</div>', 105, 5, '20240514/1715667477263_dc007fe6f4c948d89404706cafeb59df.jpg', 30, 1, 'Y', '2024-03-28 07:40:51', 1, '2024-05-20 05:33:38', 3);
INSERT INTO `blog-htngoc`.posts (TITLE, SLUG, DESCRIPTION, CONTENT, VIEW_CNT, CATEGORY_ID, THUMBNAIL, THUMBNAIL_ID, USER_ID, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('Con Đường Trở Thành Frontend Developer - Lộ trình cho người mới bắt đầu 2024 ??', 'con-djuong-tro-thanh-frontend-developer-lo-trinh-cho-nguoi-moi-bat-djau-2024', 'Trong thế giới công nghệ nhanh chóng biến đổi, lĩnh vực phát triển web frontend luôn cần những cá nhân có kỹ năng và kiến thức được cập nhật liên tục.', '<p>Trước khi bắt đầu, h&atilde;y c&ugrave;ng nhau l&agrave;m r&otilde; một kh&aacute;i niệm <strong>Frontend Developer ?</strong></p>
<h3 id="1.-Frontend-Developer-la-gi" class="post-meta">1. Frontend Developer l&agrave; g&igrave;? ?</h3>
<p>Frontend developer hay c&ograve;n gọi l&agrave; nh&agrave; ph&aacute;t triển giao diện người d&ugrave;ng. C&aacute;i t&ecirc;n n&oacute;i l&ecirc;n tất cả ? đ&oacute; ch&iacute;nh l&agrave; người chịu tr&aacute;ch nhiệm tạo ra "<strong>mặt tiền</strong>" - nơi người d&ugrave;ng tương t&aacute;c trực tiếp. Frontend developers biến những thiết kế v&agrave; layout th&agrave;nh trang web đầy đủ c&aacute;c chức năng hoạt động mượt m&agrave;, sử dụng c&aacute;c ng&ocirc;n ngữ lập tr&igrave;nh như HTML, CSS, JavaScript... để tạo ra trải nghiệm người d&ugrave;ng th&acirc;n thiện v&agrave; trực quan.</p>
<p>Giờ bạn đ&atilde; c&oacute; c&aacute;i nh&igrave;n cơ bản về những g&igrave; m&agrave; một nh&agrave; ph&aacute;t triển frontend sẽ phải l&agrave;m, b&acirc;y giờ ch&uacute;ng ta sẽ đến phần tiếp theo để c&oacute; thể hiểu r&otilde; hơn.</p>
<h3 id="2.-Frontend-Developer-can-phai-hoc-gi" class="post-meta">2. Frontend Developer cần phải học g&igrave;??</h3>
<p>Để bắt đầu sự nghiệp l&agrave;m Frontend Developer bạn cần hiểu c&aacute;ch thức hoạt động của một trang web ra sao. Bao gồm hiểu biết về c&aacute;c giao thức http, https, rồi th&igrave; api l&agrave; c&aacute;i qu&aacute;i g&igrave;? để c&oacute; c&aacute;i nh&igrave;n tổng quan.</p>
<p>Tiếp theo l&agrave; bộ 3 thần th&aacute;nh m&agrave; 1 web development cần phải biết:&nbsp;<strong>HTML</strong>, <strong>CSS</strong>, v&agrave; <strong>JavaScript </strong>ch&uacute;ng như l&agrave; bộ ba kh&ocirc;ng thể t&aacute;ch rời gi&uacute;p tạo n&ecirc;n mọi trang web bạn bắt gặp:</p>
<ul>
<li><strong>HTML:</strong>&nbsp;Đ&acirc;y l&agrave; khung xương của trang web, nơi bạn định nghĩa cấu tr&uacute;c v&agrave; nội dung. Lấy một v&iacute; dụ đơn giản như: L&uacute;c bạn x&acirc;y một ng&ocirc;i nh&agrave; mới th&igrave; đ&acirc;y ch&iacute;nh l&agrave; khung của một ng&ocirc;i nh&agrave;.&nbsp;</li>
<li><strong>CSS:</strong>&nbsp;Gi&uacute;p trang web của bạn "l&ecirc;n đồ" thật đẹp mắt, từ fonts, m&agrave;u sắc đến layout. Đ&acirc;y ch&iacute;nh l&agrave; phần sơn lại ng&ocirc;i nh&agrave;, sắm sửa c&aacute;c đ&ocirc; d&ugrave;ng cần thiết cho ng&ocirc;i nh&agrave; mơ ước của bạn. ?</li>
<li><strong>JavaScript:</strong> Đ&acirc;y l&agrave; linh hồn của trang web, bạn n&ecirc;n học nghi&ecirc;m t&uacute;c với n&oacute; v&igrave; đ&acirc;y ch&iacute;nh l&agrave; phần quan trọng để bạn trở th&agrave;nh một Frontend Developer si&ecirc;u v&iacute;p pro max.&nbsp;</li>
</ul>
<h3 id="3.-Tim-toi-them-Thu-Vien-va-Framework" class="post-meta">3. T&igrave;m t&ograve;i th&ecirc;m Thư Viện v&agrave; Framework ?</h3>
<p>Khi bạn đ&atilde; quen thuộc với bộ ba thần th&aacute;nh HTML, SCC, Javascript tr&ecirc;n th&igrave; đ&atilde; đến l&uacute;c kh&aacute;m ph&aacute; th&ecirc;m một v&agrave;i frameworks như:</p>
<ul>
<li><strong>React:</strong> L&agrave; thư viện được y&ecirc;u th&iacute;ch để x&acirc;y dựng giao diện người d&ugrave;ng mượt m&agrave;.&nbsp;</li>
<li><strong>Vue.js:</strong> Dễ học, dễ sử dụng, tạo ra những trải nghiệm người d&ugrave;ng th&uacute; vị.&nbsp;</li>
<li><strong>Angular:</strong> Một framework mạnh mẽ cho c&aacute;c ứng dụng web lớn v&agrave; phức tạp.&nbsp;</li>
</ul>
<p>C&aacute;c c&ocirc;ng cụ n&agrave;y kh&ocirc;ng chỉ gi&uacute;p tăng tốc độ ph&aacute;t triển ứng dụng m&agrave; c&ograve;n cải thiện đ&aacute;ng kể hiệu quả quản l&yacute; v&agrave; bảo tr&igrave; m&atilde; nguồn. Theo m&igrave;nh c&aacute;c bạn n&ecirc;n lựa chọn frameworks n&agrave;o m&agrave; c&oacute; đ&ocirc;ng đảo nhiều người d&ugrave;ng sẽ gi&uacute;p bạn dễ tiếp cận hơn<img src="../../static/20240514/1715747688166_f8b4de831d4941c8a80c0935405eb50e.png"></p>
<h3 id="4.-Cap-nhat-lien-tuc-kien-thuc-moi" class="post-meta">4. Cập nhật li&ecirc;n tục kiến thức mới ?</h3>
<p>Bạn cũng n&ecirc;n t&igrave;m hiểu th&ecirc;m một v&agrave;i c&ocirc;ng cụ cũng như ng&ocirc;n ngư để n&acirc;ng cao tr&igrave;nh độ bản th&acirc;n, r&uacute;t ngắn thời gian cho c&ocirc;ng việc của bạn hơn.</p>
<ul>
<li><strong>Typerscript:</strong> Hầu hết c&aacute;c dự &aacute;n đều gần như &aacute;p dụng typerscript để quản l&yacute; hiệu quả, giảm lỗi v&agrave; hộ trợ tốt cho c&aacute;c developer.</li>
<li><strong>Tailwind css, Materia UI:&nbsp;</strong>Gi&uacute;p bạn code ra được nhiều giao diện đẹp trong thời gian ngắn.</li>
<li><strong>GIT:&nbsp;</strong>Quản l&yacute; source code của bạn một c&aacute;ch c&oacute; hệ thống v&agrave; rất cần nếu bạn muốn trở th&agrave;nh Frontend developer.</li>
<li><strong>UI/UX:</strong> N&acirc;ng cao kiến thức về UI/UX l&agrave; một lợi thế cho bạn khi xin việc.</li>
</ul>
<h3 id="5.-Thuc-hanh-la-chia-khoa-thanh-cong" class="post-meta">5. Thực h&agrave;nh l&agrave; ch&igrave;a kho&aacute; th&agrave;nh c&ocirc;ng ?</h3>
<p>Bạn n&ecirc;n tự x&acirc;y dựng cho m&igrave;nh một dự &aacute;n c&aacute; nh&acirc;n để bỏ v&agrave;o CV xin việc, gi&uacute;p bạn c&oacute; c&aacute;i nh&igrave;n tốt trước nh&agrave; tuyển dụng. H&atilde;y l&agrave;m cho mọi người phải trầm trồ với những dự &aacute;n bạn đ&atilde; ho&agrave;n th&agrave;nh. ?</p>
<ul>
<li><strong>Thực h&agrave;nh mỗi ng&agrave;y:</strong>&nbsp; Gi&agrave;nh thời gian học tập nghi&ecirc;m t&uacute;c với niềm đam m&ecirc; của bạn ?️</li>
<li><strong>X&acirc;y dựng cho m&igrave;nh một project:&nbsp;</strong>H&atilde;y bắt tay l&agrave;m một dự &aacute;n m&agrave; bạn muốn, để vừa c&oacute; thể &ocirc;n lại kiến thức vừa c&oacute; thể hiểu r&otilde; v&agrave; n&acirc;ng cao kiến thức của m&igrave;nh hơn.</li>
</ul>
<h3 id="6.-Khong-ngung-hoc-hoi" class="post-meta">6. Kh&ocirc;ng ngừng học hỏi&nbsp;?</h3>
<ul>
<li><strong>Học hỏi kh&ocirc;ng ngừng:</strong> C&ocirc;ng nghệ kh&ocirc;ng bao giờ dừng lại, v&agrave; bạn cũng vậy! Lu&ocirc;n cập nhật kiến thức mới. ?</li>
<li><strong>Tham gia cộng đồng:</strong> Gặp gỡ v&agrave; giao lưu với c&aacute;c nh&agrave; ph&aacute;t triển kh&aacute;c để học hỏi v&agrave; trao đổi kinh nghiệm. ?</li>
</ul>
<p>Hy vọng lộ tr&igrave;nh n&agrave;y sẽ gi&uacute;p bạn chinh phục thế giới ph&aacute;t triển web frontend một c&aacute;ch vui vẻ v&agrave; hiệu quả! H&atilde;y l&ecirc;n đường v&agrave; biến ước mơ th&agrave;nh hiện thực, nh&eacute;! ??</p>
<div class="ddict_btn" style="top: 472px; left: 932.516px;">&nbsp;</div>
<div class="ddict_btn" style="top: 402px; left: 767.953px;">&nbsp;</div>', 30, 4, '20240514/1715673087511_7023d1a85c414f048a5de08b4c40a349.png', 33, 3, 'Y', '2024-05-14 16:51:31', 3, '2024-05-19 17:57:09', 3);
INSERT INTO `blog-htngoc`.posts (TITLE, SLUG, DESCRIPTION, CONTENT, VIEW_CNT, CATEGORY_ID, THUMBNAIL, THUMBNAIL_ID, USER_ID, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('Lộ Trình Để Trở Thành Java Web Developer: Từ Cơ Bản Đến Chuyên Nghiệp', 'lo-trinh-dje-tro-thanh-java-web-developer:-tu-co-ban-djen-chuyen-nghiep', 'Hướng dẫn chi tiết lộ trình để trở thành một Java Web Developer chuyên nghiệp, từ lộ trình đến nắm hiểu rõ về Java Web Developer.', '<p>H&eacute; lu c&aacute;c bạn! ? H&ocirc;m nay, m&igrave;nh muốn chia sẻ với c&aacute;c bạn một chủ đề cực kỳ th&uacute; vị v&agrave; đầy thử th&aacute;ch: <strong>L&agrave;m thế n&agrave;o để trở th&agrave;nh một Java Web Developer chuy&ecirc;n nghiệp?</strong> Nếu bạn đang t&igrave;m kiếm một con đường nghề nghiệp đầy hứa hẹn v&agrave; mong muốn g&oacute;p phần tạo n&ecirc;n những sản phẩm c&ocirc;ng nghệ tuyệt vời, th&igrave; b&agrave;i viết n&agrave;y ch&iacute;nh l&agrave; d&agrave;nh cho bạn! ?</p>
<blockquote>
<p>Java, với sự ổn định v&agrave; mạnh mẽ của m&igrave;nh, đ&atilde; trở th&agrave;nh một trong những ng&ocirc;n ngữ lập tr&igrave;nh h&agrave;ng đầu v&agrave; được ưa chuộng tr&ecirc;n to&agrave;n cầu. Java kh&ocirc;ng chỉ được sử dụng rộng r&atilde;i trong c&aacute;c hệ thống doanh nghiệp lớn như ng&acirc;n h&agrave;ng, bảo hiểm, v&agrave; y tế m&agrave; c&ograve;n l&agrave; nền tảng ch&iacute;nh cho c&aacute;c ứng dụng web phức tạp.</p>
</blockquote>
<p>Chuẩn bị tinh thần l&ecirc;n n&agrave;o c&aacute;c bro, v&igrave; con đường bạn sắp đi qua đ&ograve;i hỏi sự ki&ecirc;n tr&igrave;, đam m&ecirc; v&agrave; kh&ocirc;ng ngừng học hỏi. Dưới đ&acirc;y l&agrave; c&aacute;c bước cơ bản để trở th&agrave;nh một <strong><span style="color: rgb(132, 63, 161);">Java Web Developer</span></strong></p>
<h3 id="1.-Nam-Vung-Java-Co-Ban-va-Nang-Cao" class="post-meta">1. ?&nbsp;Nắm Vững Java Cơ Bản v&agrave; N&acirc;ng Cao</h3>
<p>Để bắt đầu với java bạn h&atilde;y t&igrave;m hiểu qua một số kh&aacute;i niệm sau:</p>
<ul>
<li><strong>C&uacute; ph&aacute;p Ng&ocirc;n Ngữ Java</strong>: Đầu ti&ecirc;n hiểu biết về c&uacute; ph&aacute;p cơ bản, v&ograve;ng lặp, điều kiện, mảng, v&agrave; c&aacute;c kiểu dữ liệu.</li>
<li><strong>Lập Tr&igrave;nh Hướng Đối Tượng (OOP)</strong>: Tiếp theo, Java l&agrave; ng&ocirc;n ngữ lập tr&igrave;nh hướng đối tượng, v&igrave; vậy bạn cần hiểu về c&aacute;c kh&aacute;i niệm như kế thừa, đa h&igrave;nh, đ&oacute;ng g&oacute;i, v&agrave; trừu tượng.</li>
<li><strong>Ngoại Lệ v&agrave; Xử L&yacute; Ngoại Lệ</strong>:&nbsp;Đừng qu&ecirc;n học c&aacute;ch xử l&yacute; ngoại lệ một c&aacute;ch hiệu quả với try, catch, finally v&agrave; throws.</li>
</ul>
<h3 id="2.-Cong-Cu-va-Moi-Truong-Phat-Trien-Phan-Mem-(IDE)" class="post-meta">2. ? C&ocirc;ng Cụ v&agrave; M&ocirc;i Trường Ph&aacute;t Triển Phần Mềm (IDE)</h3>
<p>Đương nhi&ecirc;n l&agrave; kh&ocirc;ng thể thiếu c&aacute;c tools để ph&aacute;t triển phần mềm rồi phải kh&ocirc;ng n&agrave;o. ?</p>
<ul>
<li><strong>Eclipse / IntelliJ IDEA / VsCode</strong>: C&aacute;c IDE n&agrave;y rất phổ biến trong cộng đồng Java v&agrave; hỗ trợ mạnh mẽ cho việc coding, debugging, v&agrave; testing.</li>
<li><strong>Maven v&agrave; Gradle</strong>: C&ocirc;ng cụ quản l&yacute; dự &aacute;n v&agrave; dependencies. Biết c&aacute;ch sử dụng Maven hoặc Gradle để quản l&yacute; thư viện l&agrave; rất cần thiết.</li>
</ul>
<h3 id="3.-Framework-va-Thu-Vien" class="post-meta">3. ?️ Framework v&agrave; Thư Viện</h3>
<ul>
<li><strong>Spring Framework</strong>: Bao gồm Spring Boot, Spring MVC, v&agrave; Spring Data JPA. Nếu bạn muốn x&acirc;y dựng một trang web cho bản th&acirc;n th&igrave; <strong><span style="color: rgb(185, 106, 217);">Spring Boot </span></strong>đặc biệt hữu &iacute;ch để x&acirc;y dựng web một c&aacute;ch nhanh ch&oacute;ng.</li>
<li><strong style="font-size: 1.125rem;">Hibernate</strong><span style="font-size: 1.125rem;">: Để l&agrave;m việc với cơ sở dữ liệu qua ORM (Object-Relational Mapping). T&igrave;m hiểu về c&aacute;c Relationship mapping như: @many-to-one, @one-to-many, @many-to-many, @one-to-one</span></li>
</ul>
<h3 id="4.-Co-So-Du-Lieu-va-SQL" class="post-meta">4. ?️ Cơ Sở Dữ Liệu v&agrave; SQL</h3>
<ul>
<li><strong>SQL</strong>:&nbsp;Đối với một Backend Developer, kiến thức về SQL v&agrave; c&aacute;ch tương t&aacute;c với cơ sở dữ liệu l&agrave; v&ocirc; c&ugrave;ng quan trọng.&nbsp;H&atilde;y t&igrave;m hiểu về c&aacute;c loại cơ sở dữ liệu như MySQL, MariaDB, MSSQL v&agrave; học c&aacute;ch thiết kế, truy vấn v&agrave; quản l&yacute; ch&uacute;ng một c&aacute;ch hiệu quả.</li>
<li><strong>JDBC v&agrave; JPA</strong>: C&aacute;c API trong Java để tương t&aacute;c với cơ sở dữ liệu, JPA l&agrave; một lớp trừu tượng cao hơn gi&uacute;p quản l&yacute; dữ liệu trong c&aacute;c ứng dụng Java.</li>
</ul>
<h3 id="5.-API-va-Dich-Vu-Web" class="post-meta">5. ? API v&agrave; Dịch Vụ Web</h3>
<ul>
<li><strong>RESTful Services</strong>: Hiểu biết về c&aacute;ch thiết kế v&agrave; ph&aacute;t triển API theo m&ocirc; h&igrave;nh REST.</li>
<li><strong>JSON v&agrave; XML</strong>: Định dạng dữ liệu phổ biến cho trao đổi dữ liệu giữa client v&agrave; server.</li>
<li><strong>Git:&nbsp;</strong>Để quản l&yacute; source code.</li>
<li><strong>JUnit v&agrave; Mockito</strong>: C&ocirc;ng cụ để viết v&agrave; quản l&yacute; c&aacute;c test case cho m&atilde; nguồn Java.</li>
<li><strong>Bảo Mật Ứng Dụng Web</strong>: Hiểu c&aacute;c nguy&ecirc;n tắc cơ bản về bảo mật ứng dụng web, chẳng hạn như x&aacute;c thực, ph&acirc;n quyền, v&agrave; bảo mật phi&ecirc;n l&agrave;m việc. C&oacute; thể t&igrave;m hiểu th&ecirc;m về Spring Security.</li>
</ul>
<h3 id="6.-Hieu-Biet-ve-DevOps-(nang-cao)" class="post-meta">6. ? Hiểu Biết về DevOps (n&acirc;ng cao)</h3>
<p>Sau khi đ&atilde; t&igrave;m hiểu cơ bản về java, bạn đ&atilde; triển khai với một v&agrave;i dự &aacute;n rồi, th&igrave; bước tiếp theo bạn c&oacute; thể t&igrave;m hiểu th&ecirc;m về DevOps để biết c&aacute;ch deploy một ứng dụng l&ecirc;n server cho mọi người c&oacute; thể truy cập.</p>
<ul>
<li><strong>Containerization (Docker)</strong>: Biết c&aacute;ch đ&oacute;ng g&oacute;i ứng dụng v&agrave; phụ thuộc v&agrave;o một container để triển khai dễ d&agrave;ng. ?</li>
<li><strong>CI/CD</strong>: Hiểu c&aacute;c kh&aacute;i niệm v&agrave; c&ocirc;ng cụ li&ecirc;n quan đến Continuous Integration v&agrave; Continuous Deployment.&nbsp;</li>
</ul>
<p>Với những bước tr&ecirc;n, bạn sẽ trang bị được kiến thức v&agrave; kỹ năng cần thiết để trở th&agrave;nh một Java Web Developer chuy&ecirc;n nghiệp. H&atilde;y bắt đầu h&agrave;nh tr&igrave;nh của m&igrave;nh ngay h&ocirc;m nay v&agrave; kh&ocirc;ng ngừng kh&aacute;m ph&aacute;! ?</p>', 22, 4, '20240514/1715752045117_ab252f8946004ca699a4809db669793e.png', 36, 3, 'Y', '2024-05-15 15:08:03', 3, '2024-05-20 09:16:04', 3);
INSERT INTO `blog-htngoc`.posts (TITLE, SLUG, DESCRIPTION, CONTENT, VIEW_CNT, CATEGORY_ID, THUMBNAIL, THUMBNAIL_ID, USER_ID, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('Chia sẻ hành trình xin việc và thực tập của bản thân', 'chia-se-hanh-trinh-xin-viec-va-thuc-tap-cua-ban-than', 'Quãng thời gian thực tập không chỉ là một phần của quá trình học tập mà còn là một hành trình khám phá và trưởng thành đầy ý nghĩa.', '<h3>Giới Thiệu</h3>
<p>Ch&agrave;o mọi người! H&ocirc;m nay, m&igrave;nh rất vui v&agrave; h&agrave;o hứng khi c&oacute; cơ hội chia sẻ về một chủ đề rất th&uacute; vị v&agrave; đầy cảm x&uacute;c, đ&oacute; l&agrave; kinh nghiệm thực tập của bản th&acirc;n. ?</p>
<h3 id="1.-Minh-DJa-Xin-Viec-Nhu-The-Nao" class="post-meta">1. M&igrave;nh Đ&atilde; Xin Việc Như Thế N&agrave;o? ?</h3>
<p>Trước ti&ecirc;n, m&igrave;nh xin giới thiệu qua về bản th&acirc;n một ch&uacute;t. Sau khi may mắn gi&agrave;nh được học bổng trao đổi theo hệ 3-2 (3 năm ở Việt Nam v&agrave; 2 năm ở H&agrave;n Quốc), m&igrave;nh đ&atilde; quyết định sang H&agrave;n Quốc để học tập. M&igrave;nh đến với Busan thơ mộng với nhiều b&atilde;i biển xinh đẹp. Sau khi kết th&uacute;c 2 năm v&agrave; ho&agrave;n th&agrave;nh chương tr&igrave;nh đại học, m&igrave;nh quyết định học tiếp l&ecirc;n cao học. Đương nhi&ecirc;n, ng&agrave;nh m&agrave; m&igrave;nh chọn l&agrave; IT v&igrave; từ trước giờ m&igrave;nh đ&atilde; theo học ng&agrave;nh n&agrave;y. ?</p>
<p>Thời gian nhanh tr&ocirc;i. Kỳ cuối trước khi tốt nghiệp, cũng l&agrave; l&uacute;c m&igrave;nh suy nghĩ n&oacute; cứ dộn dập đến,&nbsp; v&agrave; cũng l&agrave; l&uacute;c m&igrave;nh quyết định t&igrave;m kiếm cơ hội thực tập để c&oacute; thể t&iacute;ch lũy kinh nghiệm thực tế. Việc đầu ti&ecirc;n m&igrave;nh l&agrave;m l&agrave; chuẩn bị một CV thật ấn tượng (m&igrave;nh sẽ chia sẻ c&aacute;ch viết CV ở phần sau). May mắn thay, gi&aacute;o sư hướng dẫn m&igrave;nh rất tận t&acirc;m v&agrave; lu&ocirc;n hỗ trợ sinh vi&ecirc;n. Ch&iacute;nh gi&aacute;o sư l&agrave; người giới thiệu c&ocirc;ng ty thực tập cho m&igrave;nh. ?</p>
<h3 id="2.-Trang-Bi-Kien-Thuc-Can-Thiet-Cho-Ban-Than" class="post-meta">2. Trang Bị Kiến Thức Cần Thiết Cho Bản Th&acirc;n ?</h3>
<p>Đương nhi&ecirc;n rồi, kiến thức l&agrave; v&ocirc; tận. Bạn cần biết m&igrave;nh thiếu g&igrave; để bổ sung ngay. Nếu bạn c&ograve;n kh&ocirc;ng biết m&igrave;nh thiếu s&oacute;t g&igrave;, th&igrave; ai sẽ gi&uacute;p bạn đ&uacute;ng kh&ocirc;ng? ?. Đ&ocirc;i l&uacute;c m&igrave;nh cũng hoang mang về tương lai, học g&igrave; đ&acirc;y? Sau n&agrave;y l&agrave;m g&igrave;? Bala bala...</p>
<p>T&uacute;m lại c&aacute;i v&aacute;y, để xin được việc như mong muốn đ&ograve;i hỏi bạn phải nỗ lực kh&ocirc;ng ngừng. Đặc th&ugrave; của ng&agrave;nh&nbsp;<strong>IT</strong> bắt buộc bạn phải c&oacute; tư duy tự học l&agrave; phần nhiều. Nh&agrave; trường chỉ dạy kiến thức cơ bản c&ograve;n thực tế đi l&agrave;m th&igrave; kh&aacute;c xa lắm. Nhưng v&agrave;o m&ocirc;i trường c&ocirc;ng ty, ai cũng được đ&agrave;o tạo lại từ đầu, n&ecirc;n c&aacute;c bạn kh&ocirc;ng cần lo lắng qu&aacute; đ&acirc;u. Chỉ cần học chắc kiến thức cơ bản v&agrave; biết ứng dụng n&oacute; l&agrave; được.</p>
<p>Bạn cần trang bị c&aacute;c kiến thức sau:</p>
<ul>
<li><strong>Tiếng H&agrave;n</strong>: Quan trọng v&igrave; l&agrave;m việc tại H&agrave;n Quốc biết tiếng H&agrave;n sẽ l&agrave; một lợi thế rất lớn.</li>
<li><strong>Tiếng Anh</strong>: Gi&uacute;p bạn t&igrave;m được nguồn t&agrave;i liệu phong ph&uacute; hơn. Tuy nhi&ecirc;n, n&ecirc;n đầu tư tiếng H&agrave;n thật tốt trước.</li>
<li><strong>Kiến thức IT cơ bản</strong>: Học chắc c&aacute;c kiến thức cơ bản, &aacute;p dụng n&oacute; v&agrave;o một project c&aacute; nh&acirc;n sẽ gi&uacute;p bạn hiểu s&acirc;u v&agrave; nhớ l&acirc;u hơn.</li>
<li><strong>Project c&aacute; nh&acirc;n</strong>: X&acirc;y dựng một blog c&aacute; nh&acirc;n ho&agrave;n chỉnh, đầu tư thời gian v&agrave;o đ&oacute;. Blog kh&ocirc;ng chỉ gi&uacute;p bạn g&acirc;y ấn tượng với nh&agrave; tuyển dụng m&agrave; c&ograve;n gi&uacute;p bạn tập viết l&aacute;ch.</li>
</ul>
<h3 id="3.-Chuan-Bi-CV-Xin-Viec" class="post-meta">3. Chuẩn Bị CV Xin Việc ?</h3>
<p>M&igrave;nh d&agrave;nh rất nhiều thời gian để tạo ra một bản CV chuy&ecirc;n nghiệp. M&igrave;nh tham khảo nhiều mẫu CV tr&ecirc;n mạng, học c&aacute;ch viết ngắn gọn nhưng đầy đủ th&ocirc;ng tin. B&ecirc;n cạnh đ&oacute;, m&igrave;nh cũng viết một bức thư xin việc (Cover Letter) thật chỉn chu để gửi k&egrave;m theo. ?</p>
<p>C&aacute;c trang viết CV chuy&ecirc;n nghiệp:</p>
<ul>
<li>TopCV : ?&nbsp;<a href="https://www.topcv.vn/" target="_blank" rel="noopener">đi đến TopCV</a></li>
<li>VietCV.io: ? <a href="https://vietcv.io/" target="_blank" rel="noopener">đi đến VietCV</a></li>
<li>Canva: ?&nbsp;<a href="https://www.canva.com/" target="_blank" rel="noopener">đi đến Canva</a></li>
</ul>
<h3 id="4.-Tim-Kiem-Co-Hoi" class="post-meta">4. T&igrave;m Kiếm Cơ Hội ?️&zwj;♀️</h3>
<h4><strong>Nguồn t&igrave;m kiếm việc l&agrave;m ?</strong></h4>
<p>M&igrave;nh bắt đầu t&igrave;m kiếm cơ hội thực tập qua c&aacute;c trang web tuyển dụng, mạng x&atilde; hội v&agrave; qua sự giới thiệu của bạn b&egrave;, gi&aacute;o sư. Việc t&igrave;m kiếm n&agrave;y đ&ograve;i hỏi sự ki&ecirc;n nhẫn v&agrave; chịu kh&oacute;, nhưng m&igrave;nh tin rằng ki&ecirc;n tr&igrave; sẽ đem lại kết quả tốt. ?</p>
<p>Một số trang t&igrave;m kiếm việc l&agrave;m lớn ở H&agrave;n Quốc:</p>
<ul>
<li>Saramin: ?&nbsp;<a href="https://www.saramin.co.kr/" target="_blank" rel="noopener">đi đến Saramin</a></li>
<li>Job Korea: ? <a href="https://www.jobkorea.co.kr/" target="_blank" rel="noopener">đi đến JobKorea</a></li>
<li>Career: ?<a href="https://www.career.co.kr/" target="_blank" rel="noopener">đi đến Career</a></li>
</ul>
<h4 id="Gui-DJon-va-Cho-DJoi" class="post-meta">Gửi Đơn v&agrave; Chờ Đợi ?</h4>
<p>Sau khi t&igrave;m được c&aacute;c vị tr&iacute; ph&ugrave; hợp, m&igrave;nh gửi đơn ứng tuyển v&agrave; bắt đầu qu&aacute; tr&igrave;nh chờ đợi. Giai đoạn n&agrave;y thật sự l&agrave; một thử th&aacute;ch v&igrave; kh&ocirc;ng phải l&uacute;c n&agrave;o cũng nhận được phản hồi ngay lập tức. Tuy nhi&ecirc;n, đ&acirc;y cũng l&agrave; khoảng thời gian th&iacute;ch hợp để &ocirc;n tập lại kiến thức. ?</p>
<h4>Phỏng Vấn ?</h4>
<p>Khi nhận được lời mời phỏng vấn, m&igrave;nh chuẩn bị rất kỹ c&agrave;ng. M&igrave;nh nghi&ecirc;n cứu về c&ocirc;ng ty, chuẩn bị c&aacute;c c&acirc;u hỏi thường gặp v&agrave; thực h&agrave;nh trả lời trước gương. Tự tin v&agrave; thể hiện được bản th&acirc;n l&agrave; điều v&ocirc; c&ugrave;ng quan trọng trong qu&aacute; tr&igrave;nh phỏng vấn. ✨</p>
<p>L&uacute;c được c&ocirc;ng ty hẹn đến phỏng vấn, m&igrave;nh vừa mừng vừa lo. May mắn l&agrave; m&igrave;nh vượt qua cuộc phỏng vấn kh&aacute; nhẹ nh&agrave;ng. Gi&aacute;o sư đ&atilde; dẫn m&igrave;nh đến c&ocirc;ng ty do &ocirc;ng giới thiệu, n&ecirc;n khi họ thấy gi&aacute;o sư, chỉ hỏi m&igrave;nh v&agrave;i c&acirc;u cơ bản v&agrave; m&igrave;nh trả lời ổn l&agrave; pass lu&ocirc;n. ^^</p>
<h4>Nhận Thực Tập ?</h4>
<p>Sau một tuần chờ đợi, cuối c&ugrave;ng m&igrave;nh nhận được lời mời thực tập từ c&ocirc;ng ty. Đ&acirc;y l&agrave; một bước ngoặt lớn trong sự nghiệp của m&igrave;nh. ?</p>
<h4>Kinh Nghiệm Thực Tập ?</h4>
<p>Trong suốt qu&aacute; tr&igrave;nh thực tập 6 th&aacute;ng, m&igrave;nh học hỏi được rất nhiều kiến thức v&agrave; kỹ năng mới. M&igrave;nh c&oacute; cơ hội l&agrave;m việc c&ugrave;ng những đồng nghiệp vui t&iacute;nh v&agrave; học hỏi từ họ. N&oacute;i thật, l&uacute;c mới đi thực tập, m&igrave;nh lo lắng lắm, v&agrave;o c&ocirc;ng ty cứ như ng&aacute;o ngơ. Ng&agrave;y đầu đi l&agrave;m, đ&uacute;ng l&uacute;c c&ocirc;ng ty c&oacute; buổi họp n&ecirc;n m&igrave;nh cũng chui v&agrave;o nghe. C&ocirc;ng ty m&igrave;nh chuy&ecirc;n l&agrave;m phần mềm quản l&yacute; hệ thống logistics, kh&ocirc;ng phải chuy&ecirc;n ng&agrave;nh của m&igrave;nh, n&ecirc;n nhiều thuật ngữ chuy&ecirc;n ng&agrave;nh m&igrave;nh kh&ocirc;ng hiểu. Thế l&agrave; m&igrave;nh được cho ngay một tập t&agrave;i liệu thuật ngữ về <strong>logistics </strong>để học.</p>
<p>N&oacute;i chung mấy ng&agrave;y đầu kh&aacute; l&agrave; vất vả, nhưng nhờ những b&agrave;i học thực tế n&agrave;y, m&igrave;nh kh&ocirc;ng chỉ n&acirc;ng cao kiến thức chuy&ecirc;n m&ocirc;n m&agrave; c&ograve;n r&egrave;n luyện kỹ năng l&agrave;m việc nh&oacute;m v&agrave; quản l&yacute; thời gian. ⏰</p>
<p>C&oacute; thời gian m&igrave;nh sẽ chia sẻ một b&agrave;i ri&ecirc;ng về qu&aacute; tr&igrave;nh đi l&agrave;m, cũng như l&uacute;c m&igrave;nh được giao dự &aacute;n mới của c&ocirc;ng ty. ^^</p>
<h3 id="5.-Ket-Luan" class="post-meta">5. Kết Luận</h3>
<p>Qu&aacute; tr&igrave;nh xin việc v&agrave; thực tập l&agrave; một h&agrave;nh tr&igrave;nh d&agrave;i v&agrave; đầy thử th&aacute;ch. Tuy nhi&ecirc;n, nếu ki&ecirc;n tr&igrave; v&agrave; nỗ lực, bạn sẽ gặt h&aacute;i được những th&agrave;nh quả xứng đ&aacute;ng. M&igrave;nh hy vọng những chia sẻ tr&ecirc;n sẽ gi&uacute;p &iacute;ch cho c&aacute;c bạn trong qu&aacute; tr&igrave;nh t&igrave;m kiếm việc l&agrave;m v&agrave; thực tập. Ch&uacute;c c&aacute;c bạn may mắn v&agrave; th&agrave;nh c&ocirc;ng! ?</p>
<p>Cảm ơn c&aacute;c bạn đ&atilde; đọc b&agrave;i viết của m&igrave;nh. Nếu c&oacute; bất kỳ c&acirc;u hỏi hay thắc mắc n&agrave;o, h&atilde;y để lại b&igrave;nh luận ph&iacute;a dưới nh&eacute;! ?</p>
<h3>Kết Nối Với M&igrave;nh</h3>
<p>Đừng qu&ecirc;n kết nối với m&igrave;nh tr&ecirc;n Facebook hoặc Email để c&ugrave;ng trao đổi v&agrave; học hỏi th&ecirc;m nhiều kinh nghiệm th&uacute; vị! ?</p>', 18, 6, '20240514/1715772818959_c1ef38b7cdf44283a86a43d77c2d6731.png', 37, 3, 'Y', '2024-05-15 20:35:45', 3, '2024-06-10 07:16:29', 2);
INSERT INTO `blog-htngoc`.posts (TITLE, SLUG, DESCRIPTION, CONTENT, VIEW_CNT, CATEGORY_ID, THUMBNAIL, THUMBNAIL_ID, USER_ID, USED_YN, REG_DT, REG_ID, MOD_DT, MOD_ID) VALUES ('Lộ Trình Học Spring Boot Cho Người Mới ', 'lo-trinh-hoc-spring-boot-cho-nguoi-moi', 'Spring Framework không chỉ là một công cụ, mà còn là một nền tảng mạnh mẽ cho việc phát triển ứng dụng Java hiện đại và linh hoạt.', '<pre class="language-java"><code>    @Operation(summary = "Get hot posts rest api",
            description = "Get hot posts rest api is used to get hot post from the database")
    @ApiResponse(responseCode = "200", description = "Http status 200 success")
    @GetMapping("/hot-posts")
    public ResponseEntity&lt;?&gt; getHotPosts() {
        return ResponseEntity.ok(
                ResponseDTO.builder()
                        .message(localizationUtils.translate(MessageKeys.COMMON_ACTIONS_GET_ALL_SUCCESSFULLY))
                        .data(postService.getHotPosts())
                        .build()
        );
    }</code></pre>
<p>Bạn đ&atilde; sẵn s&agrave;ng để chinh phục Spring Boot, c&ocirc;ng cụ ph&aacute;t triển ứng dụng Java h&agrave;ng đầu?&nbsp; H&atilde;y c&ugrave;ng đi s&acirc;u v&agrave;o lộ tr&igrave;nh n&agrave;y, từ bước đầu ti&ecirc;n cho đến những kỹ thuật chuy&ecirc;n s&acirc;u, để kh&ocirc;ng chỉ th&agrave;nh thạo m&agrave; c&ograve;n c&oacute; thể &aacute;p dụng kiến thức v&agrave;o thực tiễn, biến &yacute; tưởng th&agrave;nh c&aacute;c ứng dụng thực tế. ?</p>
<blockquote>
<p>Spring Boot l&agrave; một trong những c&ocirc;ng cụ ph&aacute;t triển ứng dụng Java h&agrave;ng đầu, gi&uacute;p c&aacute;c lập tr&igrave;nh vi&ecirc;n c&oacute; thể nhanh ch&oacute;ng triển khai c&aacute;c dịch vụ độc lập m&agrave; kh&ocirc;ng cần qu&aacute; nhiều cấu h&igrave;nh phức tạp.&nbsp;</p>
</blockquote>
<h2 id="1.-Phan-Co-Ban:-Nen-tang-can-nam-vung" class="post-meta">1. Phần Cơ Bản: Nền tảng cần nắm vững</h2>
<p>Trước khi bắt đầu, Để học Spring hiệu quả bạn cần nắm vững ng&ocirc;n ngữ <span style="color: rgb(132, 63, 161);"><strong><code>Java</code></strong></span> v&agrave; c&aacute;c nguy&ecirc;n l&yacute; của lập tr&igrave;nh hướng đối tượng <span style="color: rgb(132, 63, 161);"><code><strong>OOP</strong></code></span>. Spring Boot được x&acirc;y dựng dựa tr&ecirc;n Java, v&igrave; vậy kiến thức nền tảng n&agrave;y l&agrave; điều kh&ocirc;ng thể thiếu.</p>
<h4>Khởi động với Spring Boot&nbsp; ?</h4>
<p><strong>Spring Framework v&agrave; Spring Boot</strong>: T&igrave;m hiểu về c&aacute;c th&agrave;nh phần cốt l&otilde;i v&agrave; l&yacute; do tại sao Spring Boot lại được ưa chuộng trong việc ph&aacute;t triển ứng dụng hiện đại.</p>
<p><strong>IOC, DI, v&agrave; Bean Management</strong>: C&aacute;ch Spring quản l&yacute; beans v&agrave; dependencies.</p>
<p><strong>C&aacute;c Annotation Cơ Bản</strong>: Như <span style="color: rgb(22, 145, 121);"><span style="color: rgb(45, 194, 107);"><span style="color: rgb(53, 152, 219);">@Component</span><span style="color: rgb(53, 152, 219);">, @Service, @Repository, </span></span><span style="color: rgb(53, 152, 219);">@Controller</span></span>, để định nghĩa c&aacute;c <span style="color: rgb(53, 152, 219);">@Beans </span>v&agrave; quản l&yacute; c&aacute;c th&agrave;nh phần ứng dụng. Đ&acirc;y l&agrave; c&aacute;c annotation quan trọng trong springboot.</p>
<p><strong>M&ocirc; h&igrave;nh lớp ứng dụng trong SpringBoot:</strong> <span style="color: rgb(186, 55, 42);">Controller </span>- &gt; <span style="color: rgb(241, 196, 15);">Service</span> -&gt; <span style="color: rgb(22, 145, 121);">Repository</span> mối quan hệ v&agrave; c&aacute;ch thức hoạt động của ch&uacute;ng. N&oacute; như đ&egrave;n giao th&ocirc;ng vậy c&oacute; mối quan hệ chặt chẹ với nhau.</p>
<p><strong>L&agrave;m Việc Với Dữ Liệu</strong>:</p>
<ul>
<li>JPA, Hibernate basics v&agrave; Spring Data.. @Entity, @Mapper, @ID...</li>
<li>C&aacute;ch kết nối springboot với Database.&nbsp;</li>
<li>C&aacute;c mối quan hệ RelationShip @ManyToOne, @OneToMany, @OneToOne, @ManyToMany để c&oacute; thể truy xuất c&aacute;c Entity với nhau.</li>
</ul>
<p><strong>Xử L&yacute; Lỗi Cơ Bản</strong>:</p>
<ul>
<li>Học c&aacute;ch sử dụng&nbsp;<span style="color: rgb(53, 152, 219);">@ExceptionHandler</span> v&agrave; <span style="color: rgb(53, 152, 219);">@ControllerAdvice</span> để xử l&yacute; c&aacute;c ngoại lệ trong ứng dụng.</li>
<li>X&acirc;y dựng được global Exception cho ứng dụng, trả về lỗi theo HttpStatus, trả về lỗi theo Custom Status.</li>
</ul>
<p><strong>RESTfull Api:</strong>&nbsp;</p>
<ul>
<li>T&igrave;m hiểu c&aacute;ch thức m&agrave; RESTfull Api hoạt động, c&aacute;c annotation&nbsp;<span style="color: rgb(53, 152, 219);">@RequestMapping, @PostMapping, @GetMapping, @PutMapping, @DeleteMapping</span></li>
<li>Triển khai RestApi trong Springboot, xử l&yacute; request với @RequestParam, @RequestBody, @PathVariable, @RequestHeader</li>
<li>C&aacute;c annotation để kiểm tra t&iacute;nh đ&uacute;ng đắn của dữ liệu: @Valid, @NotNull, @Nullable, @Length</li>
</ul>
<p><strong>T&igrave;m hiểu về @Configuration:&nbsp;</strong>Cấu h&igrave;nh cần thiết cho hệ thống như <strong>Modelmapper,</strong> <strong>Swagger</strong></p>
<p><strong>Biến m&ocirc;i trường .properties:&nbsp;</strong>Cấu h&igrave;nh biến m&ocirc;i trường trong file application.properties, application.yml&nbsp;</p>
<ul>
<li>Khai b&aacute;o biến m&ocirc;i trường trong application v&agrave; gọi n&oacute; th&ocirc;ng qua @Value</li>
<li>Cấu h&igrave;nh m&ocirc;i trường dev, state, prod</li>
</ul>
<p>Với c&aacute;c kiến thức căn bản tr&ecirc;n, bạn h&atilde;y triển khai v&agrave; &aacute;p dụng n&oacute; v&agrave;o việc viết một ứng dụng CRUD đơn giản sử dụng RESTfull Api.</p>
<h2 id="2.-Phan-Tiep-Theo" class="post-meta">2.&nbsp; Phần Tiếp Theo ?</h2>
<h4>Mở rộng kiến thức ?</h4>
<p>Sau khi đ&atilde; nắm vững những kiến thức cơ bản, bạn sẽ tiếp tục học hỏi c&aacute;c kỹ năng ti&ecirc;n tiến hơn để c&oacute; thể xử l&yacute; c&aacute;c y&ecirc;u cầu phức tạp trong thực tế.</p>
<p><strong>N&acirc;ng cao xử l&yacute; với dữ liệu:&nbsp;</strong>Ph&acirc;n trang, Sort theo điều kiện, xắp xếp theo DESC, ASC&nbsp;</p>
<p><strong>T&igrave;m hiểu xử l&yacute; đồng bộ v&agrave; bất đồng bộ trong Springboot</strong></p>
<p><strong>Spring Security:&nbsp;</strong></p>
<ul>
<li>C&aacute;c kh&aacute;i niệm cơ bản về x&aacute;c thực v&agrave; ph&acirc;n quyền. Authentication and Authorization</li>
<li>Cấu h&igrave;nh cơ bản security với spring boot 3.+ v&agrave; security 6.+ (T&igrave;m&nbsp;hiểu&nbsp;Filter,&nbsp;Filterchain)</li>
</ul>
<p><strong>Kh&aacute;i niệm CORS:&nbsp;</strong>cấu h&igrave;nh CORS trong security cho ph&eacute;p c&aacute;c domain n&agrave;o được ph&eacute;p truy cập.</p>
<p><strong>Hệ thống x&aacute;c thực n&acirc;ng cao Spring OAuth2: </strong>(Local Store + JWT + Access Token + Refresh Token)</p>
<p><strong>Ghi file logs:&nbsp;</strong>C&aacute;ch cấu h&igrave;nh để lưu file logs tiện cho việc đọc lỗi cũng như bảo tr&igrave; hệ thống.</p>
<p><strong>L&agrave;m việc với File trong SpringBoot:&nbsp;</strong>C&aacute;ch thức upload image (File, Multipart)</p>
<p><strong>Cấu h&igrave;nh Mybatis:</strong> Để l&agrave;m việc với c&aacute;c c&acirc;u truy vấn phức tạp một c&aacute;ch dễ d&agrave;ng v&agrave; thuận tiện.</p>
<p><strong>Redis trong Springboot: </strong>L&agrave;m việc với Redis v&agrave; c&aacute;c hệ thống message queue như Kafka để tăng tốc độ xử l&yacute; v&agrave; khả năng mở rộng.</p>
<p><strong>Gửi Email:</strong> X&acirc;y dựng hệ thống gửi email với thymeleaf</p>
<h2 id="3.-Phan-Nang-Cao" class="post-meta">3. Phần N&acirc;ng Cao ?</h2>
<p>Đ&acirc;y l&agrave; giai đoạn n&acirc;ng cao, Để bổ sung kiến thức cho bạn</p>
<h3 id="3.-Phan-Nang-Cao:-Phan-bo-sung" class="post-meta">Phần bổ sung ?</h3>
<p><strong>Tạo Schedule:&nbsp;</strong>C&aacute;ch l&ecirc;n lịch tr&igrave;nh cho hệ thống sử dụng schedule + crawling data với selenium.</p>
<p><strong>DevOps</strong>: Phần n&agrave;y d&ugrave;ng dể deploy hệ thống publish để mọi người c&oacute; thể truy cập v&agrave;o website của bạn.</p>
<ul>
<li>Domain-server: C&aacute;ch đắng k&yacute; v&agrave; cấu h&igrave;nh domain để c&oacute; thể connection tới server.</li>
<li>Git v&agrave; Docker: Sử dụng th&agrave;nh thạo Git v&agrave; Docker, biết c&aacute;ch build hệ thống với&nbsp;<span style="color: rgb(132, 63, 161);">docker-compose.</span></li>
<li>CI/CD: Kết hợp CI/CD để deploy hệ thống một c&aacute;ch tự động.</li>
</ul>
<p><strong>Advanced Monitoring</strong>: Sử dụng Spring Boot Actuator v&agrave; c&aacute;c c&ocirc;ng cụ gi&aacute;m s&aacute;t để quản l&yacute; hiệu suất ứng dụng.</p>
<h2 id="Loi-Ket" class="post-meta">Lời Kết&nbsp; ?</h2>
<p>Spring Boot l&agrave; một c&ocirc;ng cụ mạnh mẽ, nhưng để th&agrave;nh thạo n&oacute; đ&ograve;i hỏi một lộ tr&igrave;nh học tập b&agrave;i bản v&agrave; c&oacute; hệ thống. Lộ tr&igrave;nh n&agrave;y chỉ l&agrave; tương đối, c&ograve;n nhiều kiến thức cần được bổ sung th&ecirc;m. Hy vọng sẽ mang lại c&aacute;i nh&igrave;n tổng quan về hướng tiếp cận Spring Boot. ?</p>
<div class="ddict_btn" style="top: 353px; left: -1.99913e+06px;"><img src="chrome-extension://bpggmmljdiliancllaapiggllnkbjocb/logo/48.png"></div>', 61, 4, '20240517/1715935700349_c52ea84ab2dd49e4a326d5d9d1591b06.jpg', 41, 2, 'Y', '2024-05-17 17:48:29', 2, '2024-06-10 04:57:48', 2);
