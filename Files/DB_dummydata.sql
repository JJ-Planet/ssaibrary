USE ssaibrary;

-- 회원 정보

INSERT INTO `member` (`id`, `password`, `name`, `nickname`, `is_admin`) 
VALUES ("admin", "1234", "관리자", "관리자", 'Y');
INSERT INTO `member` (`id`, `password`, `name`, `nickname`) 
VALUES ("010-1111-1111", "1234", "황정주", "행성주인님"),
	   ("010-2222-2222", "1234", "김창겸", "7반반장"),
	   ("010-3333-3333", "1234", "김지환", "싸피브레인1"),
	   ("010-4444-4444", "1234", "김소윤", "싸피귀염둥이"),
	   ("010-5555-5555", "1234", "이나연", "싸피브레인2");

-- 커뮤니티 정보

INSERT INTO `community` (`member_nickname`, `title`, `content`, `hit_count`, `register_date`) 
VALUES ("행성주인님", 
	    "1등 할래", 
        "<p>히히</p>", 
        179, 
        "2022-12-26 14:14:01"); 
INSERT INTO `community` (`member_nickname`, `title`, `content`, `hit_count`, `like_count`, `register_date`) 
VALUES ("싸피브레인2", 
	    "다들 판교에서 모이장!!", 
        "<p>내가 맛집 리스트 쫙 정리해놓음.</p>", 
        220, 
        10, 
        "2022-12-26 14:27:05"),
 	   ("싸피귀염둥이", 
        "내가 제일 귀여워", 
        "<p>헿</p>", 
        180, 
        1, 
        "2022-12-26 17:03:16"),
 	   ("7반반장", 
        "대전7반김창겸 화이팅~!~!~", 
        "<p>제곧내</p>", 
        150, 
        4, 
        "2022-12-26 17:07:07"), 
	   ("싸피브레인1", 
        "빠른 싸탈해라", 
        "<p>다들 고마웠고 난 먼저 싸탈한다.</p>", 
        550, 
        5, 
        "2022-03-20 08:29:01");

-- 공지사항 정보

INSERT INTO `notice` (`member_id`, `title`, `content`, `register_date`, `is_priority`) 
VALUES ("admin", 
	    "SSaibrary 서비스 개시 안내", 
	    "<p>안녕하세요 SSaibrary(싸이브러리)입니다.</p><p>&nbsp;</p><p>2022/12/28(수) 부터 SSAFY 캠퍼스 내 강의실 좌석 및 스터디룸 대여 서비스를 시작합니다.</p><p>본 사이트에서 강의실 좌석이나 스터디룸 예약 후 사용하실 수 있으며,&nbsp;</p><p>강의실 좌석은 모든 정규 수업 시간이 끝난 후에 이용할 수 있습니다.</p><p>&nbsp;</p><h4><strong>예약 가능 시간 : 00:00 ~ 24:00</strong></h4><h4><strong>강의실 좌석 운영 시간 : 18:00 ~ 22:00(평일), 09:00 ~ 22:00(주말)</strong></h4><h4><strong>스터디룸 운영 시간 : 09:00 ~ 22:00</strong></h4><p>&nbsp;</p><h2><strong>*예약 버튼은 28(수)일 00시부터 활성화되며</strong></h2><h2><strong>이외 모든 기능은 지금부터 이용할 수 있습니다.*</strong></h2><p>&nbsp;</p><p>많은 이용 부탁드리며 기타 문의 사항은 1:1 문의 게시판을 이용해 주시기 바랍니다.&nbsp;</p><p>&nbsp;</p><p>SSaibrary 올림</p>",
        "2022-12-26 14:00:05", 
        "Y"),
	   ("admin", 
        "설 연휴 고객센터 운영 안내", 
        "<p>안녕하세요 SSaibrary입니다.</p><p>다사다난했던 한 해가 지나가고 새로운 태양이 하늘 높이 떠오르는 새해가 다가왔습니다.</p><p>설 연휴 기간 23/01/21(토)~23/01/24(화) 고객센터 운영시간이 임시 변경되오니, 이용에 참고 부탁드립니다.</p><p>&nbsp;</p><h4>09:00 ~ 18:00 -&gt; 09:00 ~ 12:00&nbsp;</h4><h4>01/21(토)~01/22(일 ) - 미운영</h4><p>&nbsp;</p><p>&nbsp;1:1 문의 게시판에 문의 사항 남겨주시면 정상 업무 시행 시 순차적으로 답변드리겠습니다.</p><p>새해 복 많이 받으시고, 2023년에는 소망하시는 일 모두 이루시길 바랍니다.</p><p>절절포!</p><p>&nbsp;</p><p>&nbsp;</p><p>SSaibrary 올림</p>",
        "2023-01-13 15:10:00", 
        "Y");
