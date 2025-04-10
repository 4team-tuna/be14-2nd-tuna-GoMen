-- 기존 테이블이 존재하면 삭제
DROP TABLE IF EXISTS tbl_board_file;
DROP TABLE IF EXISTS tbl_mentoring_file;
DROP TABLE IF EXISTS tbl_answer;
DROP TABLE IF EXISTS tbl_question;
DROP TABLE IF EXISTS tbl_rating_and_review;
DROP TABLE IF EXISTS tbl_mentoring;
DROP TABLE IF EXISTS tbl_applicant;
DROP TABLE IF EXISTS tbl_team_recruit;
DROP TABLE IF EXISTS tbl_mentoring_member;
DROP TABLE IF EXISTS tbl_mentoring_space;
DROP TABLE IF EXISTS tbl_mentor_list;
DROP TABLE IF EXISTS tbl_report;
DROP TABLE IF EXISTS tbl_report_category;
DROP TABLE IF EXISTS tbl_bookmark;
DROP TABLE IF EXISTS tbl_like;
DROP TABLE IF EXISTS tbl_comment;
DROP TABLE IF EXISTS tbl_board;
DROP TABLE IF EXISTS tbl_mail;
DROP TABLE IF EXISTS tbl_title_list;
DROP TABLE IF EXISTS tbl_title;
DROP TABLE IF EXISTS tbl_career;
DROP TABLE IF EXISTS tbl_user;

CREATE TABLE `tbl_user` (
                            `user_id`	INT	NOT NULL PRIMARY KEY AUTO_INCREMENT,
                            `login_id`	VARCHAR(255)	UNIQUE NOT NULL,
                            `password`	VARCHAR(255)	NOT NULL,
                            `name`	VARCHAR(255)	NOT NULL,
                            `personal_number`	VARCHAR(255)	NOT NULL,
                            `phone_number`	VARCHAR(255)	NOT NULL,
                            `nickname`	VARCHAR(255)	NOT NULL,
                            `created_at`	DATETIME	NOT NULL	DEFAULT NOW(),
                            `updated_at`	DATETIME	NULL,
                            `will_be_activated`	DATETIME	NOT NULL	DEFAULT NOW(),
                            `is_quitted`	VARCHAR(255)	NOT NULL	DEFAULT 'N',
                            `github_adress`	VARCHAR(255)	NULL,
                            `extension_count`	INT	NOT NULL	DEFAULT 0,
                            `career_info`	VARCHAR(255)	NULL,
                            `is_mentor`	VARCHAR(255)	NOT NULL	DEFAULT 'N',
                            `violation_score`	INT	NOT NULL	DEFAULT 0,
                            `average_rating` DOUBLE DEFAULT 0,
                            `college` VARCHAR(255) NULL,
                            `blog` VARCHAR(255) NULL
);

INSERT INTO `tbl_user` (
    `user_id`,
    `login_id`,
    `password`,
    `name`,
    `personal_number`,
    `phone_number`,
    `nickname`
) VALUES
      (1, 'user1', 'password1', 'John Doe', '900101-1234567', '010-1234-5678', 'CoolCat'),
      (2, 'user2', 'password2', 'Jane Smith', '920202-2345678', '010-2345-6789', 'TechGuru'),
      (3, 'user3', 'password3', 'Mike Johnson', '910303-3456789', '010-3456-7890', 'CodingMaster'),
      (4, 'user4', 'password4', 'Sarah Lee', '890404-4567890', '010-4567-8901', 'DebugQueen'),
      (5, 'user5', 'password5', 'Chris Kim', '850505-5678901', '010-5678-9012', 'ByteLord'),
      (6, 'user6', 'password6', 'Emily Davis', '950606-6789012', '010-6789-0123', 'CloudKing'),
      (7, 'user7', 'password7', 'Tom Brown', '920707-7890123', '010-7890-1234', 'FullStackKing'),
      (8, 'user8', 'password8', 'Lily Wilson', '910808-8901234', '010-8901-2345', 'TechNinja'),
      (9, 'user9', 'password9', 'James Moore', '940909-9012345', '010-9012-3456', 'WebWizard'),
      (10, 'user10', 'password10', 'Anna Taylor', '870910-0123456', '010-0123-4567', 'CodeMaster'),
      (11, 'user11', 'password11', 'David Anderson', '880111-1234567', '010-1234-5678', 'DevPro'),
      (12, 'user12', 'password12', 'Laura Thomas', '870212-2345678', '010-2345-6789', 'FrontEndGuru'),
      (13, 'user13', 'password13', 'Robert Martinez', '930313-3456789', '010-3456-7890', 'BackendKing'),
      (14, 'user14', 'password14', 'Sophia White', '900414-4567890', '010-4567-8901', 'PythonQueen'),
      (15, 'user15', 'password15', 'Ethan Harris', '860515-5678901', '010-5678-9012', 'AIExpert'),
      (16, 'user16', 'password16', 'Mia Clark', '940616-6789012', '010-6789-0123', 'DatabasePro'),
      (17, 'user17', 'password17', 'Oliver Lewis', '910717-7890123', '010-7890-1234', 'AlgoChampion'),
      (18, 'user18', 'password18', 'Isabella Walker', '920818-8901234', '010-8901-2345', 'CodeNinja'),
      (19, 'user19', 'password19', 'William Hall', '930919-9012345', '010-9012-3456', 'BlockchainPro'),
      (20, 'user20', 'password20', 'Ava Allen', '870220-0123456', '010-0123-4567', 'WebDevExpert'),
      (21, 'user21', 'password21', 'Benjamin Young', '950321-1234567', '010-1234-5678', 'DevGuru'),
      (22, 'user22', 'password22', 'Charlotte King', '860422-2345678', '010-2345-6789', 'TechSavvy'),
      (23, 'user23', 'password23', 'Lucas Scott', '950523-3456789', '010-3456-7890', 'CodeMaster'),
      (24, 'user24', 'password24', 'Harper Perez', '920624-4567890', '010-4567-8901', 'AIEngineer'),
      (25, 'user25', 'password25', 'Amelia Evans', '880725-5678901', '010-5678-9012', 'WebArtist'),
      (26, 'user26', 'password26', 'Jack Green', '930826-6789012', '010-6789-0123', 'DevGenius'),
      (27, 'user27', 'password27', 'Ella Carter', '950927-7890123', '010-7890-1234', 'CodeMasterMind'),
      (28, 'user28', 'password28', 'James Hall', '900028-8901234', '010-8901-2345', 'CodeWiz'),
      (29, 'user29', 'password29', 'Grace Moore', '910129-9012345', '010-9012-3456', 'AIWizard'),
      (30, 'user30', 'password30', 'Owen Adams', '940230-0123456', '010-0123-4567', 'FrontEndWizard'),
      (31, 'user31', 'password31', 'Harley Brooks', '870331-1234567', '010-1234-5678', 'BackEndMaster'),
      (32, 'user32', 'password32', 'Carter Foster', '860432-2345678', '010-2345-6789', 'DevWizard'),
      (33, 'user33', 'password33', 'Scarlett Ross', '950533-3456789', '010-3456-7890', 'CloudArchitect'),
      (34, 'user34', 'password34', 'Sophia Evans', '910634-4567890', '010-4567-8901', 'TechGenius'),
      (35, 'user35', 'password35', 'Ethan Garcia', '920735-5678901', '010-5678-9012', 'AIChampion'),
      (36, 'user36', 'password36', 'Liam Wilson', '850836-6789012', '010-6789-0123', 'BlockchainNinja'),
      (37, 'user37', 'password37', 'Emma Harris', '900937-7890123', '010-7890-1234', 'DevProMind'),
      (38, 'user38', 'password38', 'Aiden Lee', '910038-8901234', '010-8901-2345', 'TechTitan'),
      (39, 'user39', 'password39', 'Olivia Jackson', '950139-9012345', '010-9012-3456', 'FullStackQueen'),
      (40, 'user40', 'password40', 'Sebastian Young', '860240-0123456', '010-0123-4567', 'JavaMaster'),
      (41, 'user41', 'password41', 'Madison Hill', '870341-1234567', '010-1234-5678', 'TechGoddess'),
      (42, 'user42', 'password42', 'Lucas Allen', '920442-2345678', '010-2345-6789', 'DevSage'),
      (43, 'user43', 'password43', 'Jackson Nelson', '910543-3456789', '010-3456-7890', 'BlockchainWhiz'),
      (44, 'user44', 'password44', 'Mason Carter', '950644-4567890', '010-4567-8901', 'FrontEndMaestro'),
      (45, 'user45', 'password45', 'Ella Mitchell', '860745-5678901', '010-5678-9012', 'AIWizardess'),
      (46, 'user46', 'password46', 'Jack Lee', '900846-6789012', '010-6789-0123', 'BackendGuru'),
      (47, 'user47', 'password47', 'Zoe Perez', '870947-7890123', '010-7890-1234', 'CloudChampion'),
      (48, 'user48', 'password48', 'Wyatt Thompson', '940048-8901234', '010-8901-2345', 'CodeMastermind'),
      (49, 'user49', 'password49', 'Grace Clark', '910149-9012345', '010-9012-3456', 'TechVirtuoso'),
      (50, 'user50', 'password50', 'Leo White', '950250-0123456', '010-0123-4567', 'DataScienceKing');

UPDATE tbl_user
SET is_mentor = 'Y'
WHERE user_id in (1,2,3,4,5,6);

################################### tbl_user

CREATE TABLE `tbl_career` (
                              `user_id`	INT	NOT NULL,
                              `blog`	VARCHAR(255)	NULL,
                              `company`	VARCHAR(255)	NULL,
                              `edu`	VARCHAR(255)	NULL,
                              CONSTRAINT tbl_career_to_tbl_user FOREIGN KEY (user_id) REFERENCES tbl_user(user_id)
);

