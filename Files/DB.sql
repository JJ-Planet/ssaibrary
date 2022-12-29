CREATE DATABASE IF NOT EXISTS ssaibrary;
USE ssaibrary;

/*
기존 MyISAM이 MySQL의 기본 엔진이었다면 MySQL 5.5부터는 InnoDB가 기본 엔진으로 변경됨

InnoDB 특징
- 트랜젝션 지원
- 빈번한 쓰기/수정/삭제 시 처리 능력 향상
- 디스크, 전원 등의 장애 발생시 복구 성능 향상
- 동시처리가 많은 환경에 적합
- Row 단위 Locking

MyISAM 특징
- 상대적으로 높은 성능, 읽기(조회) 위주의 요청에 유리
- MyISAM은 트랜젝션 지원이 안됨
- 여러 SQL문을 실행한 후 commit 또는 rollback 하는 기능이 없음
- 테이블 단위로 Lock이 걸리기 때문에 테이블에 두 가지 이상의 데이터를 동시에 insert/update할 수 없음
- 데이터가 거의 고정되어 있고 읽기가 많이 발생하는 경우에는 그 성능 효과를 충분히 발휘할 수 있음
- 테이블 단위 Locking
*/

-- 회원 정보 테이블

CREATE TABLE IF NOT EXISTS `member` (
  `id` VARCHAR(20) NOT NULL COMMENT '아이디(전화번호)',
  `password` VARCHAR(255) NOT NULL COMMENT '비밀번호',
  `refresh_token` VARCHAR(255) COMMENT 'jwt토큰',
  `name` VARCHAR(20) NOT NULL COMMENT '이름',
  `nickname` VARCHAR(20) NOT NULL UNIQUE COMMENT '닉네임',
  `origin_image` VARCHAR(255) NOT NULL DEFAULT "default.jpg" COMMENT '원본이미지명',
  `save_image` VARCHAR(255) NOT NULL DEFAULT "default.jpg" COMMENT '저장이미지명',
  `join_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '가입일시',
  `exit_date` TIMESTAMP COMMENT '탈퇴일시',
  `is_admin` CHAR(1) NOT NULL DEFAULT 'N' COMMENT '관리자여부(Y:관리자,N:일반회원)',
  `status` CHAR(1) NOT NULL DEFAULT 'A' COMMENT '상태(A:활동상태,X:탈퇴상태)',
  PRIMARY KEY (`id`)
  )
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- 커뮤니티 테이블

CREATE TABLE IF NOT EXISTS `community` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '글번호',
  `member_nickname` VARCHAR(20) NOT NULL COMMENT '작성자닉네임',
  `title` VARCHAR(100) NOT NULL COMMENT '제목',
  `content` VARCHAR(2000) NOT NULL COMMENT '내용',
  `hit_count` INT NULL DEFAULT 0 COMMENT '조회수',
  `like_count` INT NULL DEFAULT 0 COMMENT '좋아요수',
  `register_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일시',
  `update_date` TIMESTAMP COMMENT '수정일시',
  `status` CHAR(1) NOT NULL DEFAULT 'V' COMMENT '상태(V:노출,D:삭제,B:신고)',
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_member_community_nickname`
    FOREIGN KEY (`member_nickname`)
    REFERENCES `member` (`nickname`) ON UPDATE CASCADE
)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- 공지사항 테이블

CREATE TABLE IF NOT EXISTS `notice` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '글번호',
  `member_id` VARCHAR(20) NOT NULL COMMENT '작성자아이디',
  `title` VARCHAR(100) NOT NULL COMMENT '제목',
  `content` VARCHAR(2000) NOT NULL COMMENT '내용',
  `hit_count` INT NOT NULL DEFAULT 0 COMMENT '조회수',
  `register_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일시',
  `update_date` TIMESTAMP COMMENT '수정일시',
  `is_priority` CHAR(1) NOT NULL DEFAULT 'N' COMMENT '주요공지사항여부(Y:주요공지사항,N:일반공지사항)', 
  `status` CHAR(1) NOT NULL DEFAULT 'V' COMMENT '상태(V:노출,D:삭제)',
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_member_notice`
    FOREIGN KEY (`member_id`)
    REFERENCES `member` (`id`) ON DELETE CASCADE
)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- 1:1문의 테이블

CREATE TABLE IF NOT EXISTS `inquiry` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '글번호',
  `member_nickname` VARCHAR(20) NOT NULL COMMENT '작성자닉네임',
  `title` VARCHAR(100) NOT NULL COMMENT '제목',
  `question` VARCHAR(2000) NOT NULL COMMENT '질문',
  `answer` VARCHAR(2000) COMMENT '답변',
  `register_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일시',
  `status` CHAR(1) NOT NULL DEFAULT 'W' COMMENT '상태(W:답변대기,C:답변완료,D:삭제)',
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_member_inquiry_nickname`
    FOREIGN KEY (`member_nickname`)
    REFERENCES `member` (`nickname`) ON UPDATE CASCADE
)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- FAQ 테이블

CREATE TABLE IF NOT EXISTS `faq` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '글번호',
  `question` VARCHAR(2000) NOT NULL COMMENT '질문',
  `answer` VARCHAR(2000) NOT NULL COMMENT '답변',
  `status` CHAR(1) NOT NULL DEFAULT 'V' COMMENT '상태(V:노출,D:삭제)',
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- 댓글 테이블

CREATE TABLE IF NOT EXISTS `comment` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '댓글번호',
  `community_id` INT NOT NULL COMMENT '글번호',
  `member_nickname` VARCHAR(20) NOT NULL COMMENT '작성자닉네임',
  `content` VARCHAR(2000) NOT NULL COMMENT '내용',
  `parent_id` INT NOT NULL DEFAULT 0 COMMENT '부모댓글',
  `depth_no` INT NOT NULL DEFAULT 0 COMMENT '댓글계층(깊이)',
  `order_no` INT NOT NULL DEFAULT 0 COMMENT '정렬순서',
  `like_count` INT NULL DEFAULT 0 COMMENT '좋아요수',
  `register_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일시',
  `status` CHAR(1) NOT NULL DEFAULT 'V' COMMENT '상태(V:노출,D:삭제,B:신고)',
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_community_comment`
    FOREIGN KEY (`community_id`)
    REFERENCES `community` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_member_comment_nickname`
    FOREIGN KEY (`member_nickname`)
    REFERENCES `member` (`nickname`) ON UPDATE CASCADE
)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- 강의실 테이블