INSERT INTO `notice` (`member_id`, `title`, `content`, `register_date`) 
VALUES ("admin", 
	    "SSaibrary 포스터 찾기 이벤트 안내", 
	    "<p>전국 캠퍼스에서 SSaibrary 포스터를 찾아주세요.</p><p>추첨을 통해 <strong>20명</strong>에게 <strong>배스킨라빈스 쏩니다!!</strong></p><p>&nbsp;</p><p><strong>이벤트 기간 : 2023/01/25(수)~2023/02/24(금)</strong></p><p><strong>참여 대상 : 누구나</strong></p><p><strong>당첨자 발표일 : 2023/02/28(수)</strong></p><p>&nbsp;</p><h3><strong>&lt; 참여방법 &gt;</strong></h3><h4>1. 캠퍼스 내에서 SSaibrary 포스터를 찾는다.</h4><h4>2. 인증샷을 찍는다.</h4><h4>3. 필수 해시태그와 함께 인스타그램에 인증샷 게시물을 올린다.</h4><h4>&nbsp;<i> - 필수 해시태그 : #SSaibrary, #싸이브러리, #SSaibrary포스터, #포스터를찾아라</i></h4><h4>4. 이벤트 참여 완료</h4><p>&nbsp;</p><ul><li>전체 공개 계정을 대상으로 추첨합니다.</li><li>릴스 및 스토리 업로드는 추첨 대상에 해당되지 않습니다.</li></ul>", 
        "2023-01-17 10:37:45"),
	   ("admin", 
        "SSaibrary, 2023 SSAFY인이 뽑은 올해의 브랜드 대상 수상", 
        "<p>SSaibrary(이하 싸이브러리), '2023 SSAFY인이 뽑은 올해의 브랜드 대상' 웹사이트 부문 1위</p><p>&nbsp;</p><p>싸이브러리가 2023년 6월 28일 열린 '2023 싸피인이 뽑은 올해의 브랜드 대상'에서 웹사이트 부문 대상을 수상했습니다!</p><p>'올해의 브랜드 대상'은 매년 한 해를 빛낸 최고의 서비스를 선정하는 SSAFY 내 최대 규모의 어워즈로,</p><p>특히 전국의 SSAFY 교육생들이 직접 투표를 통해 최고의 서비스를 선정한다는 점에서 의미가 크다고 볼 수 있는데요.</p><p>&nbsp;</p><p>싸이브러리는 앞으로도 교육생 모두에게 최고의 학습 공간이라는 가치를 제공하는 데 앞장서고,</p><p>계속해서 여러분께 인정받는 브랜드로 자리매김하는 데 최선을 다하겠습니다.</p><p>싸이브러리를 사랑해 주시는 모든 교육생 분들께 다시 한번 감사의 인사를 드립니다.</p><p>감사합니다. 절절포!</p><p>&nbsp;</p><p>SSaibrary 올림</p>", 
        "2023-06-29 16:50:27");

-- 1:1문의 정보