INSERT INTO `tbl_career` (`user_id`, `blog`, `company`, `edu`)
VALUES
    (1, 'https://developer1-blog.com', 'TechCorp', '컴퓨터공학과 - 서울대학교'),
    (2, 'https://coder2-dev.com', 'WebSoft', '소프트웨어학과 - KAIST'),
    (3, 'https://coding3.com', 'DevWorks', '정보통신학과 - 연세대학교'),
    (4, 'https://pythondev4.blog', 'InnovativeTech', 'IT학과 - 고려대학교'),
    (5, 'https://jsdeveloper5.blog', 'TechNet', '컴퓨터공학과 - 성균관대학교'),
    (6, 'https://developer6.tistory.com', 'CloudSoft', '전자공학과 - 한양대학교'),
    (7, 'https://reactdev7.blogspot.com', 'CodeFactory', '소프트웨어학과 - 포스텍'),
    (8, 'https://dev8-blog.com', 'AppSolutions', '정보시스템학과 - 아주대학교'),
    (9, 'https://webdev9.com', 'SmartTech', '컴퓨터공학과 - 경희대학교'),
    (10, 'https://dev10-blog.tistory.com', 'SystemWorks', '디지털미디어학과 - 중앙대학교'),
    (11, 'https://dev11-portfolio.com', 'QuantumSoft', '소프트웨어공학과 - 이화여자대학교'),
    (12, 'https://backenddev12.blog', 'CodeLab', '컴퓨터공학과 - 동국대학교'),
    (13, 'https://dev13-blog.com', 'InnovativeSolutions', '정보통신학과 - 서강대학교'),
    (14, 'https://developer14.tistory.com', 'TechBridge', '전자공학과 - 숭실대학교'),
    (15, 'https://frontenddev15.com', 'DataSolutions', 'AI학과 - 광운대학교'),
    (16, 'https://coder16-blog.com', 'TechX', '소프트웨어학과 - 한림대학교'),
    (17, 'https://dev17-blog.tistory.com', 'CloudWorks', '컴퓨터공학과 - 한국과학기술원(KAIST)'),
    (18, 'https://jsdev18.com', 'WebExperts', '디지털미디어학과 - 한양대학교'),
    (19, 'https://pythondeveloper19.com', 'TechMaster', '소프트웨어학과 - 경희대학교'),
    (20, 'https://dev20-blog.tistory.com', 'CodeSpace', '전산학과 - 서울과학기술대학교'),
    (21, 'https://dev21-blog.com', 'QuantumTech', '정보통신학과 - 인하대학교'),
    (22, 'https://dev22-blog.tistory.com', 'WebLogic', '소프트웨어학과 - 연세대학교'),
    (23, 'https://coder23.com', 'TechCloud', '전자공학과 - 세종대학교'),
    (24, 'https://dev24-blog.com', 'DataTech', '컴퓨터공학과 - 한양대학교'),
    (25, 'https://dev25-tistory.com', 'CodeMaster', '정보시스템학과 - 숭실대학교'),
    (26, 'https://dev26.com', 'TechOps', 'AI학과 - 고려대학교'),
    (27, 'https://dev27-blog.tistory.com', 'SoftWareTech', '컴퓨터공학과 - 카이스트'),
    (28, 'https://dev28.com', 'DevWorks', '소프트웨어학과 - 상명대학교'),
    (29, 'https://developer29-blog.com', 'CodeLink', '정보통신학과 - 한양대학교'),
    (30, 'https://dev30.tistory.com', 'AppTech', '전산학과 - 경희대학교'),
    (31, 'https://backenddev31.com', 'SmartTech', '디지털미디어학과 - 중앙대학교'),
    (32, 'https://dev32-blog.tistory.com', 'SystemX', '정보시스템학과 - 포스텍'),
    (33, 'https://dev33.com', 'TechFactory', '컴퓨터공학과 - 아주대학교'),
    (34, 'https://developer34-blog.com', 'CodeFactory', '소프트웨어공학과 - 서강대학교'),
    (35, 'https://dev35-blog.tistory.com', 'AppLabs', '정보통신학과 - 동국대학교'),
    (36, 'https://pythondev36.com', 'DataTech', '컴퓨터공학과 - 고려대학교'),
    (37, 'https://jsdev37.com', 'TechBridge', '디지털미디어학과 - 경희대학교'),
    (38, 'https://developer38-blog.tistory.com', 'CodeSoft', '전자공학과 - 인하대학교'),
    (39, 'https://dev39.com', 'TechCloud', '소프트웨어학과 - 포스텍'),
    (40, 'https://dev40-blog.com', 'AppWorks', '정보시스템학과 - 서울대학교'),
    (41, 'https://backenddev41.com', 'CloudLabs', '정보통신학과 - 한양대학교'),
    (42, 'https://dev42-blog.com', 'QuantumTech', '소프트웨어학과 - 성균관대학교'),
    (43, 'https://dev43.com', 'AppWorks', 'AI학과 - 고려대학교'),
    (44, 'https://coder44-blog.com', 'CodeX', '소프트웨어학과 - 연세대학교'),
    (45, 'https://dev45.com', 'TechSolutions', '정보시스템학과 - 숭실대학교'),
    (46, 'https://developer46.tistory.com', 'CloudSolutions', '전산학과 - 카이스트'),
    (47, 'https://dev47-blog.com', 'TechBridge', '디지털미디어학과 - 한양대학교'),
    (48, 'https://dev48.com', 'CodeMaster', '컴퓨터공학과 - 서울대학교'),
    (49, 'https://developer49-blog.com', 'TechSpace', '정보시스템학과 - 경희대학교'),
    (50, 'https://dev50-blog.com', 'TechX', '소프트웨어학과 - 한양대학교');


################################### tbl_career

CREATE TABLE `tbl_title` (
                             `title_id`	INT	NOT NULL PRIMARY KEY	AUTO_INCREMENT,
                             `title_name`	VARCHAR(255)	NOT NULL
);

INSERT INTO `tbl_title` (`title_name`)
VALUES
    ('코드 마스터'),
    ('디버그 퀸'),
    ('AI 챔피언'),
    ('웹 마법사'),
    ('프론트엔드 대가'),
    ('백엔드 제왕'),
    ('클라우드 왕'),
    ('알고리즘 천재'),
    ('블록체인 프로'),
    ('개발의 신');

CREATE TABLE `tbl_title_list` (
                                  `user_id`	INT	NOT NULL,
                                  `title_id`	INT	NOT NULL,
                                  CONSTRAINT fk_title_list_to_user  FOREIGN KEY (user_id) REFERENCES tbl_user(user_id),
                                  CONSTRAINT fk_title_list_to_title  FOREIGN KEY (title_id) REFERENCES tbl_title(title_id)
);

INSERT INTO `tbl_title_list` (`user_id`, `title_id`)
VALUES
    (12, 4),
    (36, 7),
    (2, 9),
    (45, 3),
    (17, 5),
    (39, 2),
    (8, 6),
    (13, 8),
    (22, 1),
    (29, 10),
    (10, 4),
    (31, 6),
    (3, 2),
    (48, 7),
    (26, 9),
    (14, 5),
    (49, 1),
    (6, 3),
    (18, 8),
    (41, 10),
    (33, 4),
    (23, 6),
    (19, 2),
    (11, 7),
    (40, 1),
    (4, 5),
    (9, 10),
    (25, 3),
    (21, 8),
    (28, 9),
    (38, 4),
    (24, 6),
    (46, 2),
    (30, 7),
    (35, 5),
    (47, 3),
    (5, 1),
    (20, 10),
    (50, 8),
    (27, 4),
    (43, 2),
    (44, 9),
    (15, 7),
    (34, 3),
    (7, 5),
    (16, 1),
    (32, 6),
    (42, 10);

################################ tbl_title / tbl_title_list