CREATE TABLE IF NOT EXISTS `room` (
  `id` INT NOT NULL COMMENT '강의실번호',
  `floor` INT NOT NULL COMMENT '층수',
  `total_seat` INT NOT NULL COMMENT '총좌석수',
  `reserve_seat` INT NOT NULL DEFAULT 0 COMMENT '예약좌석수',
  `is_available` CHAR(1) NOT NULL DEFAULT 'Y' COMMENT '사용가능여부(Y:가능,N:불가능)',
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- 좌석 테이블

CREATE TABLE IF NOT EXISTS `seat` (
  `id` INT NOT NULL COMMENT '좌석번호',
  `room_id` INT NOT NULL COMMENT '강의실번호',
  `password` VARCHAR(20) NOT NULL COMMENT '비밀번호',
  `status` CHAR(1) NOT NULL DEFAULT 'W' COMMENT '상태(W:대기중,R:예약중,A:사용중,X:이용불가능)',
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_room_seat`
    FOREIGN KEY (`room_id`)
    REFERENCES `room` (`id`) ON DELETE CASCADE
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- 좌석 예약 테이블 

CREATE TABLE IF NOT EXISTS `seat_reservation` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '번호',
  `member_id` VARCHAR(20) NOT NULL COMMENT '예약자아이디',
  `member_nickname` VARCHAR(20) NOT NULL COMMENT '예약자닉네임',
  `seat_id` INT NOT NULL COMMENT '좌석번호',
  `reservation_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '예약일시',
  `start_date` TIMESTAMP NOT NULL COMMENT '예약시작일시',
  `time` INT NOT NULL COMMENT '예약시간',
  `checkin_date` TIMESTAMP COMMENT '입실시간',
  `checkout_date` TIMESTAMP COMMENT '퇴실일시',
  `add_time` INT NOT NULL DEFAULT 0 COMMENT '연장시간',
  `add_count` INT NOT NULL DEFAULT 0 COMMENT '연장횟수',
  `status` CHAR(1) NOT NULL DEFAULT 'W' COMMENT '상태(W:대기,A:사용중,C:사용완료,X:취소)',
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_member_seat_reservation`
    FOREIGN KEY (`member_id`)
    REFERENCES `member` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_member_seat_reservation_nickname`
    FOREIGN KEY (`member_nickname`)
    REFERENCES `member` (`nickname`) ON UPDATE CASCADE,
  CONSTRAINT `fk_seat_seat_reservation`
    FOREIGN KEY (`seat_id`)
    REFERENCES `seat` (`id`) ON DELETE CASCADE
)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- 스터디룸 테이블  

CREATE TABLE IF NOT EXISTS `studyroom` (
  `id` INT NOT NULL COMMENT '스터디룸번호',
  `floor` INT NOT NULL COMMENT '층수',
  `size` INT NOT NULL COMMENT '방크기', 
  `max_user` INT NOT NULL COMMENT '최대인원수',  
  `status` CHAR(1) NOT NULL DEFAULT 'W' COMMENT '상태(W:대기중,R:예약중,A:사용중,X:이용불가능)',
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- 스터디룸 예약 테이블 

CREATE TABLE IF NOT EXISTS `studyroom_reservation` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '번호',
  `member_id` VARCHAR(20) NOT NULL COMMENT '예약자아이디',
  `member_nickname` VARCHAR(20) NOT NULL COMMENT '예약자닉네임',
  `studyroom_id` INT NOT NULL COMMENT '스터디룸번호',
  `purpose` VARCHAR(255) NOT NULL COMMENT '이용목적',
  `user_count` INT NOT NULL COMMENT '인원수',
  `reservation_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '예약일시',
  `start_date` TIMESTAMP NOT NULL COMMENT '예약시작일시',
  `time` INT NOT NULL COMMENT '예약시간',
  `checkin_date` TIMESTAMP COMMENT '입실시간',
  `checkout_date` TIMESTAMP COMMENT '퇴실일시',
  `status` CHAR(1) NOT NULL DEFAULT 'W' COMMENT '상태(W:대기,A:사용중,C:사용완료,X:취소)',
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_member_studyroom_reservation`
    FOREIGN KEY (`member_id`)
    REFERENCES `member` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_member_studyroom_reservation_nickname`
    FOREIGN KEY (`member_nickname`)
    REFERENCES `member` (`nickname`) ON UPDATE CASCADE,
  CONSTRAINT `fk_studyroom_studyroom_reservation`
    FOREIGN KEY (`studyroom_id`)
    REFERENCES `studyroom` (`id`) ON DELETE CASCADE
)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- 스터디룸 상태 테이블 

CREATE TABLE IF NOT EXISTS `studyroom_state` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '번호',
  `studyroom_reservation_id` INT COMMENT '스터디룸예약번호',
  `is_dirty` CHAR(1) NOT NULL DEFAULT 'N' COMMENT '청결상태(Y/N)',
  `is_damage` CHAR(1) NOT NULL DEFAULT 'N' COMMENT '손상상태(Y/N)',
  `is_not_lock` CHAR(1) NOT NULL DEFAULT 'N' COMMENT '잠금상태(Y/N)',
  `origin_image` VARCHAR(255) COMMENT '원본이미지명',
  `save_image` VARCHAR(255) COMMENT '저장이미지명',
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_studyroom_reservation_studyroom_state`
    FOREIGN KEY (`studyroom_reservation_id`)
    REFERENCES `studyroom_reservation` (`id`) ON DELETE CASCADE
)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