INSERT INTO `inquiry` (`member_nickname`, `title`, `question`, `answer`, `register_date`, `status`) 
VALUES ("행성주인님", 
	    "즐", 
        "즐즐", 
        "안녕하세요 행성주인님, 산업안전보건법에 따라 고객 응대 근로자에게 폭언, 업무방해 행위를 할 시, 형법, 정보통신망법 등에 의해 처벌받을 수 있으며 해당 문의글은 삭제 처리 되었음을 알려드립니다.", 
        "2022-12-30 10:14:01", 
        'D'),
	   ("7반반장", 
        "강의실 좌석 연장이 안되네요.", 
        "강의실에서 더 공부하고 싶은데 연장이 안 되네요.", 
        "안녕하세요 7반반장님, 먼저 저희 서비스를 이용해 주셔서 감사합니다. 문의 남겨주신 내용 확인해 본 결과 최대 연장 가능 횟수인 2회를 초과하셔서 안되셨던 것으로 보입니다. 최대한 많은 교육생분들이 이용할 수 있도록 하고자 연장 가능 횟수를 제한했으나 문의하신 내용 기획 팀에 전달하여 의논해 볼 수 있도록 하겠습니다. 불편을 끼쳐드려 죄송하고 앞으로 더욱더 발전하는 SSaibrary가 되겠습니다.", 
        "2022-12-31 19:27:01", 
        'C');
INSERT INTO `inquiry` (`member_nickname`, `title`, `question`, `register_date`) 
VALUES ("싸피브레인2", 
	    "이 사이트", 
        "너무 잘 만들었어요! 아이디어 너무 좋고 편해요!!!", 
        "2022-01-27 15:14:01");

-- FAQ 정보

INSERT INTO `faq` (`question`, `answer`) 
VALUES ("SSaibrary는 어떤 서비스인가요?", 
        "SSAFY 캠퍼스 내 강의실을 교육생들이 스터디룸과 자습실로 사용할 수 있도록 대여해 주는 서비스로, 정규 수업 시간 외에 공부나 회의를 하기 위해 따로 장소를 찾아야 하는 교육생들을 위해 만들어졌습니다."),
	   ("SSAFY 교육생이라면 누구나 이용할 수 있나요?", 
        "캠퍼스 내 강의실을 대여해 주는 서비스 특성상 강의실에 입실 가능한 교육생이라면 누구나 SSaibrary 회원 가입 후 이용 가능합니다."),
	   ("자습실 및 스터디룸 운영 시간은 어떻게 되나요?", 
        "자습실 운영 시간은 평일 18:00 ~ 22:00, 주말 09:00 ~ 22:00 이며, 스터디룸 운영 시간은 평일, 주말  09:00 ~ 22:00 입니다. (공휴일은 미운영)"),
	   ("자습실 좌석 연장이 안됩니다.", 
        "최대한 많은 교육생들이 공평하게 이용할 수 있도록 하기 위해 연장 가능 횟수를 최대 2회로 지정하였습니다. 횟수를 초과하지 않았음에도 불구하고 연장이 되지 않는 경우 ssaibrary@ssafy.com으로 문의해 주시면 감사하겠습니다."),
	   ("1 : 1 문의를 남겼는데 답변이 없습니다.", 
        "고객센터 운영 시간은 평일 09:00 ~ 18:00이며, 상담원이 최대한 빠르게 답변 드리고자 노력하고 있습니다. 만약 3영업일 후에도 답변이 없다면 ssaibrary@ssafy.com으로 메일 보내주시기 바랍니다."),
	   ("제가 쓴 글이 블라인드 처리되었어요, 블라인드 처리 기준은 무엇인가요?", 
        "SSaibrary는 모든 이용자들이 서로 응원하고 함께 성장하는 문화를 만들어가고자 합니다. 타인의 권리를 침해하거나 불쾌함을 유발하는 등 부적절한 내용을 게시할 경우 SSaibrary 서비스 이용 약관 제24조에 따라 고객에게 통보 없이 삭제 또는 블라인드 처리 될 수 있습니다. 관련 문의사항은 1:1 문의 게시판에 글을 남겨주시기 바랍니다."),
	   ("비밀번호 변경은 어떻게 하나요?", 
        "하단 메뉴바 [Account > 정보수정] 페이지에서 비밀번호 변경이 가능합니다."),
	   ("회원 탈퇴 후 재가입이 안됩니다.", 
        "ssaibrary@ssafy.com으로 문의해주시면 감사하겠습니다.");