CREATE TABLE `tbl_mail` (
                            `mail_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                            `sender_id` INT NOT NULL,
                            `receiver_id` INT NOT NULL,
                            `content` VARCHAR(255) NOT NULL,
                            `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO `tbl_mail` (`sender_id`, `receiver_id`, `content`)
VALUES
    (1, 7, '안녕하세요! 새로운 프로젝트에 대해 논의해보면 좋겠습니다.'),
    (2, 10, '코드 리뷰 진행할 준비 되셨나요?'),
    (3, 8, '디버깅 관련해서 도움이 필요하시면 말씀해 주세요.'),
    (4, 5, '최근 프로젝트에 대해 의견을 공유하고 싶어요.'),
    (5, 6, '안녕하세요! 프론트엔드 관련 자료가 필요해서 문의드립니다.'),
    (6, 12, '이번 주 워크샵 준비는 어떻게 되어 가고 있나요?'),
    (7, 9, '백엔드 시스템 테스트에 관련된 질문이 있습니다.'),
    (8, 4, 'AI 프로젝트 관련해서 아이디어를 하나 드리고 싶어요.'),
    (9, 3, '지금 진행 중인 프로젝트 코드 리팩토링을 제안드립니다.'),
    (10, 15, '알고리즘 문제 해결을 위해 추가 자료가 필요합니다.'),
    (11, 1, '테스트 자동화 도구 사용법을 공유드릴게요.'),
    (12, 13, '클라우드 인프라 설정에 대해 문의드려요.'),
    (13, 2, '이번 프로젝트 진행상황을 공유하려고 합니다.'),
    (14, 16, '새로운 기술 스택에 대해 이야기 나누고 싶어요.'),
    (15, 18, '디버깅 중 이상한 오류가 발생했습니다. 도움을 요청합니다.'),
    (16, 20, '프론트엔드 성능 최적화 관련하여 제안드립니다.'),
    (17, 9, '백엔드 서버의 보안 업데이트가 필요합니다.'),
    (18, 14, '최근 작업한 코드 리뷰 부탁드려요.'),
    (19, 22, '팀 프로젝트 회의 일정에 대해 알려주세요.'),
    (20, 1, '추가적인 기능 구현을 위해 협업이 필요합니다.'),
    (21, 3, '새로운 Git 브랜치에 대한 설명을 드리고 싶어요.'),
    (22, 7, 'UI 디자인을 변경하는 것이 좋겠다고 생각합니다.'),
    (23, 17, 'AI 알고리즘 테스트에 대한 피드백을 주셨으면 합니다.'),
    (24, 19, '코드 리팩토링에 대해 논의하고 싶습니다.'),
    (25, 13, '데이터베이스 최적화 작업을 위해 도움이 필요합니다.'),
    (26, 8, '새로운 라이브러리 설치 관련 질문이 있습니다.'),
    (27, 21, '이번 주 회의에서 논의할 주제가 있습니다.'),
    (28, 16, '프로젝트 진행 상황에 대해 피드백을 주셨으면 합니다.'),
    (29, 2, '새로운 팀원이 오게 되었으니 환영해 주세요!'),
    (30, 6, '새로운 기술 스택을 배우고 있는데 도움이 필요합니다.'),
    (31, 25, '서버 상태 체크해보셨나요?'),
    (32, 18, '작업 중인 API에 대해 논의하고 싶습니다.'),
    (33, 4, '새로운 Git 업데이트 사항을 공유드릴게요.'),
    (34, 22, '백엔드 시스템에 대해 개선할 점이 있습니다.'),
    (35, 10, '이번 주 데모 준비는 어떻게 되어 가고 있나요?'),
    (36, 28, 'UI 디자인에서 일부 수정이 필요해 보입니다.'),
    (37, 17, '프론트엔드 개발에서 진행 상황을 업데이트 드립니다.'),
    (38, 8, '안녕하세요! 기능 구현에 필요한 사항을 알려주세요.'),
    (39, 6, '이번 주 팀 회의 자료 준비가 완료되었습니다.'),
    (40, 5, '프로그래밍 관련 질문이 있습니다. 답변 부탁드려요.'),
    (41, 23, '개발 환경 설정을 변경해야 할 것 같습니다.'),
    (42, 9, '다음 버전 업데이트를 위한 계획을 논의하고 싶어요.'),
    (43, 18, '디버깅을 위해 코드를 다시 살펴보세요.'),
    (44, 6, 'AWS 설정에 대해 의견을 나누고 싶습니다.'),
    (45, 14, '이번 주 개발 일정에 대해 논의할 필요가 있습니다.'),
    (46, 7, '백엔드 API 호출에 문제가 발생했습니다.'),
    (47, 2, '서버 로그를 확인했더니 오류가 있네요.'),
    (48, 16, '프로젝트 코드가 최신 상태인지 점검해 주세요.'),
    (49, 28, '이번 주 코드 리뷰 일정에 대해 확인 부탁드립니다.'),
    (50, 22, '프론트엔드 스타일링 수정에 관한 피드백을 드리겠습니다.');

###################################################### tbl_mail

CREATE TABLE `tbl_board` (
                             `post_id`	INT	NOT NULL	PRIMARY KEY AUTO_INCREMENT,
                             `category`	INT	NOT NULL,
                             `title`	VARCHAR(255)	NOT NULL,
                             `content`	VARCHAR(255)	NOT NULL,
                             `created_at`	DATETIME	NOT NULL DEFAULT NOW(),
                             `modified_at`	DATETIME	NULL,
                             `is_blinded`	VARCHAR(255)	NOT NULL	DEFAULT 'N',
                             `is_deleted`	VARCHAR(255)	NOT NULL	DEFAULT 'N',
                             `user_id`	INT	NOT NULL
);

INSERT INTO tbl_board (category, title, content, created_at, modified_at, is_blinded, is_deleted, user_id)
VALUES
    (1, '자바에서 컬렉션 프레임워크 활용하기', '자바에서 컬렉션 프레임워크는 데이터를 다루는 중요한 도구입니다. 특히, List, Set, Map과 같은 다양한 컬렉션을 어떻게 활용할지에 대해 논의합니다.', '2024-02-01 10:30:00', NULL, 'N', 'N', 1),
    (2, 'Spring Boot와 REST API 설계', 'Spring Boot로 빠르게 REST API를 구축하는 방법과 주의사항을 다룹니다. 개발자가 겪을 수 있는 어려움과 해결책을 공유합니다.', '2024-01-22 14:20:00', NULL, 'N', 'N', 2),
    (3, '프론트엔드 성능 최적화', '프론트엔드 개발 시 성능을 최적화하는 방법, 리소스 로딩 최적화 및 코드 스플리팅 등에 대해 다룹니다.', '2024-03-12 09:15:00', NULL, 'N', 'N', 3),
    (1, '자바스크립트 비동기 처리', '자바스크립트에서 비동기 처리를 효율적으로 하는 방법과 그로 인한 성능 향상에 대해 설명합니다. Promise, async/await 등을 사용한 예제도 포함됩니다.', '2024-02-10 17:50:00', NULL, 'N', 'N', 4),
    (2, 'MySQL에서 인덱스 최적화 방법', 'MySQL에서 쿼리 성능을 향상시키기 위한 인덱스 활용법과 잘못된 인덱스 사용이 가져오는 문제에 대해 다룹니다.', '2024-01-15 11:00:00', NULL, 'N', 'N', 5),
    (3, 'Vue.js로 싱글 페이지 애플리케이션 개발', 'Vue.js를 사용하여 싱글 페이지 애플리케이션(SPA)을 만드는 방법과 Vue Router, Vuex 사용법에 대해 설명합니다.', '2024-03-01 13:30:00', NULL, 'N', 'N', 6),
    (1, 'Git에서의 병합 충돌 해결하기', 'Git을 사용할 때 발생할 수 있는 병합 충돌 상황을 해결하는 방법을 다루며, 효율적인 Git workflow에 대해서도 설명합니다.', '2024-02-28 08:00:00', NULL, 'N', 'N', 7),
    (2, 'Docker를 이용한 개발 환경 설정', 'Docker를 사용하여 개발 환경을 설정하는 방법과, 여러 개발 환경을 어떻게 관리할 수 있는지에 대해 설명합니다.', '2024-01-10 12:40:00', NULL, 'N', 'N', 8),
    (3, 'TypeScript와 JavaScript의 차이점', 'TypeScript와 JavaScript의 차이점을 비교하고, TypeScript의 장점과 활용 방법에 대해 다룹니다.', '2024-03-05 15:20:00', NULL, 'N', 'N', 9),
    (1, '서버 사이드 렌더링(SSR)과 클라이언트 사이드 렌더링(CSR) 비교', '서버 사이드 렌더링과 클라이언트 사이드 렌더링의 차이점과 각 방식의 장단점에 대해 설명합니다.', '2024-02-22 16:00:00', NULL, 'N', 'N', 10),
    (2, 'Node.js를 사용한 비동기 I/O 처리', 'Node.js의 비동기 I/O 모델을 사용하여 성능을 극대화하는 방법과, 서버 환경에서의 효율적인 데이터 처리를 설명합니다.', '2024-03-10 07:40:00', NULL, 'N', 'N', 11),
    (3, 'React에서 상태 관리 방법', 'React에서 상태를 관리하는 방법과, 상태 관리 라이브러리인 Redux, Context API 사용법에 대해 다룹니다.', '2024-01-25 09:30:00', NULL, 'N', 'N', 12),
    (1, '자바에서 멀티스레딩 구현하기', '자바에서 멀티스레딩을 활용하여 애플리케이션의 성능을 최적화하는 방법을 다룹니다.', '2024-02-05 18:10:00', NULL, 'N', 'N', 13),
    (2, 'Spring Security를 활용한 인증 및 권한 관리', 'Spring Security를 사용하여 애플리케이션의 인증 및 권한 관리를 구현하는 방법에 대해 설명합니다.', '2024-03-15 14:25:00', NULL, 'N', 'N', 14),
    (3, '클라우드 환경에서의 데이터베이스 설계', '클라우드 환경에 최적화된 데이터베이스 설계 방법에 대해 논의하고, 다양한 클라우드 서비스에 대해 다룹니다.', '2024-01-30 19:50:00', NULL, 'N', 'N', 15),
    (1, 'Spring Data JPA와 Hibernate 사용법', 'Spring Data JPA를 활용하여 데이터베이스와의 연동을 손쉽게 구현하는 방법을 설명합니다.', '2024-02-14 10:05:00', NULL, 'N', 'N', 16),
    (2, 'Redis를 활용한 캐시 처리', 'Redis를 사용하여 애플리케이션의 성능을 향상시키는 캐시 처리 방법에 대해 다룹니다.', '2024-01-12 13:15:00', NULL, 'N', 'N', 17),
    (3, 'Kubernetes와 Docker를 이용한 컨테이너 관리', 'Kubernetes와 Docker를 결합하여 컨테이너화된 애플리케이션을 관리하는 방법을 설명합니다.', '2024-02-18 20:30:00', NULL, 'N', 'N', 18),
    (1, 'Python에서 함수형 프로그래밍', 'Python에서 함수형 프로그래밍의 개념과 이를 활용하는 방법을 설명합니다.', '2024-03-08 11:45:00', NULL, 'N', 'N', 19),
    (2, 'GraphQL을 이용한 데이터 요청 처리', 'GraphQL을 사용하여 REST API의 단점을 해결하고, 효율적인 데이터 요청 방식을 구현하는 방법을 다룹니다.', '2024-01-20 16:00:00', NULL, 'N', 'N', 20);

-- 더미 데이터 추가 (같은 user_id로 여러 개의 글 작성)
INSERT INTO tbl_board (category, title, content, created_at, modified_at, is_blinded, is_deleted, user_id)
VALUES
    (1, '자바에서 쓰레드 풀 활용하기', '자바에서 쓰레드 풀을 사용하여 멀티스레딩을 효율적으로 관리하는 방법을 설명합니다.', '2024-03-10 08:00:00', NULL, 'N', 'N', 1),
    (2, 'Spring Boot에서 CORS 설정하기', 'Spring Boot 애플리케이션에서 CORS 설정을 통해 외부 도메인과의 데이터 교환을 허용하는 방법을 다룹니다.', '2024-02-28 14:00:00', NULL, 'N', 'N', 1),
    (3, 'React에서 상태 변경 최적화', 'React에서 상태 업데이트 최적화하는 방법과 성능 향상 기술을 다룹니다.', '2024-01-30 11:00:00', NULL, 'N', 'N', 1),
    (1, 'Java 8 람다식 활용법', 'Java 8에서 도입된 람다식에 대해 소개하고, 이를 어떻게 활용할 수 있는지 예제와 함께 설명합니다.', '2024-02-15 16:10:00', NULL, 'N', 'N', 2),
    (2, 'Spring Security OAuth2 인증 구현하기', 'Spring Security를 이용하여 OAuth2 인증을 구현하는 방법과 이를 사용하여 보안 강화 방법을 다룹니다.', '2024-03-02 12:30:00', NULL, 'N', 'N', 2),
    (3, 'Vue.js와 Vuex로 상태 관리하기', 'Vue.js와 Vuex를 사용하여 애플리케이션 상태를 관리하는 방법에 대해 다룹니다.', '2024-01-10 10:20:00', NULL, 'N', 'N', 2),
    (1, 'MySQL 쿼리 성능 최적화', 'MySQL에서 쿼리 성능을 최적화하는 방법에 대해 설명합니다. 인덱스 활용, 쿼리 리팩토링 등을 다룹니다.', '2024-02-25 17:15:00', NULL, 'N', 'N', 3),
    (2, 'Git에서 Merge 충돌 해결하기', 'Git을 사용하다 보면 merge 충돌이 발생할 수 있습니다. 이를 어떻게 해결할 수 있는지에 대해 설명합니다.', '2024-03-05 09:25:00', NULL, 'N', 'N', 3),
    (3, 'TypeScript의 타입 시스템', 'TypeScript의 타입 시스템을 이해하고 이를 활용하는 방법에 대해 설명합니다.', '2024-01-18 14:45:00', NULL, 'N', 'N', 3),
    (1, 'Kotlin에서 Android 앱 개발하기', 'Kotlin을 사용하여 Android 앱을 개발하는 방법에 대해 설명합니다. Kotlin의 특징과 Android Studio 사용법을 다룹니다.', '2024-02-12 20:05:00', NULL, 'N', 'N', 4),
    (2, 'React Native로 모바일 앱 개발하기', 'React Native를 사용하여 Android와 iOS 앱을 동시에 개발하는 방법에 대해 설명합니다.', '2024-01-20 08:30:00', NULL, 'N', 'N', 4),
    (3, 'Spring Boot에서 테스트 코드 작성하기', 'Spring Boot에서의 단위 테스트와 통합 테스트를 작성하는 방법에 대해 설명합니다.', '2024-03-08 18:00:00', NULL, 'N', 'N', 4),
    (1, 'Redis를 활용한 캐시 처리', 'Redis를 활용하여 자주 사용되는 데이터를 캐시하고, 데이터베이스 부하를 줄이는 방법을 다룹니다.', '2024-01-25 13:40:00', NULL, 'N', 'N', 5),
    (2, 'Docker 컨테이너 최적화', 'Docker의 성능을 최적화하여 컨테이너에서의 리소스 사용을 줄이는 방법에 대해 설명합니다.', '2024-03-01 15:10:00', NULL, 'N', 'N', 5),
    (3, 'Vue.js로 SPA 만들기', 'Vue.js를 사용하여 싱글 페이지 애플리케이션(SPA)을 만드는 방법과 관련된 내용을 다룹니다.', '2024-02-03 19:35:00', NULL, 'N', 'N', 5),
    (1, 'Java에서 Exception 처리하기', 'Java에서 예외를 처리하는 기본적인 방법과 고급 예외 처리 기법을 다룹니다.', '2024-02-17 11:30:00', NULL, 'N', 'N', 6),
    (2, 'Spring Boot에서 JMS 사용하기', 'Spring Boot에서 JMS를 사용하여 메시징 시스템을 구축하는 방법을 설명합니다.', '2024-03-03 16:40:00', NULL, 'N', 'N', 6),
    (3, 'MongoDB에서 NoSQL 활용법', 'MongoDB를 사용하여 비정형 데이터를 관리하는 방법과 NoSQL 데이터베이스의 장단점을 다룹니다.', '2024-02-22 10:15:00', NULL, 'N', 'N', 6);

#################################################### tbl_board

CREATE TABLE `tbl_comment` (
                               `comment_id`	INT	NOT NULL PRIMARY KEY AUTO_INCREMENT,
                               `comment_content`	VARCHAR(255)	NOT NULL,
                               `created_at`	DATETIME	NOT NULL	DEFAULT NOW(),
                               `updated_at`	DATETIME	NULL,
                               `is_blinded`	VARCHAR(255)	NOT NULL	DEFAULT 'N',
                               `is_deleted`	VARCHAR(255)	NOT NULL	DEFAULT 'N',
                               `user_id`	INT	NOT NULL,
                               `post_id`	INT	NULL,
                               `ref_comment_id`	INT	NULL
);

-- 더미 데이터 삽입 (50개)
INSERT INTO tbl_comment (comment_content, created_at, updated_at, is_blinded, is_deleted, user_id, post_id, ref_comment_id)
VALUES
    ('이 글 정말 유익합니다. 감사합니다!', '2024-02-10 14:30:00', NULL, 'N', 'N', 1, 1, NULL),
    ('저도 비슷한 경험을 했습니다. 좋은 정보 감사해요!', '2024-03-01 09:15:00', NULL, 'N', 'N', 1, 2, NULL),
    ('질문이 있습니다. 이 부분이 이해가 안 되네요. 좀 더 자세히 설명해주실 수 있나요?', '2024-01-15 18:10:00', NULL, 'N', 'N', 2, 3, NULL),
    ('답변 감사합니다. 이제 이해됐어요!', '2024-02-20 13:40:00', NULL, 'N', 'N', 3, 3, 1),
    ('훌륭한 글입니다! 관련 자료 더 보고 싶습니다.', '2024-01-05 11:25:00', NULL, 'N', 'N', 4, 4, NULL),
    ('이 방법은 제게 도움이 많이 됐습니다. 추가적인 팁이 있으면 알려주세요.', '2024-02-17 17:00:00', NULL, 'N', 'N', 4, 5, NULL),
    ('아직 잘 이해되지 않네요. 다시 한 번 자세히 설명 부탁드립니다.', '2024-01-25 12:30:00', NULL, 'N', 'N', 5, 6, NULL),
    ('참고하겠습니다. 감사합니다!', '2024-03-03 19:50:00', NULL, 'N', 'N', 6, 7, NULL),
    ('이 부분에서 오류가 발생하네요. 해결 방법을 알 수 있을까요?', '2024-02-12 20:00:00', NULL, 'N', 'N', 7, 8, NULL),
    ('저도 같은 문제가 있었는데, 해결 방법을 찾았습니다. 공유드립니다!', '2024-03-02 08:40:00', NULL, 'N', 'N', 7, 8, 1),
    ('좋은 글 감사합니다. 매우 유익했습니다.', '2024-02-08 10:20:00', NULL, 'N', 'N', 8, 9, NULL),
    ('초보자에게 너무 도움이 되는 글입니다. 감사합니다.', '2024-01-28 14:55:00', NULL, 'N', 'N', 9, 10, NULL),
    ('이해는 가는데, 추가적으로 설명해주실 수 있을까요?', '2024-02-25 17:30:00', NULL, 'N', 'N', 10, 11, NULL),
    ('자세한 설명 감사합니다! 이제 잘 이해됐습니다.', '2024-03-04 16:00:00', NULL, 'N', 'N', 11, 12, NULL),
    ('이 내용은 정말 중요한 정보네요. 놓칠 뻔 했습니다!', '2024-02-05 12:10:00', NULL, 'N', 'N', 12, 13, NULL),
    ('좋은 자료 감사해요! 이 방법으로 실험해볼게요.', '2024-01-12 11:30:00', NULL, 'N', 'N', 13, 14, NULL),
    ('한 가지 궁금한 점이 있는데, 이 방법이 다른 환경에서도 통할까요?', '2024-03-07 15:20:00', NULL, 'N', 'N', 14, 15, NULL),
    ('이제 이 문제를 해결할 수 있을 것 같습니다. 감사합니다.', '2024-02-18 09:40:00', NULL, 'N', 'N', 15, 16, NULL),
    ('이 부분에서 좀 더 자세히 설명해주시면 좋을 것 같습니다.', '2024-01-30 17:10:00', NULL, 'N', 'N', 16, 17, NULL),
    ('좋은 정보를 얻었습니다. 덕분에 이 문제를 해결할 수 있었어요.', '2024-03-06 14:00:00', NULL, 'N', 'N', 17, 18, NULL),
    ('이 글을 읽고 많은 도움이 됐습니다. 감사합니다.', '2024-02-09 13:25:00', NULL, 'N', 'N', 18, 19, NULL),
    ('제 경우에는 이 방법이 잘 안 됐습니다. 다른 방법을 알고 계신가요?', '2024-01-22 18:55:00', NULL, 'N', 'N', 19, 20, NULL),
    ('다시 한번 더 확인해보겠습니다. 감사합니다.', '2024-03-05 11:00:00', NULL, 'N', 'N', 20, 21, NULL),
    ('관련 링크를 추가해주시면 더 좋을 것 같아요.', '2024-02-04 10:50:00', NULL, 'N', 'N', 20, 22, NULL),
    ('잘 정리된 글입니다. 감사합니다!', '2024-01-14 12:40:00', NULL, 'N', 'N', 21, 23, NULL),
    ('이 문제를 해결하려면 어떻게 해야 할까요?', '2024-02-11 08:00:00', NULL, 'N', 'N', 22, 24, NULL),
    ('이 부분에서 문제가 발생했는데, 해결 방법을 알려주실 수 있나요?', '2024-03-09 16:45:00', NULL, 'N', 'N', 22, 25, NULL),
    ('이 정보는 정말 유용하네요. 도움이 많이 됐습니다!', '2024-02-16 11:05:00', NULL, 'N', 'N', 23, 26, NULL),
    ('답변 감사합니다. 잘 해결됐습니다.', '2024-01-18 13:25:00', NULL, 'N', 'N', 24, 27, NULL),
    ('이 부분은 다른 해결 방법도 있을까요?', '2024-03-10 19:30:00', NULL, 'N', 'N', 25, 28, NULL),
    ('정말 좋은 자료입니다. 감사합니다.', '2024-02-21 09:35:00', NULL, 'N', 'N', 26, 29, NULL),
    ('이 부분은 조금 더 설명이 필요해 보입니다.', '2024-01-27 14:15:00', NULL, 'N', 'N', 27, 30, NULL),
    ('대댓글을 달고 싶습니다.', '2024-03-11 13:10:00', NULL, 'N', 'N', 28, 31, NULL),
    ('이 부분을 더 자세히 설명해주시면 좋겠습니다.', '2024-02-08 12:25:00', NULL, 'N', 'N', 28, 32, 1),
    ('이 문제를 해결하려면 다른 방법도 있을까요?', '2024-01-25 16:50:00', NULL, 'N', 'N', 29, 33, NULL),
    ('이 방법은 저에게 잘 맞았습니다. 유용한 정보 감사합니다.', '2024-02-02 18:40:00', NULL, 'N', 'N', 30, 34, NULL),
    ('답변 감사합니다. 많은 도움이 됐습니다.', '2024-03-04 08:10:00', NULL, 'N', 'N', 31, 35, NULL),
    ('참고하겠습니다. 좋은 정보 감사합니다.', '2024-01-17 14:35:00', NULL, 'N', 'N', 32, 36, NULL),
    ('추가적인 정보가 더 있으면 좋겠네요.', '2024-02-03 15:20:00', NULL, 'N', 'N', 33, 37, NULL),
    ('이 부분에서 오류가 나서 다시 확인해볼게요.', '2024-03-01 12:50:00', NULL, 'N', 'N', 34, 38, NULL),
    ('잘 설명해주셔서 감사합니다. 많이 배웠습니다.', '2024-02-24 17:00:00', NULL, 'N', 'N', 35, 1, NULL),
    ('이 내용 정말 유용합니다. 감사해요!', '2024-01-19 10:10:00', NULL, 'N', 'N', 36, 2, NULL);

######################################################## tbl_comment

CREATE TABLE `tbl_like` (
                            `post_id`	INT	NOT NULL,
                            `user_id`	INT	NOT NULL,
                            CONSTRAINT fk_tbl_like_to_tbl_board FOREIGN KEY (post_id) REFERENCES tbl_board(post_id),
                            CONSTRAINT fk_tbl_like_to_tbl_user FOREIGN KEY (user_id) REFERENCES tbl_user(user_id)
);

INSERT INTO `tbl_like` (`post_id`, `user_id`)
VALUES
    (5, 12),
    (16, 3),
    (29, 48),
    (9, 21),
    (12, 45),
    (7, 10),
    (25, 1),
    (30, 19),
    (22, 8),
    (14, 28),
    (26, 11),
    (18, 43),
    (1, 17),
    (8, 29),
    (4, 35),
    (20, 9),
    (28, 47),
    (27, 6),
    (10, 13),
    (6, 42),
    (23, 50),
    (11, 18),
    (2, 33),
    (19, 37),
    (15, 25),
    (3, 34),
    (24, 23),
    (17, 44),
    (13, 30),
    (18, 41),
    (12, 20),
    (30, 16),
    (9, 14),
    (27, 31),
    (28, 4),
    (6, 40),
    (20, 24),
    (25, 36),
    (7, 15),
    (10, 49),
    (1, 2),
    (29, 22),
    (8, 48),
    (1,8),
    (9,4),
    (23, 38),
    (13, 33),
    (10,10),
    (8,8),
    (23,1);

CREATE TABLE `tbl_bookmark` (
                                `post_id`	INT	NOT NULL,
                                `user_id`	INT	NOT NULL,
                                CONSTRAINT fk_tbl_bookmark_to_tbl_board FOREIGN KEY (post_id) REFERENCES tbl_board(post_id),
                                CONSTRAINT fk_tbl_bookmark_to_tbl_user FOREIGN KEY (user_id) REFERENCES tbl_user(user_id)
);

-- 무작위로 섞인 50개의 더미 데이터 삽입
INSERT INTO tbl_bookmark (post_id, user_id)
VALUES
    (1, 10),
    (2, 15),
    (3, 25),
    (4, 40),
    (5, 7),
    (6, 14),
    (7, 21),
    (8, 35),
    (9, 3),
    (10, 8),
    (11, 16),
    (12, 24),
    (13, 11),
    (14, 30),
    (15, 50),
    (16, 33),
    (17, 2),
    (18, 19),
    (19, 27),
    (20, 5),
    (21, 36),
    (22, 12),
    (23, 38),
    (24, 22),
    (25, 9),
    (26, 31),
    (27, 43),
    (28, 28),
    (29, 18),
    (30, 45),
    (31, 4),
    (32, 37),
    (33, 29),
    (34, 48),
    (35, 6),
    (36, 44),
    (37, 32),
    (38, 20),
    (1, 26),
    (2, 49),
    (3, 23),
    (4, 34),
    (5, 47),
    (6, 46),
    (7, 42),
    (8, 13),
    (9, 39),
    (10, 41),
    (11, 50),
    (12, 1),
    (13, 17);

###################################################### tbl_like / tbl_bookmark

CREATE TABLE `tbl_report_category` (
                                       `violation_id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                                       `minus_point` INT NOT NULL,
                                       `content` VARCHAR(255) NOT NULL,
                                       `category_name` VARCHAR(255) NOT NULL
);


INSERT INTO `tbl_report_category` (`minus_point`, `content`, `category_name`)
VALUES
    (10, '부적절한 언어 사용', '언어폭력'),
    (30, '불법적인 내용의 게시물 업로드', '불법콘텐츠'),
    (50, '허위 정보 유포', '허위정보'),
    (100, '반복적인 악성 댓글 달기', '악성댓글'),
    (30, '게시물에서 다른 사용자 비방', '비방행위'),
    (50, '회원 간 개인 정보 유출', '개인정보'),
    (10, '불법 광고 게시물 등록', '광고/스팸'),
    (100, '반복적으로 커뮤니티 규정 위반', '규칙위반'),
    (10, '스팸 메시지 전송', '스팸'),
    (50, '타인의 저작물 무단 복제', '저작권침해');


############################################################# tbl_report_category

CREATE TABLE `tbl_report` (
                              `report_id`	INT	NOT NULL PRIMARY KEY AUTO_INCREMENT,
                              `report_content`	VARCHAR(255)	NULL,
                              `created_at`	DATETIME	NOT NULL    DEFAULT NOW(),
                              `is_processed`	VARCHAR(255)	NOT NULL	DEFAULT 'N',
                              `is_processed_time`	DATETIME NULL,
                              `poster_id`	INT NOT NULL,
                              `report_target_post_id`	INT	NULL,
                              `report_target_user_id`	INT	NULL,
                              `comment_id`	INT	NULL,
                              violation_id INT NOT NULL,
                              CONSTRAINT fk_tbl_report_to_tbl_user FOREIGN KEY (poster_id) REFERENCES tbl_user(user_id),
                              CONSTRAINT fk_tbl_report_to_tbl_board FOREIGN KEY (report_target_post_id) REFERENCES tbl_board(post_id),
                              CONSTRAINT fk_tbl_report_to_tbl_user2 FOREIGN KEY (report_target_user_id) REFERENCES tbl_user(user_id),
                              CONSTRAINT fk_tbl_report_to_tbl_comment FOREIGN KEY (comment_id) REFERENCES tbl_comment(comment_id),
                              CONSTRAINT fk_tbl_report_to_tbl_report_category FOREIGN KEY (violation_id) REFERENCES tbl_report_category(violation_id)
);

INSERT INTO `tbl_report` (`report_content`, `created_at`, `is_processed`, `is_processed_time`, `poster_id`, `report_target_post_id`, `report_target_user_id`, `comment_id`, `violation_id`)
VALUES
    ('불법적인 게시물 신고', '2025-03-12 14:30:00', 'N', NULL, 5, 7, NULL, NULL, 1),
    ('욕설이 포함된 댓글 신고', '2025-03-11 10:45:00', 'N', NULL, 2, NULL, 8, NULL, 2),
    ('부적절한 이미지가 포함된 게시물 신고', '2025-03-09 11:00:00', 'Y', '2025-03-10 14:20:00', 15, NULL, NULL, NULL, 3),
    ('허위 정보가 포함된 게시물 신고', '2025-03-07 09:15:00', 'N', NULL, 18, 1, NULL, NULL, 4),
    ('사용자 정보 유출된 게시물 신고', '2025-03-05 13:30:00', 'Y', '2025-03-06 17:10:00', 10, NULL, 12, NULL, 5),
    ('사기 게시물 신고', '2025-03-03 08:40:00', 'N', NULL, 3, NULL, 27, NULL, 6),
    ('불법 거래 광고 게시물 신고', '2025-03-02 14:20:00', 'N', NULL, 8, NULL, NULL, NULL, 7),
    ('타인의 개인정보 노출된 댓글 신고', '2025-02-28 11:55:00', 'Y', '2025-02-28 18:00:00', 22, NULL, NULL, 33, 8),
    ('성희롱 댓글 신고', '2025-02-26 10:30:00', 'N', NULL, 19, NULL, 48, NULL, 9),
    ('모욕적인 발언이 포함된 게시물 신고', '2025-02-24 16:10:00', 'N', NULL, 13, 2, NULL, NULL, 10),
    ('저작권 침해 게시물 신고', '2025-02-22 12:00:00', 'N', NULL, 6, NULL, NULL, NULL, 1),
    ('불법 다운로드 링크 게시물 신고', '2025-02-20 14:30:00', 'Y', '2025-02-21 12:20:00', 28, NULL, NULL, NULL, 2),
    ('비방 댓글 신고', '2025-02-18 17:00:00', 'Y', '2025-02-19 09:10:00', 12, NULL, NULL, 4, 3),
    ('혐오 표현이 포함된 댓글 신고', '2025-02-16 13:40:00', 'N', NULL, 9, NULL, NULL, 27, 4),
    ('사생활 침해 게시물 신고', '2025-02-14 10:30:00', 'N', NULL, 21, NULL, NULL, NULL, 5),
    ('허위 리뷰 게시물 신고', '2025-02-12 15:20:00', 'Y', '2025-02-13 14:50:00', 14, 14, NULL, NULL, 6),
    ('불법 촬영물 게시물 신고', '2025-02-10 08:50:00', 'N', NULL, 16, NULL, NULL, NULL, 7),
    ('불법 홍보 게시물 신고', '2025-02-08 09:30:00', 'Y', '2025-02-09 12:00:00', 23, NULL, NULL, NULL, 8),
    ('낚시성 게시물 신고', '2025-02-06 11:00:00', 'N', NULL, 20, NULL, NULL, 19, 9),
    ('다른 사용자 명예 훼손 게시물 신고', '2025-02-04 13:40:00', 'N', NULL, 30, NULL, NULL, NULL, 10),
    ('무분별한 광고 게시물 신고', '2025-02-02 10:20:00', 'Y', '2025-02-03 11:00:00', 7, NULL, 50, NULL, 1),
    ('타인의 권리 침해 댓글 신고', '2025-01-31 14:10:00', 'N', NULL, 26, NULL, NULL, 26, 2),
    ('잘못된 정보 제공 게시물 신고', '2025-01-29 16:30:00', 'N', NULL, 5, NULL, NULL, NULL, 3),
    ('사기성 댓글 신고', '2025-01-27 11:50:00', 'N', NULL, 31, NULL, 7, NULL, 4),
    ('명백한 거짓 주장 포함 게시물 신고', '2025-01-25 10:00:00', 'N', NULL, 24, NULL, NULL, NULL, 5),
    ('음란물 포함 게시물 신고', '2025-01-23 15:10:00', 'N', NULL, 11, NULL, NULL, NULL, 6),
    ('온라인 괴롭힘 게시물 신고', '2025-01-21 09:20:00', 'Y', '2025-01-22 14:00:00', 17, NULL, 29, 4, 7),
    ('부적절한 광고 게시물 신고', '2025-01-19 08:40:00', 'N', NULL, 34, NULL, NULL, NULL, 8),
    ('편파적인 게시물 신고', '2025-01-17 13:00:00', 'N', NULL, 40, NULL, NULL, 3, 9),
    ('인종차별적 발언 포함 게시물 신고', '2025-01-15 14:30:00', 'N', NULL, 18, NULL, 19, NULL, 10),
    ('명예훼손성 댓글 신고', '2025-01-13 10:50:00', 'N', NULL, 8, NULL, NULL, 22, 1),
    ('무단 전재 게시물 신고', '2025-01-11 11:00:00', 'N', NULL, 32, NULL, NULL, NULL, 2),
    ('피싱 사이트 링크 포함 게시물 신고', '2025-01-09 09:30:00', 'N', NULL, 27, NULL, 45, NULL, 3),
    ('부정확한 정보 제공 게시물 신고', '2025-01-07 15:40:00', 'Y', '2025-01-08 17:10:00', 29, NULL, NULL, NULL, 4),
    ('자기 홍보성 게시물 신고', '2025-01-05 10:20:00', 'N', NULL, 12, NULL, NULL, 13, 5);

######################################################################################### tbl_report

CREATE TABLE `tbl_mentor_list` (
                                   `mentor_id`	INT NOT NULL PRIMARY KEY,
                                   `m_expert`	VARCHAR(255)	NULL,
                                   `m_content`	VARCHAR(255)	NULL,
                                   `is_deleted`	VARCHAR(255)	NOT NULL	DEFAULT 'N'
);

-- 개발자 멘토 5명 추가
INSERT INTO tbl_mentor_list (mentor_id, m_expert, m_content, is_deleted)
VALUES
    (1, '웹 개발', 'HTML, CSS, JavaScript, React.js, Node.js 경험이 풍부한 웹 개발 전문가', 'N'),
    (2, '백엔드 개발', 'Java, Spring, MySQL, API 설계와 최적화에 능숙한 백엔드 개발 전문가', 'N'),
    (3, '모바일 개발', 'Android, Kotlin, iOS 개발, React Native 등 다양한 모바일 앱 개발 경험이 있는 전문가', 'N'),
    (4, 'DevOps', 'AWS, Docker, CI/CD, Kubernetes 등을 활용한 클라우드 인프라 구축 및 관리 전문가', 'N'),
    (5, '게임 개발', 'Unity, C#, Unreal Engine, 게임 기획 및 개발에 특화된 멘토', 'N');

################################################################ tbl_mentor_list

CREATE TABLE tbl_mentoring_space (
                                     mentoring_space_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                                     personal_information VARCHAR(255),
                                     information_is_opened VARCHAR(255) NOT NULL,
                                     personal_info_requested VARCHAR(255) NOT NULL DEFAULT 'N',
                                     extension_count INT NOT NULL DEFAULT 0,
                                     extension_requested VARCHAR(255) NOT NULL DEFAULT 'N',
                                     is_activated VARCHAR(255) NOT NULL DEFAULT 'Y',
                                     mentor_id INT NOT NULL,
                                     CONSTRAINT fk_tbl_mentoring_space_to_tbl_mentor_list
                                         FOREIGN KEY (mentor_id) REFERENCES tbl_mentor_list(mentor_id)
);

INSERT INTO tbl_mentoring_space (
    personal_information,
    information_is_opened,
    personal_info_requested,
    extension_count,
    extension_requested,
    is_activated,
    mentor_id
) VALUES
      ('연락처: 010-1234-5678, 카카오톡 ID: mentor1', 'N', 'N', 0, 'N', 'Y', 1),
      ('연락처: 010-2345-6789, 카카오톡 ID: devmentor2', 'Y', 'N', 2, 'N', 'Y', 2),
      ('연락처: 010-3456-7890, 카카오톡 ID: codingexpert3', 'Y', 'N', 0, 'N', 'Y', 3),
      ('연락처: 010-4567-8901, 카카오톡 ID: pythonmentor4', 'Y', 'N', 1, 'N', 'Y', 4),
      ('연락처: 010-5678-9012, 카카오톡 ID: javaandroid5', 'N', 'N', 0, 'N', 'Y', 5),
      ('연락처: 010-6789-0123, 카카오톡 ID: reactmentor1', 'Y', 'N', 0, 'N', 'Y', 1),
      ('연락처: 010-7890-1234, 카카오톡 ID: expressjsmentor2', 'N', 'N', 1, 'N', 'Y', 2),
      ('연락처: 010-8901-2345, 카카오톡 ID: javaexpert3', 'Y', 'N', 0, 'N', 'Y', 3),
      ('연락처: 010-9012-3456, 카카오톡 ID: aihelper4', 'N', 'N', 0, 'N', 'N', 4),
      ('연락처: 010-0123-4567, 카카오톡 ID: vuejsmentor5', 'Y', 'N', 3, 'N', 'Y', 5),
      ('연락처: 010-1234-5678, 카카오톡 ID: nodementor1', 'N', 'N', 2, 'N', 'Y', 1),
      ('연락처: 010-2345-6789, 카카오톡 ID: jsreactmentor2', 'Y', 'N', 0, 'N', 'Y', 2),
      ('연락처: 010-3456-7890, 카카오톡 ID: datasciencementor3', 'N', 'N', 1, 'N', 'Y', 3),
      ('연락처: 010-4567-8901, 카카오톡 ID: springbootmentor4', 'Y', 'N', 3, 'N', 'Y', 4),
      ('연락처: 010-5678-9012, 카카오톡 ID: iosmentor5', 'N', 'N', 2, 'N', 'Y', 5),
      ('연락처: 010-6789-0123, 카카오톡 ID: javamentor1', 'N', 'N', 0, 'N', 'Y', 1),
      ('연락처: 010-7890-1234, 카카오톡 ID: reactreduxmentor2', 'N', 'N', 1, 'N', 'N', 2),
      ('연락처: 010-8901-2345, 카카오톡 ID: csharpmentor3', 'N', 'N', 0, 'N', 'Y', 3),
      ('연락처: 010-9012-3456, 카카오톡 ID: aiandmlmentor4', 'Y', 'N', 3, 'N', 'Y', 4),
      ('연락처: 010-0123-4567, 카카오톡 ID: angularmentor5', 'Y', 'N', 4, 'N', 'Y', 5),
      ('연락처: 010-1234-5678, 카카오톡 ID: pythonreactmentor1', 'N', 'N', 0, 'N', 'Y', 1),
      ('연락처: 010-2345-6789, 카카오톡 ID: rubyrailsmentor2', 'Y', 'N', 3, 'N', 'Y', 2),
      ('연락처: 010-3456-7890, 카카오톡 ID: javaexpertmentor3', 'N', 'N', 2, 'N', 'Y', 3),
      ('연락처: 010-4567-8901, 카카오톡 ID: kotlinmentor4', 'N', 'N', 0, 'N', 'Y', 4),
      ('연락처: 010-5678-9012, 카카오톡 ID: htmlcssmentor5', 'Y', 'N', 4, 'N', 'Y', 5),
      ('연락처: 010-6789-0123, 카카오톡 ID: vuejstypescriptmentor1', 'N', 'N', 0, 'N', 'Y', 1),
      ('연락처: 010-7890-1234, 카카오톡 ID: javaspringmentor2', 'Y', 'N', 3, 'N', 'Y', 2),
      ('연락처: 010-8901-2345, 카카오톡 ID: vuefirebasementor3', 'Y', 'N', 0, 'N', 'N', 3),
      ('연락처: 010-9012-3456, 카카오톡 ID: aimentalmentor4', 'Y', 'N', 2, 'N', 'Y', 4),
      ('연락처: 010-0123-4567, 카카오톡 ID: javascriptmentor5', 'Y', 'N', 0, 'N', 'Y', 5);

CREATE TABLE `tbl_mentoring_member` (
                                        `mentoring_space_id`	INT	NOT NULL,
                                        `user_id`	INT	NOT NULL,
                                        `leftover_questions`	INT	NOT NULL	DEFAULT 10,
                                        CONSTRAINT fk_tbl_mentoring_member_to_tbl_mentoring_space FOREIGN KEY (mentoring_space_id) REFERENCES tbl_mentoring_space(mentoring_space_id),
                                        CONSTRAINT fk_tbl_mentoring_member_to_tbl_user FOREIGN KEY (user_id) REFERENCES tbl_user(user_id)
);

INSERT INTO `tbl_mentoring_member` (
                                     `mentoring_space_id`
                                   , `user_id`
                                   , `leftover_questions`
) VALUES
      (1, 23, 3),
      (2, 45, 7),
      (3, 12, 9),
      (4, 34, 2),
      (5, 50, 10),
      (6, 8, 5),
      (7, 19, 4),
      (8, 3, 6),
      (9, 29, 8),
      (10, 41, 1),
      (11, 25, 10),
      (12, 9, 6),
      (13, 22, 8),
      (14, 17, 4),
      (15, 38, 9),
      (16, 7, 2),
      (17, 33, 5),
      (18, 16, 7),
      (19, 13, 3),
      (20, 5, 10),
      (21, 48, 6),
      (22, 27, 8),
      (23, 46, 1),
      (24, 2, 7),
      (25, 18, 2),
      (26, 35, 6),
      (27, 49, 3),
      (28, 14, 5),
      (29, 26, 9),
      (30, 4, 4);

########################################################## tbl_mentoring_space / tbl_mentoring_member

CREATE TABLE `tbl_team_recruit` (
                                    `team_post_id`	INT	NOT NULL	PRIMARY KEY AUTO_INCREMENT,
                                    `post_title`	VARCHAR(255)	NOT NULL,
                                    `team_name`	VARCHAR(255)	NOT NULL,
                                    `team_introduce`	VARCHAR(255)	NOT NULL,
                                    `created_at`	DATETIME	NOT NULL	DEFAULT NOW(),
                                    `modified_at`	DATETIME	NULL,
                                    `is_deleted`	VARCHAR(255)	NOT NULL	DEFAULT 'N',
                                    `is_completed`	VARCHAR(255)	NOT NULL	DEFAULT 'N',
                                    `leader_id`	INT	NOT NULL,
                                    CONSTRAINT fk_tbl_team_recruit_to_tbl_user FOREIGN KEY (leader_id) REFERENCES tbl_user (user_id)
);

-- 팀 모집 30개 더미 데이터 삽입
INSERT INTO tbl_team_recruit (post_title, team_name, team_introduce, leader_id, is_deleted, is_completed, created_at)
VALUES
    ('프론트엔드 개발팀 모집', 'React 개발팀', 'React.js를 이용한 웹 어플리케이션 개발 경험이 있는 팀원 모집', 1, 'N', 'N', '2024-02-01 10:00:00'),
    ('백엔드 개발팀 모집', 'Java Spring 팀', 'Java Spring 프레임워크를 사용하는 백엔드 개발팀 모집', 2, 'N', 'N', '2024-02-10 15:30:00'),
    ('모바일 앱 개발팀 모집', 'iOS 개발팀', 'Swift와 iOS 개발 경험이 있는 팀원을 모집합니다.', 3, 'N', 'N', '2024-02-12 11:45:00'),
    ('데이터 분석팀 모집', '데이터 분석팀', 'Python과 데이터 분석 툴을 활용한 분석팀 모집', 4, 'N', 'N', '2024-02-15 13:00:00'),
    ('게임 개발팀 모집', 'Unity 게임팀', 'Unity로 게임을 개발할 팀원 모집', 5, 'N', 'N', '2024-02-18 09:20:00'),
    ('DevOps 팀 모집', '클라우드 인프라 팀', 'AWS, Docker, Kubernetes 등을 다룰 DevOps 팀 모집', 6, 'N', 'Y', '2024-02-21 16:30:00'),
    ('풀스택 개발팀 모집', '풀스택 개발팀', '프론트엔드와 백엔드 모두 다룰 수 있는 팀원 모집', 7, 'N', 'Y', '2024-02-25 14:15:00'),
    ('게임 기획팀 모집', '게임 기획 팀', '게임 디자인 및 기획에 참여할 팀원 모집', 8, 'N', 'N', '2024-02-28 12:05:00'),
    ('서버 개발팀 모집', 'Node.js 서버팀', 'Node.js와 Express.js를 이용한 서버 개발 팀원 모집', 9, 'N', 'N', '2024-03-02 10:40:00'),
    ('웹 디자인팀 모집', 'UI/UX 디자인 팀', '웹 디자인과 UX/UI를 담당할 디자이너 모집', 10, 'N', 'N', '2024-03-05 09:00:00'),
    ('프론트엔드 개발팀 모집', 'Vue.js 개발팀', 'Vue.js를 이용한 프론트엔드 개발팀 모집', 11, 'N', 'N', '2024-03-07 14:20:00'),
    ('백엔드 개발팀 모집', 'Go 언어 백엔드팀', 'Go 언어로 백엔드를 개발할 팀원 모집', 12, 'N', 'N', '2024-03-10 08:30:00'),
    ('웹 개발팀 모집', 'PHP 개발팀', 'PHP 기반의 웹 서비스를 개발할 팀원 모집', 13, 'N', 'N', '2024-03-12 17:40:00'),
    ('모바일 개발팀 모집', 'Android 개발팀', 'Android 앱 개발을 담당할 팀원 모집', 14, 'N', 'N', '2024-03-14 11:55:00'),
    ('AI 개발팀 모집', 'AI 프로젝트 팀', 'AI 모델 개발과 데이터 전처리를 담당할 팀원 모집', 15, 'N', 'N', '2024-03-16 10:25:00'),
    ('프론트엔드 개발팀 모집', 'Angular 개발팀', 'Angular를 이용한 웹 애플리케이션 개발팀 모집', 16, 'N', 'N', '2024-03-18 14:00:00'),
    ('백엔드 개발팀 모집', 'Django 백엔드팀', 'Python Django를 사용하여 백엔드 개발을 담당할 팀원 모집', 17, 'N', 'N', '2024-03-20 15:15:00'),
    ('UI/UX 디자인팀 모집', '디자인 혁신 팀', '혁신적인 UX/UI 디자인을 만들 팀원 모집', 18, 'N', 'N', '2024-03-22 09:30:00'),
    ('풀스택 개발팀 모집', 'MERN 개발팀', 'MongoDB, Express, React, Node.js로 풀스택 개발할 팀원 모집', 19, 'N', 'N', '2024-03-24 16:10:00'),
    ('게임 개발팀 모집', 'Unreal Engine 팀', 'Unreal Engine을 활용한 게임 개발 팀원 모집', 20, 'N', 'N', '2024-03-26 12:45:00'),
    ('웹 애플리케이션 개발팀 모집', 'React Native 팀', 'React Native로 모바일 애플리케이션 개발할 팀원 모집', 21, 'N', 'N', '2024-03-28 13:50:00'),
    ('DevOps 팀 모집', 'GitOps 팀', 'GitOps 기반의 클라우드 인프라 팀 모집', 22, 'N', 'N', '2024-03-30 17:05:00'),
    ('모바일 앱 개발팀 모집', 'Flutter 개발팀', 'Flutter로 크로스 플랫폼 모바일 앱을 개발할 팀원 모집', 23, 'N', 'N', '2024-04-01 14:15:00'),
    ('백엔드 개발팀 모집', 'Ruby on Rails 팀', 'Ruby on Rails를 사용하여 웹 애플리케이션 개발할 팀원 모집', 24, 'N', 'N', '2024-04-03 16:00:00'),
    ('풀스택 개발팀 모집', 'Python 팀', 'Python과 JavaScript로 풀스택 개발할 팀원 모집', 25, 'N', 'N', '2024-04-05 10:30:00'),
    ('게임 개발팀 모집', 'C++ 게임팀', 'C++를 이용하여 게임을 개발할 팀원 모집', 26, 'N', 'N', '2024-04-07 12:25:00'),
    ('백엔드 개발팀 모집', 'Flask 팀', 'Flask를 이용한 웹 백엔드 개발 팀원 모집', 27, 'N', 'N', '2024-04-09 08:40:00'),
    ('프론트엔드 개발팀 모집', 'Svelte 개발팀', 'Svelte로 웹 프론트엔드를 개발할 팀원 모집', 28, 'N', 'N', '2024-04-11 11:10:00'),
    ('모바일 개발팀 모집', 'React Native 팀', 'React Native로 모바일 앱을 개발할 팀원 모집', 29, 'N', 'N', '2024-04-13 09:55:00'),
    ('AI 개발팀 모집', '머신러닝 팀', 'AI와 머신러닝 관련 프로젝트 팀원 모집', 30, 'N', 'N', '2024-04-15 14:45:00');

##################################################### tbl_team_recruit

CREATE TABLE `tbl_applicant` (
                                 `team_post_id`	INT	NOT NULL,
                                 `user_id`	INT	NOT NULL,
                                 `introduce`	VARCHAR(255)	NOT NULL,
                                 `is_processed`	VARCHAR(255)
);
ALTER TABLE `tbl_applicant` ADD CONSTRAINT `FK_tbl_team_recruit_TO_tbl_applicant_1` FOREIGN KEY (
                                                                                                 `team_post_id`
    )
    REFERENCES `tbl_team_recruit` (
                                   `team_post_id`
        );

ALTER TABLE `tbl_applicant` ADD CONSTRAINT `FK_tbl_user_TO_tbl_applicant_1` FOREIGN KEY (
                                                                                         `user_id`
    )
    REFERENCES `tbl_user` (
                           `user_id`
        );

INSERT INTO tbl_applicant (team_post_id, user_id, introduce, is_processed)
VALUES
    -- 팀 1: 3명
    (1, 20, 'I am excited to join Alpha Tech.', 'N'),
    (1, 21, 'I have relevant experience in AI.', 'N'),
    (1, 22, 'Looking forward to contributing to Alpha Tech.', 'N'),

    -- 팀 2: 2명
    (2, 23, 'Passionate about sustainable energy.', 'N'),
    (2, 24, 'My skills in innovation will be valuable.', 'N'),

    -- 팀 3: 4명
    (3, 25, 'Experienced in software development.', 'N'),
    (3, 26, 'Excited to improve workflow at Gamma Solutions.', 'N'),
    (3, 27, 'I bring leadership experience.', 'N'),
    (3, 28, 'Ready to tackle process innovations.', 'N'),

    -- 팀 4: 2명
    (4, 29, 'Interested in digital transformation projects.', 'N'),
    (4, 30, 'Agile expert looking for new challenges.', 'N'),

    -- 팀 5: 5명
    (5, 31, 'Financial and technical background.', 'N'),
    (5, 32, 'I can help in market research.', 'N'),
    (5, 33, 'Skilled in consulting and technology.', 'N'),
    (5, 34, 'Innovative thinker ready for challenges.', 'N'),
    (5, 35, 'I have experience in cross-functional teams.', 'N'),

    -- 팀 6: 3명
    (6, 36, 'Creative designer with strong marketing skills.', 'Y'),
    (6, 37, 'Experience in creative campaigns.', 'Y'),
    (6, 38, 'Passionate about innovative design.', 'Y'),

    -- 팀 7: 4명
    (7, 39, 'Proficient in various programming languages.', 'Y'),
    (7, 40, 'Strong developer with team spirit.', 'Y'),
    (7, 41, 'I have several years of industry experience.', 'Y'),
    (7, 42, 'Looking to contribute to cutting-edge projects.', 'Y'),

    -- 팀 8: 3명
    (8, 43, 'Expert in data analytics and visualization.', 'N'),
    (8, 44, 'I bring insights from big data.', 'N'),
    (8, 45, 'Experienced in statistical analysis.', 'N'),

    -- 팀 9: 2명
    (9, 46, 'I am innovative and creative.', 'N'),
    (9, 47, 'My background in research suits the role.', 'N'),

    -- 팀 10: 5명
    (10, 48, 'Customer-focused and experienced in solutions.', 'N'),
    (10, 49, 'I can manage projects effectively.', 'N'),
    (10, 50, 'Eager to drive new initiatives.', 'N'),
    (10, 20, 'I bring a diverse skill set to Kappa Solutions.', 'N'),
    (10, 21, 'Excited to collaborate with industry experts.', 'N');

######################################################################## tbl_applicant

CREATE TABLE `tbl_mentoring` (
                                 `mentor_id`	INT	NOT NULL,
                                 `mentee_id`	INT	NULL,
                                 `team_id`	INT	NULL,
                                 `is_accepted`	VARCHAR(255)	NOT NULL
);
ALTER TABLE `tbl_mentoring` ADD CONSTRAINT `PK_TBL_MENTORING` PRIMARY KEY (
                                                                           `mentor_id`,
                                                                           `mentee_id`,
                                                                           `team_id`
    );

INSERT INTO tbl_mentoring (mentor_id, mentee_id, team_id, is_accepted)
VALUES
    -- 개별 멘토링 신청: mentee_id 채워지고 team_id는 NULL
    (1, 20, 0, 'Y'),  -- 멘토 1이 회원 20번과 멘토링 (승인됨)
    (2, 21, 0, 'Y'),  -- 멘토 2가 회원 21번과 멘토링 (승인됨)
    (3, 22, 0, 'N'),  -- 멘토 3이 회원 22번과 멘토링 (미승인)

    -- 팀 멘토링 신청: team_id 채워지고 mentee_id는 NULL
    (4, 0, 1, 'Y'),   -- 멘토 4가 팀 모집 게시글 번호 1번(팀 1)을 대상으로 멘토링 (승인됨)
    (5, 0, 2, 'N');   -- 멘토 5가 팀 모집 게시글 번호 2번(팀 2)을 대상으로 멘토링 (미승인)

###################################################### tbl_mentoring

CREATE TABLE `tbl_rating_and_review` (
                                         `mentor_id` INT NOT NULL,
                                         `mentee_id` INT NOT NULL,
                                         `mentoring_space_id` INT NOT NULL,
                                         `star` INT NOT NULL,
                                         `review` TEXT,
                                         `created_at` DATETIME NOT NULL DEFAULT NOW(),
                                         PRIMARY KEY (`mentor_id`, `mentee_id`, `mentoring_space_id`),
                                         CONSTRAINT `FK_Rating_Mentor` FOREIGN KEY (`mentor_id`) REFERENCES `tbl_mentor_list`(`mentor_id`),
                                         CONSTRAINT `FK_Rating_Mentee` FOREIGN KEY (`mentee_id`) REFERENCES `tbl_user`(`user_id`),
                                         CONSTRAINT `FK_Rating_MentoringSpace` FOREIGN KEY (`mentoring_space_id`) REFERENCES `tbl_mentoring_space`(`mentoring_space_id`)
) ENGINE=InnoDB;

INSERT INTO `tbl_rating_and_review` (`mentor_id`, `mentee_id`, `mentoring_space_id`, `star`, `created_at`)
VALUES
    (1, 23, 1, 5, NOW()),
    (2, 45, 2, 4, NOW()),
    (3, 12, 3, 3, NOW()),
    (4, 34, 4, 5, NOW()),
    (5, 50, 5, 4, NOW()),
    (1, 8, 6, 5, NOW()),
    (2, 19, 7, 3, NOW()),
    (3, 3, 8, 4, NOW()),
    (4, 29, 9, 5, NOW()),
    (5, 41, 10, 4, NOW()),
    (1, 25, 11, 5, NOW()),
    (2, 9, 12, 3, NOW()),
    (3, 22, 13, 4, NOW()),
    (4, 17, 14, 5, NOW()),
    (5, 38, 15, 4, NOW()),
    (1, 7, 16, 5, NOW()),
    (2, 33, 17, 3, NOW()),
    (3, 16, 18, 4, NOW()),
    (4, 13, 19, 5, NOW()),
    (5, 5, 20, 4, NOW());



########################################## tbl_rating_and_review

CREATE TABLE `tbl_question` (
                                `question_id` INT NOT NULL AUTO_INCREMENT COMMENT 'AUTO_INCREMENT',
                                `question_content` VARCHAR(255) NOT NULL,
                                `question_created_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                `is_deleted` VARCHAR(255) NOT NULL DEFAULT 'N',
                                `member_id` INT NOT NULL,
                                `mentoring_space_id` INT NOT NULL,
                                PRIMARY KEY (`question_id`)
) ENGINE=InnoDB;

ALTER TABLE `tbl_question`
    ADD CONSTRAINT `FK_tbl_question_member` FOREIGN KEY (`member_id`) REFERENCES `tbl_user`(`user_id`);

ALTER TABLE `tbl_question`
    ADD CONSTRAINT `FK_tbl_question_mentoring_space` FOREIGN KEY (`mentoring_space_id`) REFERENCES `tbl_mentoring_space`(`mentoring_space_id`);

## 질문
INSERT INTO tbl_question (question_content, question_created_time, member_id, mentoring_space_id)
VALUES
    ('SQL에서 JOIN의 종류는 무엇인가요?', NOW(), 6, 1),
    ('InnoDB와 MyISAM의 차이는 무엇인가요?', NOW(), 7, 1),
    ('인덱스 최적화 방법에 대해 알고 싶습니다.', NOW(), 8, 2),
    ('트랜잭션이란 무엇이며, 언제 사용해야 하나요?', NOW(), 9, 2),
    ('데이터베이스 정규화 과정에 대해 설명해주세요.', NOW(), 10, 3),
    ('외래키(FK)의 역할은 무엇인가요?', NOW(), 11, 3),
    ('ACID 특성이란 무엇인가요?', NOW(), 12, 1),
    ('SQL Injection 방지 방법은 무엇인가요?', NOW(), 13, 2),
    ('데이터베이스 성능 최적화 팁이 있나요?', NOW(), 14, 3),
    ('NoSQL과 관계형 데이터베이스의 차이에 대해 알고 싶습니다.', NOW(), 15, 1);

## 답변
CREATE TABLE `tbl_answer` (
                              `answer_id` INT NOT NULL AUTO_INCREMENT COMMENT 'AUTO_INCREMENT',
                              `answer_content` VARCHAR(255) NOT NULL,
                              `answer_created_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                              is_deleted VARCHAR(255) NOT NULL DEFAULT 'N',
                              `question_id` INT NULL,
                              `answer_member_id` INT NOT NULL,
                              `ref_answer_id` INT NULL,
                              `mentoring_space_id` INT NOT NULL,
                              PRIMARY KEY (`answer_id`),
                              CONSTRAINT `FK_tbl_answer_question` FOREIGN KEY (`question_id`) REFERENCES `tbl_question`(`question_id`),
                              CONSTRAINT `FK_tbl_answer_user` FOREIGN KEY (`answer_member_id`) REFERENCES `tbl_user`(`user_id`),
                              CONSTRAINT `FK_tbl_answer_ref_answer` FOREIGN KEY (`ref_answer_id`) REFERENCES `tbl_answer`(`answer_id`),
                              CONSTRAINT `FK_tbl_answer_mentoring_space` FOREIGN KEY (`mentoring_space_id`) REFERENCES `tbl_mentoring_space`(`mentoring_space_id`)
) ENGINE=InnoDB;

## 답변 데이터
INSERT INTO tbl_answer (answer_content, question_id, answer_member_id, ref_answer_id, mentoring_space_id)
VALUES
    -- 첫 번째 답변: 질문 1에 대한 기본 답변, 답글 없음.
    ('이 질문에 대한 제 답변입니다.', 1, 6, NULL, 1),

    -- 두 번째 답변: 질문 1에 대한 추가 의견, 첫 번째 답변을 참조(답글)
    ('추가 의견을 덧붙입니다.', 1, 7, 1, 1),

    -- 세 번째 답변: 질문 2에 대한 답변, 답글 없음.
    ('해당 질문에 대한 제 생각을 공유합니다.', 2, 8, NULL, 2),

    -- 네 번째 답변: 질문 3에 대한 답변, 답글 없음.
    ('관련 경험을 바탕으로 답변드립니다.', 3, 9, NULL, 3),

    -- 다섯 번째 답변: 질문 2에 대한 보충 설명, 세 번째 답변을 참조(답글)
    ('이전 답변에 대한 보충 설명입니다.', 2, 10, 3, 2);

############################################# tbl_question / tbl_answer

CREATE TABLE `tbl_mentoring_file` (
                                      `file_id`	INT	NOT NULL PRIMARY KEY AUTO_INCREMENT,
                                      `file_path`	VARCHAR(255)	NOT NULL,
                                      original_file_name VARCHAR(255) NOT NULL,
                                      stored_file_name VARCHAR(255) NOT NULL,
                                      `question_id`	INT	NULL,
                                      `answer_id`	INT	NULL,
                                      CONSTRAINT fk_tbl_mentoring_file_to_tbl_question FOREIGN KEY (question_id) REFERENCES tbl_question(question_id),
                                      CONSTRAINT fk_tbl_mentoring_file_to_tbl_answer FOREIGN KEY (answer_id) REFERENCES tbl_answer(answer_id)
);

INSERT INTO `tbl_mentoring_file` (`file_path`, `original_file_name`,stored_file_name, `question_id`, `answer_id`)
VALUES
    ('/uploads/q1_file1.pdf', 'q1_회로정리.pdf', 'uuid_q1_1.pdf', 1, NULL),
    ('/uploads/q1_file2.pdf', 'q1_참고자료.pdf', 'uuid_q1_2.pdf', 1, NULL),
    ('/uploads/q2_file1.docx', 'q2_정리문서.docx', 'uuid_q2_1.docx', 2, NULL),
    ('/uploads/q3_file1.png', 'q3_다이어그램.png', 'uuid_q3_1.png', 3, NULL),
    ('/uploads/q4_file1.xlsx', 'q4_데이터분석.xlsx', 'uuid_q4_1.xlsx', 4, NULL),
    ('/uploads/q5_file1.pptx', 'q5_발표자료.pptx', 'uuid_q5_1.pptx', 5, NULL),
    ('/uploads/a1_file1.pdf', 'a1_응답정리.pdf', 'uuid_a1_1.pdf', NULL, 1),
    ('/uploads/a2_file1.png', 'a2_캡처.png', 'uuid_a2_1.png', NULL, 2),
    ('/uploads/a3_file1.txt', 'a3_텍스트정리.txt', 'uuid_a3_1.txt', NULL, 3),
    ('/uploads/a4_file1.docx', 'a4_자료정리.docx', 'uuid_a4_1.docx', NULL, 4),
    ('/uploads/a5_file1.pdf', 'a5_리뷰자료.pdf', 'uuid_a5_1.pdf', NULL, 5),
    ('/uploads/q6_file1.pdf', 'q6_추가내용.pdf', 'uuid_q6_1.pdf', 6, NULL),
    ('/uploads/q7_file1.md', 'q7_마크다운정리.md', 'uuid_q7_1.md', 7, NULL),
    ('/uploads/q8_file1.csv', 'q8_데이터.csv', 'uuid_q8_1.csv', 8, NULL),
    ('/uploads/q9_file1.json', 'q9_API응답.json', 'uuid_q9_1.json', 9, NULL),
    ('/uploads/q10_file1.zip', 'q10_소스코드.zip', 'uuid_q10_1.zip', 10, NULL),
    ('/uploads/a1_file2.pdf', 'a1_보충자료.pdf', 'uuid_a1_2.pdf', NULL, 1),
    ('/uploads/a2_file2.docx', 'a2_해설.docx', 'uuid_a2_2.docx', NULL, 2),
    ('/uploads/a3_file2.png', 'a3_차트.png', 'uuid_a3_2.png', NULL, 3),
    ('/uploads/a4_file2.xlsx', 'a4_비교분석.xlsx', 'uuid_a4_2.xlsx', NULL, 4),
    ('/uploads/q1a1_combined.zip', 'q1a1_통합파일.zip', 'uuid_combined_q1a1.zip', 1, 1),
    ('/uploads/q2a2_combined.zip', 'q2a2_통합자료.zip', 'uuid_combined_q2a2.zip', 2, 2),
    ('/uploads/q3a3_combined.zip', 'q3a3_정리.zip', 'uuid_combined_q3a3.zip', 3, 3),
    ('/uploads/q4a4_combined.zip', 'q4a4_분석자료.zip', 'uuid_combined_q4a4.zip', 4, 4),
    ('/uploads/q5a5_combined.zip', 'q5a5_정리자료.zip', 'uuid_combined_q5a5.zip', 5, 5),
    ('/uploads/q6_file2.pdf', 'q6_참고링크.pdf', 'uuid_q6_2.pdf', 6, NULL),
    ('/uploads/q7_file2.txt', 'q7_노트.txt', 'uuid_q7_2.txt', 7, NULL),
    ('/uploads/q8_file2.docx', 'q8_설명자료.docx', 'uuid_q8_2.docx', 8, NULL),
    ('/uploads/q9_file2.png', 'q9_시각화.png', 'uuid_q9_2.png', 9, NULL),
    ('/uploads/q10_file2.pdf', 'q10_최종정리.pdf', 'uuid_q10_2.pdf', 10, NULL);

################################################# tbl_mentoring_file

CREATE TABLE `tbl_board_file` (
                                  `file_id`	INT	NOT NULL PRIMARY KEY AUTO_INCREMENT,
                                  `address`	VARCHAR(255)	NOT NULL,
                                  `board_id`	INT	NOT NULL,
                                  CONSTRAINT fk_tbl_board_file_to_tbl_board FOREIGN KEY (board_id) REFERENCES tbl_board(post_id)
);

-- 30개의 더미 파일 데이터 삽입
INSERT INTO tbl_board_file (address, board_id)
VALUES
    ('file_path_1.pdf', 5),
    ('file_path_2.jpg', 3),
    ('file_path_3.png', 8),
    ('file_path_4.zip', 10),
    ('file_path_5.docx', 12),
    ('file_path_6.pdf', 1),
    ('file_path_7.mp4', 15),
    ('file_path_8.zip', 19),
    ('file_path_9.png', 7),
    ('file_path_10.docx', 14),
    ('file_path_11.pdf', 17),
    ('file_path_12.jpg', 22),
    ('file_path_13.zip', 9),
    ('file_path_14.docx', 25),
    ('file_path_15.pdf', 2),
    ('file_path_16.png', 6),
    ('file_path_17.zip', 4),
    ('file_path_18.mp4', 13),
    ('file_path_19.jpg', 30),
    ('file_path_20.zip', 11),
    ('file_path_21.pdf', 20),
    ('file_path_22.docx', 18),
    ('file_path_23.png', 29),
    ('file_path_24.mp4', 26),
    ('file_path_25.zip', 16),
    ('file_path_26.jpg', 28),
    ('file_path_27.pdf', 31),
    ('file_path_28.docx', 23),
    ('file_path_29.zip', 32),
    ('file_path_30.mp4', 24);

################################################## tbl_board_file