-- 댓글 정보

INSERT INTO `comment` (`community_id`, `member_nickname`, `content`, `parent_id`, `depth_no`, `order_no`, `like_count`, `register_date`) 
VALUES (2, "7반반장", "좋아유~", 1, 0, 0, 1, "2022-12-26 14:32:05"),
	   (2, "싸피브레인1", "좋아", 2, 0, 0, 1, "2022-12-26 14:34:05"),
	   (2, "싸피귀염둥이", "조아요", 3, 0, 0, 1, "2022-12-26 14:37:05"),
	   (2, "행성주인님", "굳굳", 4, 0, 0, 1, "2022-12-26 14:40:05"),
	   (3, "싸피브레인1", "ㅇㅈ", 5, 0, 0, 1, "2022-12-26 17:04:16"),
   	   (3, "싸피귀염둥이", "ㅋㅎㅋㅎㅋㅎㅋㅎㅋㅋㅎㅋㅎ", 5, 1, 1, 1, "2022-12-26 17:05:16"),
	   (3, "싸피귀염둥이", "아니! 맞는데~", 7, 1, 1, 1, "2022-12-26 17:15:16"),
	   (4, "싸피브레인1", "창겸아 수고해라~~", 9, 0, 0, 1, "2022-12-26 17:20:07"),
	   (4, "싸피귀염둥이", "창겸아 고생해라~~", 10, 0, 0, 1, "2022-12-26 17:25:07"),
	   (4, "싸피브레인2", "창겸아 화이팅해라~~", 11, 0, 0, 1, "2022-12-26 17:30:07"),
	   (5, "7반반장", "지환 가지마", 12, 0, 0, 3, "2022-03-20 08:37:01");
INSERT INTO `comment` (`community_id`, `member_nickname`, `content`, `parent_id`, `depth_no`, `order_no`, `register_date`, `status`) 
VALUES (3, "행성주인님", "아니! 아닌데~", 7, 0, 0, "2022-12-26 17:10:16", 'D');

-- 강의실 정보

INSERT INTO `room`(`id`, `floor`, `total_seat`, `reserve_seat`) 
VALUES (301, 3, 30, 3),
	   (302, 3, 24, 2);
INSERT INTO `room`(`id`, `floor`, `total_seat`) 
VALUES (303, 3, 24);

-- 좌석 정보

INSERT INTO `seat` (`id`, `room_id`, `password`) 
VALUES (1, 301, "0000"), 
	   (2, 301, "0000"), 
	   (3, 301, "0000"), 
	   (4, 301, "0000"),
	   (5, 301, "0000"),
	   (6, 301, "0000"),
	   (7, 301, "0000"),
	   (8, 301, "0000"),
	   (9, 301, "0000"),
	   (10, 301, "0000"),
	   (11, 301, "0000"),
	   (12, 301, "0000"),
	   (13, 301, "0000"),
	   (14, 301, "0000"),
	   (15, 301, "0000"),
	   (16, 301, "0000"),
	   (17, 301, "0000"),
	   (18, 301, "0000"),
	   (19, 301, "0000"),
	   (20, 301, "0000"),
	   (21, 301, "0000"),
	   (22, 301, "0000"),
	   (23, 301, "0000"),
	   (24, 301, "0000"),
	   (25, 301, "0000"),
	   (26, 301, "0000"),
	   (27, 301, "0000"),
	   (28, 301, "0000"),
	   (29, 301, "0000"),
	   (30, 301, "0000");
INSERT INTO `seat` (`id`, `room_id`, `password`) 
VALUES (31, 302, "0000"),
	   (32, 302, "0000"),
	   (33, 302, "0000"),
	   (34, 302, "0000"),
	   (35, 302, "0000"),
	   (36, 302, "0000"),
	   (37, 302, "0000"),
	   (38, 302, "0000"),
	   (39, 302, "0000"),
	   (40, 302, "0000"),
	   (41, 302, "0000"),
	   (42, 302, "0000"),
	   (43, 302, "0000"),
	   (44, 302, "0000"),
	   (45, 302, "0000"),
	   (46, 302, "0000"),
	   (47, 302, "0000"),
	   (48, 302, "0000"),
	   (49, 302, "0000"),
	   (50, 302, "0000"),
	   (51, 302, "0000"),
	   (52, 302, "0000"),
	   (53, 302, "0000"),
	   (54, 302, "0000");
INSERT INTO `seat` (`id`, `room_id`, `password`) 
VALUES (55, 303, "0000"),
	   (56, 303, "0000"),
	   (57, 303, "0000"),
	   (58, 303, "0000"),
	   (59, 303, "0000"),
	   (60, 303, "0000"),
	   (61, 303, "0000"),
	   (62, 303, "0000"),
	   (63, 303, "0000"),
	   (64, 303, "0000"),
	   (65, 303, "0000"),
	   (66, 303, "0000"),
	   (67, 303, "0000"),
	   (68, 303, "0000"),
	   (69, 303, "0000"),
	   (70, 303, "0000"),
	   (71, 303, "0000"),
	   (72, 303, "0000"),
	   (73, 303, "0000"),
	   (74, 303, "0000"),
	   (75, 303, "0000"),
	   (76, 303, "0000"),
	   (77, 303, "0000"),
	   (78, 303, "0000");

-- 좌석 예약 정보

INSERT INTO `seat_reservation` (`member_id`, `member_nickname`, `seat_id`, `start_date`, `time`) 
VALUES ("010-1111-1111", "행성주인님", 1, "2022-12-16 02:22:11", 4),
	   ("010-2222-2222", "7반반장", 2, "2022-12-17 08:22:25", 2),
	   ("010-3333-3333", "싸피브레인1", 16, "2022-12-17 12:05:55", 4),
	   ("010-4444-4444", "싸피귀염둥이", 36, "2022-12-18 06:10:11", 3),
	   ("010-5555-5555", "싸피브레인2", 45, "2022-12-18 19:11:11", 3);
      
UPDATE `seat` SET `status` = 'R' WHERE `id` IN(1, 36);
UPDATE `seat` SET `status` = 'A' WHERE `id` IN(2, 16, 45);

-- 스터디룸 정보

INSERT INTO `studyroom` (`id`, `floor`, `size`, `max_user`, `status`) 
VALUES (304, 3, 19, 4, 'A');
INSERT INTO `studyroom` (`id`, `floor`, `size`, `max_user`) 
VALUES (305, 3, 24, 6);
       
-- 스터디룸 상태 정보

INSERT INTO `studyroom_state` (`is_dirty`, `is_damage`, `is_not_lock`) 
VALUES ('Y','N', 'N');

-- 스터디룸 예약 정보

INSERT INTO `studyroom_reservation` (`member_id`, `member_nickname`, `studyroom_id`, `studyroom_state_id`, `purpose`, `user_count`, `start_date`, `time`, `status`) 
VALUES ("010-1111-1111", "행성주인님", 304, 1, "싸이브러리 회의를 하기 위해서", 4, "2022-12-18 22:00:00", 2, 'A');
INSERT INTO `studyroom_reservation` (`member_id`, `member_nickname`, `studyroom_id`, `purpose`, `user_count`, `start_date`, `time`) 
VALUES ("010-3333-3333", "싸피브레인2", 305, "금주 회의를 하기 위해서", 5, "2023-1-9 09:30:00", 4);

UPDATE `studyroom` SET `status` = 'A' WHERE `id` = 304;
