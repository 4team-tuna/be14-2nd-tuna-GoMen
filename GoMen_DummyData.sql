CREATE TABLE `tbl_user` (
                            `user_id`	INT	PRIMARY KEY NOT NULL AUTO_INCREMENT,
                            `login_id`	VARCHAR(255)	NOT NULL,
                            `password`	VARCHAR(255)	NOT NULL,
                            `name`	VARCHAR(255)	NOT NULL,
                            `personal_number`	VARCHAR(255)	NOT NULL,
                            `phone_number`	VARCHAR(255)	NOT NULL,
                            `nickname`	VARCHAR(255)	NOT NULL,
                            `created_at`	DATETIME	NOT NULL	DEFAULT NOW(),
                            `updated_at`	DATETIME	NULL,
                            `will_be_activated`	DATETIME	NOT NULL	DEFAULT NOW(),
                            `is_quitted`	VARCHAR(255)	NOT NULL	DEFAULT 'N',
                            `깃허브주소`	VARCHAR(255)	NULL,
                            `extension_count`	INT	NOT NULL	DEFAULT 0,
                            `career_info`	VARCHAR(255)	NULL,
                            `is_mentor`	VARCHAR(255)	NOT NULL	DEFAULT 'N',
                            `violation_score`	INT	NOT NULL	DEFAULT 0
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
  WHERE user_id in (1,2,3,4,5);

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


# 회원 테이블 생성 완료

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

# 칭호 테이블 생성 완료

CREATE TABLE `tbl_mail` (
                            `mail_id`	INT	NOT NULL PRIMARY KEY 	AUTO_INCREMENT,
                            `sender_id`	INT	NOT NULL,
                            `receiver_id`	INT	NOT NULL,
                            `content`	VARCHAR(255)	NOT NULL
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

# 쪽지 테이블 생성 완료

CREATE TABLE `tbl_board` (
                             `post_id`	INT	NOT NULL PRIMARY KEY	AUTO_INCREMENT,
                             `category`	INT	NOT NULL,
                             `title`	VARCHAR(255)	NOT NULL,
                             `content`	VARCHAR(255)	NOT NULL,
                             `created_at`	DATETIME	NOT NULL,
                             `modified_at`	DATETIME	NOT NULL,
                             `is_blinded`	VARCHAR(255)	NOT NULL	DEFAULT 'N',
                             `user_id`	INT	NOT NULL,
                             CONSTRAINT fk_tbl_board_to_tbl_user FOREIGN KEY (user_id) REFERENCES tbl_user(user_id)
);

INSERT INTO `tbl_board` (
                             `category`
                            , `title`
                            , `content`
                            , `created_at`
                            , `modified_at`
                            , `is_blinded`
                            , `user_id`
)
VALUES
    (1, '새로운 알고리즘 최적화 기법', '최근 알고리즘 최적화 관련하여 유용한 기법을 발견했습니다. 관심 있는 분들은 참고해 보세요.', '2025-03-01 10:15:00', '2025-03-01 10:15:00', 'N', 1),
    (2, 'React Hooks vs. 클래스 컴포넌트', 'React Hooks와 클래스 컴포넌트의 차이점과 성능 비교에 대해 다뤄보겠습니다.', '2025-03-02 14:20:00', '2025-03-02 14:20:00', 'N', 5),
    (3, 'Python으로 웹 크롤러 만들기', 'Python을 이용해 간단한 웹 크롤러를 만들어보겠습니다. 자세한 코드와 설명을 추가했습니다.', '2025-03-03 16:45:00', '2025-03-03 16:45:00', 'N', 8),
    (1, 'Git 브랜치 전략', '팀 프로젝트에서 Git 브랜치 전략을 어떻게 관리할지에 대한 고민을 공유합니다. 다양한 전략을 비교해 보세요.', '2025-03-04 11:00:00', '2025-03-04 11:00:00', 'N', 2),
    (2, 'TypeScript 도입 후기', 'TypeScript를 도입한 이후 느낀 장단점과 실무에서 사용한 경험을 공유합니다.', '2025-03-05 09:30:00', '2025-03-05 09:30:00', 'N', 10),
    (3, 'AI 학습을 위한 데이터 전처리 방법', 'AI 모델 학습 전 필수적인 데이터 전처리 방법에 대해 정리해봤습니다. 유용한 자료가 될 것입니다.', '2025-03-06 13:40:00', '2025-03-06 13:40:00', 'N', 12),
    (1, 'Docker를 활용한 개발 환경 구축', 'Docker를 활용하여 개발 환경을 쉽게 구축하는 방법을 설명합니다. 여러 개발 환경에서의 활용 예시도 포함하였습니다.', '2025-03-07 15:10:00', '2025-03-07 15:10:00', 'N', 6),
    (2, 'Vue.js 컴포넌트 설계 패턴', 'Vue.js의 효율적인 컴포넌트 설계 패턴을 공유합니다. 재사용 가능한 코드 작성법에 대해 논의해 보세요.', '2025-03-08 12:25:00', '2025-03-08 12:25:00', 'N', 3),
    (3, '서버 성능 최적화 기법', '서버 성능을 최적화하는 다양한 기법에 대해 설명합니다. 실제로 적용했던 방법을 공유합니다.', '2025-03-09 17:00:00', '2025-03-09 17:00:00', 'N', 7),
    (1, 'Jest로 단위 테스트 작성하기', 'Jest를 이용한 단위 테스트 작성 방법과 이를 실무에서 어떻게 적용하는지에 대한 경험을 공유합니다.', '2025-03-10 10:55:00', '2025-03-10 10:55:00', 'N', 4),
    (2, 'JavaScript 비동기 처리 방법', 'JavaScript의 비동기 처리 방법에 대해 이야기합니다. Promise, async/await 등을 활용한 예시도 제공합니다.', '2025-03-11 13:00:00', '2025-03-11 13:00:00', 'N', 9),
    (3, 'Spring Boot로 REST API 만들기', 'Spring Boot를 이용해 REST API를 만드는 과정과 필수적인 설정들에 대해 설명합니다.', '2025-03-12 14:30:00', '2025-03-12 14:30:00', 'N', 11),
    (1, 'Redis 캐시 서버 사용법', 'Redis를 활용한 캐시 서버 설정과 성능 개선 방법에 대해 다룹니다. 실무에서 유용한 팁을 소개합니다.', '2025-03-13 16:00:00', '2025-03-13 16:00:00', 'N', 2),
    (2, 'CI/CD 파이프라인 구축', 'CI/CD 파이프라인을 구축하는 과정과 이를 통한 자동화 작업에 대해 소개합니다.', '2025-03-14 11:20:00', '2025-03-14 11:20:00', 'N', 6),
    (3, 'Database 인덱스 최적화', '데이터베이스 인덱스를 최적화하여 성능을 개선하는 방법에 대해 설명합니다.', '2025-03-15 18:35:00', '2025-03-15 18:35:00', 'N', 5),
    (1, 'GraphQL과 REST API 비교', 'GraphQL과 REST API의 차이점과 각 기술을 사용할 때의 장단점에 대해 다룹니다.', '2025-03-16 08:50:00', '2025-03-16 08:50:00', 'N', 3),
    (2, 'Angular 성능 최적화 팁', 'Angular 프레임워크의 성능을 최적화하는 여러 방법들을 소개합니다. 큰 프로젝트에서 유용하게 쓸 수 있는 팁들입니다.', '2025-03-17 12:10:00', '2025-03-17 12:10:00', 'N', 8),
    (3, 'UI/UX 디자인 개선 방법', 'UI/UX 디자인을 개선하여 사용자 경험을 향상시키는 다양한 방법을 소개합니다.', '2025-03-18 14:00:00', '2025-03-18 14:00:00', 'N', 4),
    (1, 'Kubernetes로 서비스 배포하기', 'Kubernetes를 활용해 서비스 배포 및 관리하는 방법을 다룹니다. 실제 환경에서의 활용 예시도 포함되었습니다.', '2025-03-19 17:25:00', '2025-03-19 17:25:00', 'N', 7),
    (2, 'Flutter로 모바일 앱 개발', 'Flutter로 모바일 앱을 개발하는 방법과 실제 구현 예제를 소개합니다.', '2025-03-20 09:40:00', '2025-03-20 09:40:00', 'N', 10),
    (3, 'CSS Grid 레이아웃', 'CSS Grid 레이아웃을 사용하여 복잡한 레이아웃을 효율적으로 구성하는 방법을 설명합니다.', '2025-03-21 11:30:00', '2025-03-21 11:30:00', 'N', 6),
    (1, 'WebSocket을 이용한 실시간 애플리케이션', 'WebSocket을 활용하여 실시간 애플리케이션을 구축하는 방법을 설명합니다.', '2025-03-22 13:50:00', '2025-03-22 13:50:00', 'N', 3),
    (2, 'RESTful API 설계 팁', 'RESTful API 설계 시 고려해야 할 주요 사항들과 실무에서 자주 발생하는 문제를 다룹니다.', '2025-03-23 16:15:00', '2025-03-23 16:15:00', 'N', 12),
    (3, 'JavaScript 성능 최적화', 'JavaScript 코드 성능을 최적화하는 방법들에 대해 설명합니다. 브라우저 성능을 최적화하는 팁들도 포함되었습니다.', '2025-03-24 10:00:00', '2025-03-24 10:00:00', 'N', 9),
    (1, 'AI 모델 평가 기준', 'AI 모델의 성능을 평가하는 기준에 대해 다룹니다. 다양한 평가 지표와 적용 예시를 제공합니다.', '2025-03-25 12:45:00', '2025-03-25 12:45:00', 'N', 5),
    (2, 'MERN 스택으로 웹 앱 만들기', 'MERN 스택을 사용하여 웹 애플리케이션을 개발하는 방법을 설명합니다.', '2025-03-26 14:30:00', '2025-03-26 14:30:00', 'N', 7),
    (3, 'MongoDB 성능 최적화', 'MongoDB에서 성능을 최적화하는 다양한 방법에 대해 설명합니다.', '2025-03-27 09:20:00', '2025-03-27 09:20:00', 'N', 2),
    (1, 'Java와 Kotlin의 차이점', 'Java와 Kotlin의 주요 차이점에 대해 설명하며, 각 언어를 사용하는데 있어서의 장단점을 비교합니다.', '2025-03-28 13:00:00', '2025-03-28 13:00:00', 'N', 8),
    (2, '서버리스 아키텍처 활용 사례', '서버리스 아키텍처를 활용한 다양한 사례를 소개하며, 실제 적용 예시를 제공합니다.', '2025-03-29 15:30:00', '2025-03-29 15:30:00', 'N', 11),
    (3, '자주 묻는 코드 최적화 질문', '코드를 최적화하는데 자주 묻는 질문들과 그에 대한 해결책을 공유합니다.', '2025-03-30 16:45:00', '2025-03-30 16:45:00', 'N', 6),
    (1, '파이썬으로 웹 크롤링하는 방법', '파이썬을 이용해 웹 크롤링을 하는 다양한 방법을 설명합니다.', NOW() - INTERVAL FLOOR(RAND() * 365) DAY, NOW() - INTERVAL FLOOR(RAND() * 365) DAY, 'N', 5),
    (2, '자바스크립트 비동기 처리', '자바스크립트에서 비동기 처리를 이해하는 데 필요한 팁과 예시 코드.', NOW() - INTERVAL FLOOR(RAND() * 365) DAY, NOW() - INTERVAL FLOOR(RAND() * 365) DAY, 'N', 12),
    (3, 'MySQL 성능 최적화 팁', 'MySQL에서 성능을 최적화하는 다양한 방법과 실전 예시를 공유합니다.', NOW() - INTERVAL FLOOR(RAND() * 365) DAY, NOW() - INTERVAL FLOOR(RAND() * 365) DAY, 'N', 23),
    (1, 'React 기본 사용법', 'React의 기본 사용법과 주요 개념을 소개합니다.', NOW() - INTERVAL FLOOR(RAND() * 365) DAY, NOW() - INTERVAL FLOOR(RAND() * 365) DAY, 'N', 31),
    (4, 'Docker로 개발 환경 설정하기', 'Docker를 이용해 개발 환경을 설정하는 과정과 팁을 공유합니다.', NOW() - INTERVAL FLOOR(RAND() * 365) DAY, NOW() - INTERVAL FLOOR(RAND() * 365) DAY, 'N', 16),
    (5, 'iOS 앱 개발 시작하기', 'iOS 앱 개발을 처음 시작하는 분들을 위한 가이드입니다.', NOW() - INTERVAL FLOOR(RAND() * 365) DAY, NOW() - INTERVAL FLOOR(RAND() * 365) DAY, 'N', 7),
    (2, 'Node.js로 RESTful API 만들기', 'Node.js와 Express를 이용해 RESTful API를 만드는 방법.', NOW() - INTERVAL FLOOR(RAND() * 365) DAY, NOW() - INTERVAL FLOOR(RAND() * 365) DAY, 'N', 19),
    (3, '배치 작업 자동화하는 방법', '서버에서 배치 작업을 자동화하는 방법과 유용한 도구들을 소개합니다.', NOW() - INTERVAL FLOOR(RAND() * 365) DAY, NOW() - INTERVAL FLOOR(RAND() * 365) DAY, 'N', 24),
    (4, 'CI/CD 구축 방법', 'CI/CD 파이프라인을 구축하여 효율적인 개발을 실현하는 방법.', NOW() - INTERVAL FLOOR(RAND() * 365) DAY, NOW() - INTERVAL FLOOR(RAND() * 365) DAY, 'N', 2),
    (1, 'Python으로 데이터 분석 시작하기', 'Python을 활용한 데이터 분석 기초와 주요 라이브러리 소개.', NOW() - INTERVAL FLOOR(RAND() * 365) DAY, NOW() - INTERVAL FLOOR(RAND() * 365) DAY, 'N', 25),
    (2, 'Vue.js로 SPA 개발하기', 'Vue.js로 Single Page Application을 개발하는 방법을 알아봅니다.', NOW() - INTERVAL FLOOR(RAND() * 365) DAY, NOW() - INTERVAL FLOOR(RAND() * 365) DAY, 'N', 11),
    (3, 'Redis 성능 튜닝 방법', 'Redis의 성능을 향상시키는 방법과 유용한 팁들.', NOW() - INTERVAL FLOOR(RAND() * 365) DAY, NOW() - INTERVAL FLOOR(RAND() * 365) DAY, 'N', 9),
    (5, 'Android 앱에서 데이터베이스 활용하기', 'Android 앱에서 SQLite를 활용하여 데이터를 처리하는 방법.', NOW() - INTERVAL FLOOR(RAND() * 365) DAY, NOW() - INTERVAL FLOOR(RAND() * 365) DAY, 'N', 17),
    (4, 'Git으로 협업하기', 'Git을 활용한 협업 작업을 효율적으로 진행하는 방법.', NOW() - INTERVAL FLOOR(RAND() * 365) DAY, NOW() - INTERVAL FLOOR(RAND() * 365) DAY, 'N', 18),
    (1, 'Django로 웹 애플리케이션 만들기', 'Django를 사용해 웹 애플리케이션을 만드는 방법과 주요 기능들.', NOW() - INTERVAL FLOOR(RAND() * 365) DAY, NOW() - INTERVAL FLOOR(RAND() * 365) DAY, 'N', 4),
    (3, 'PostgreSQL에서 인덱스 사용법', 'PostgreSQL에서 효율적으로 인덱스를 사용하는 방법.', NOW() - INTERVAL FLOOR(RAND() * 365) DAY, NOW() - INTERVAL FLOOR(RAND() * 365) DAY, 'N', 8),
    (2, 'JavaScript 프론트엔드 최적화 방법', 'JavaScript에서 페이지 로딩 속도 및 성능을 최적화하는 방법.', NOW() - INTERVAL FLOOR(RAND() * 365) DAY, NOW() - INTERVAL FLOOR(RAND() * 365) DAY, 'N', 22),
    (5, 'Flutter로 크로스 플랫폼 앱 개발하기', 'Flutter를 이용해 iOS와 Android 앱을 동시에 개발하는 방법.', NOW() - INTERVAL FLOOR(RAND() * 365) DAY, NOW() - INTERVAL FLOOR(RAND() * 365) DAY, 'N', 13),
    (4, 'WebSocket을 이용한 실시간 채팅 구현', 'WebSocket을 이용한 실시간 채팅 시스템을 구현하는 방법.', NOW() - INTERVAL FLOOR(RAND() * 365) DAY, NOW() - INTERVAL FLOOR(RAND() * 365) DAY, 'N', 29),
    (1, '머신러닝을 활용한 예측 모델 만들기', '머신러닝을 사용하여 예측 모델을 만드는 기본적인 접근 방법.', NOW() - INTERVAL FLOOR(RAND() * 365) DAY, NOW() - INTERVAL FLOOR(RAND() * 365) DAY, 'N', 50);


# 게시판 테이블 생성 완료

CREATE TABLE `tbl_comment` (
                               `comment_id`	INT	NOT NULL PRIMARY KEY	AUTO_INCREMENT,
                               `comment_content`	VARCHAR(255)	NOT NULL,
                               `created_at`	DATETIME	NOT NULL	DEFAULT NOW(),
                               `updated_at`	DATETIME	NULL,
                               `is_blinded`	VARCHAR(255)	NOT NULL	DEFAULT 'N',
                               `user_id`	INT	NOT NULL,
                               `post_id`	INT	NULL,
                               `ref_comment_id`	INT	NULL,
                                CONSTRAINT fk_tbl_comment_to_tbl_user FOREIGN KEY (user_id) REFERENCES tbl_user(user_id),
                                CONSTRAINT fk_tbl_comment_to_tbl_board FOREIGN KEY (post_id) REFERENCES tbl_board(post_id),
                                CONSTRAINT fk_tbl_comment_to_tbl_comment FOREIGN KEY (ref_comment_id) REFERENCES tbl_comment(comment_id)
);

INSERT INTO `tbl_comment` (
                           `comment_content`
                          , `created_at`
                          , `updated_at`
                          , `is_blinded`
                          , `user_id`
                          , `post_id`
                          , `ref_comment_id`
)
VALUES
  ('이 프로젝트 너무 좋아요! 계속해서 발전하길 바랍니다.', '2025-03-01 10:30:00', NULL, 'N', 1, 1, NULL),
  ('React의 성능 최적화에 대한 좋은 팁이네요. 감사합니다!', '2025-03-01 11:00:00', NULL, 'N', 2, 1, NULL),
  ('대댓글 테스트입니다. 본 댓글에 대한 피드백을 남깁니다.', '2025-03-01 11:10:00', NULL, 'N', 3, 1, 2),
  ('혹시 이 알고리즘을 어떻게 최적화할 수 있을까요?', '2025-03-01 12:20:00', NULL, 'N', 4, 2, NULL),
  ('좋은 정보 감사합니다. 그런데 이 부분에 대해 조금 더 설명해 주실 수 있나요?', '2025-03-01 13:45:00', NULL, 'N', 5, 2, 4),
  ('저는 JavaScript를 더 많이 사용했는데, React가 정말 편리한 것 같아요.', '2025-03-01 14:30:00', NULL, 'N', 6, 3, NULL),
  ('좋은 자료입니다. 프론트엔드 개발에 많은 도움이 될 것 같아요.', '2025-03-02 08:10:00', NULL, 'N', 7, 3, NULL),
  ('이 코드를 어떻게 개선할 수 있을까요? 더 나은 방법이 있을 것 같아요.', '2025-03-02 09:30:00', NULL, 'N', 8, 3, 7),
  ('이거 진짜 유용한 자료네요! 한번 더 시도해보고 결과를 공유할게요.', '2025-03-02 10:20:00', NULL, 'N', 9, 4, NULL),
  ('백엔드 개발에 도움이 될 것 같아요. API 설계에 대해 더 다뤄주세요.', '2025-03-02 11:50:00', NULL, 'N', 10, 4, NULL),
  ('안녕하세요! 이 부분에서 오류가 발생했는데, 해결 방법이 있을까요?', '2025-03-02 12:15:00', NULL, 'N', 11, 4, 10),
  ('저는 Node.js로도 비슷한 작업을 했었는데, 그 방법도 공유할 수 있을까요?', '2025-03-02 13:00:00', NULL, 'N', 12, 5, NULL),
  ('이 글에서 다룬 내용을 실제로 적용해봤어요. 정말 도움이 되었어요.', '2025-03-03 09:10:00', NULL, 'N', 13, 5, NULL),
  ('대댓글을 작성합니다. 이 내용에 대해 추가적인 설명을 드리고 싶습니다.', '2025-03-03 10:05:00', NULL, 'N', 14, 5, 13),
  ('정말 좋은 글입니다. 다만, 예시 코드가 더 많으면 좋겠네요.', '2025-03-03 11:15:00', NULL, 'N', 15, 6, NULL),
  ('제가 사용한 방식은 조금 다르긴 한데, 공유해보겠습니다.', '2025-03-03 12:45:00', NULL, 'N', 16, 6, 15),
  ('이 내용은 초보자에게도 정말 유용한 것 같아요. 감사합니다!', '2025-03-03 14:25:00', NULL, 'N', 17, 7, NULL),
  ('프로젝트 진행 상황을 업데이트하셨군요. 좋은 변화네요.', '2025-03-04 10:00:00', NULL, 'N', 18, 7, NULL),
  ('이 문제에 대한 해결책을 알고 싶어요. 해결책이 있다면 공유해주세요.', '2025-03-04 11:20:00', NULL, 'N', 19, 7, 18),
  ('저도 비슷한 상황에서 어려움을 겪었는데, 이렇게 해결했었습니다.', '2025-03-04 12:10:00', NULL, 'N', 20, 8, NULL),
  ('백엔드 개발에 대한 지식이 부족했는데, 이 글 덕분에 많이 배웠습니다.', '2025-03-04 13:30:00', NULL, 'N', 21, 8, NULL),
  ('이 글은 정말 많은 개발자들에게 도움이 될 것 같아요. 감사드립니다.', '2025-03-04 14:40:00', NULL, 'N', 22, 9, NULL),
  ('실제 프로젝트에 적용해보고, 그 결과를 공유하려 합니다.', '2025-03-05 10:00:00', NULL, 'N', 23, 9, NULL),
  ('대댓글입니다. 이 방법을 사용해봤는데 성능이 크게 개선되었어요.', '2025-03-05 11:30:00', NULL, 'N', 24, 9, 23),
  ('저도 이 방법을 사용해봤는데, 결과가 매우 만족스러웠습니다.', '2025-03-05 12:50:00', NULL, 'N', 25, 10, NULL),
  ('어떤 라이브러리에서 이런 방식으로 접근할 수 있나요?', '2025-03-05 13:40:00', NULL, 'N', 26, 10, 25),
  ('이 방법 정말 유용하네요. 다른 방법들도 더 소개해 주시면 좋겠습니다.', '2025-03-05 14:15:00', NULL, 'N', 27, 11, NULL),
  ('리팩토링을 진행하면서 이 방법을 적용해봤습니다. 많은 도움이 되었어요.', '2025-03-06 09:10:00', NULL, 'N', 28, 11, NULL),
  ('리스트 렌더링에서 성능 최적화 방법에 대해 논의할 필요가 있습니다.', '2025-03-06 10:50:00', NULL, 'N', 29, 12, NULL),
  ('대댓글로 추가 설명을 남깁니다. 이 부분을 좀 더 다뤄주세요.', '2025-03-06 11:40:00', NULL, 'N', 30, 12, 29),
  ('이 문제를 어떻게 해결할 수 있을까요? 궁금한 점이 많습니다.', '2025-03-06 12:30:00', NULL, 'N', 31, 13, NULL),
  ('구체적인 예시를 더 추가해주시면 더 도움이 될 것 같아요.', '2025-03-06 13:10:00', NULL, 'N', 32, 13, NULL),
  ('이번 글을 보고 실제로 시도해본 결과, 매우 유용했습니다.', '2025-03-06 14:00:00', NULL, 'N', 33, 14, NULL),
  ('이 방법을 사용해보니 성능이 훨씬 좋아졌어요. 추천드립니다!', '2025-03-07 08:30:00', NULL, 'N', 34, 14, NULL),
  ('대댓글로 남깁니다. 문제를 해결할 수 있었습니다.', '2025-03-07 09:15:00', NULL, 'N', 35, 14, 34),
  ('API 연동 방법에 대해 더 알고 싶습니다. 이 부분을 조금 더 구체적으로 설명해 주세요.', '2025-03-07 10:25:00', NULL, 'N', 36, 15, NULL),
  ('백엔드에서는 어떻게 처리해야 할지에 대해 더 다루어 주셨으면 좋겠습니다.', '2025-03-07 11:40:00', NULL, 'N', 37, 15, NULL),
  ('이 글을 보고 서버리스 아키텍처에 대해 더 공부해봐야겠어요.', '2025-03-07 13:10:00', NULL, 'N', 38, 16, NULL),
  ('이 글의 내용은 정말 중요한 팁들로 가득 차 있습니다. 감사합니다!', '2025-03-07 14:00:00', NULL, 'N', 39, 16, NULL),
  ('대댓글입니다. 이 방법을 통해 문제를 해결할 수 있었습니다.', '2025-03-07 15:20:00', NULL, 'N', 40, 16, 39),
  ('배운 내용들로 다시 코드를 개선해 보겠습니다.', '2025-03-07 16:00:00', NULL, 'N', 41, 17, NULL),
  ('이 방식으로도 문제가 해결되었네요. 다시 한번 감사합니다.', '2025-03-08 08:15:00', NULL, 'N', 42, 17, NULL),
  ('좋은 정보 감사합니다!', NOW(), NULL, 'N', 12, 34, NULL),
  ('이거 정말 도움이 됐어요!', NOW(), NULL, 'N', 25, 22, NULL),
  ('이 부분에 대해 더 설명해주실 수 있나요?', NOW(), NULL, 'N', 8, 15, NULL),
  ('이런 글 너무 좋아요!', NOW(), NULL, 'N', 41, 10, NULL),
  ('고생 많으셨어요. 정말 감사합니다.', NOW(), NULL, 'N', 2, 29, NULL),
  ('혹시 이 방법에 대한 다른 팁도 있나요?', NOW(), NULL, 'N', 19, 17, NULL),
  ('이 글 정말 유용하네요!', NOW(), NULL, 'N', 27, 4, NULL),
  ('완전 고생하셨습니다. 잘 봤어요!', NOW(), NULL, 'N', 36, 25, NULL);

# 댓글 테이블 생성 완료

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

#

CREATE TABLE `tbl_bookmark` (
                                `post_id`	INT	NOT NULL,
                                `user_id`	INT	NOT NULL,
                                CONSTRAINT fk_tbl_bookmark_to_tbl_board FOREIGN KEY (post_id) REFERENCES tbl_board(post_id),
                                CONSTRAINT fk_tbl_bookmark_to_tbl_user FOREIGN KEY (user_id) REFERENCES tbl_user(user_id)
);

INSERT INTO `tbl_bookmark` (`post_id`, `user_id`)
VALUES
  (12, 19),
  (27, 9),
  (50, 33),
  (15, 44),
  (23, 2),
  (38, 5),
  (48, 17),
  (3, 7),
  (9, 41),
  (34, 13),
  (22, 28),
  (13, 8),
  (44, 6),
  (5, 25),
  (36, 12),
  (47, 21),
  (16, 38),
  (2, 31),
  (41, 20),
  (50, 1),
  (25, 30),
  (37, 4),
  (33, 29),
  (14, 18),
  (8, 32),
  (45, 23),
  (28, 11),
  (11, 46),
  (49, 10),
  (4, 39),
  (48, 45),
  (19, 34),
  (26, 27),
  (22, 8),
  (36, 50),
  (31, 6),
  (40, 44),
  (35, 13),
  (9, 3),
  (5, 24),
  (7, 41),
  (16, 17),
  (32, 12),
  (41, 29),
  (24, 33),
  (2, 46),
  (34, 50),
  (8, 21),
  (49, 39),
  (35,23);

# 북마크, 좋아요 테이블 생성 완료

CREATE TABLE `tbl_report_category` (
                                       `violation_id`	INT	PRIMARY KEY NOT NULL AUTO_INCREMENT,
                                       `minus_point`	INT	NOT NULL,
                                       `content`	VARCHAR(255)	NOT NULL
);

INSERT INTO `tbl_report_category` (`minus_point`, `content`)
VALUES
 (10, '부적절한 언어 사용'),
 (30, '불법적인 내용의 게시물 업로드'),
 (50, '허위 정보 유포'),
 (100, '반복적인 악성 댓글 달기'),
 (30, '게시물에서 다른 사용자 비방'),
 (50, '회원 간 개인 정보 유출'),
 (10, '불법 광고 게시물 등록'),
 (100, '반복적으로 커뮤니티 규정 위반'),
 (10, '스팸 메시지 전송'),
 (50, '타인의 저작물 무단 복제');

CREATE TABLE `tbl_report` (
                              `report_id`	INT	NOT NULL PRIMARY KEY AUTO_INCREMENT,
                              `report_content`	VARCHAR(255)	NULL,
                              `created_at`	DATETIME	NOT NULL    DEFAULT NOW(),
                              `is_processed`	VARCHAR(255)	NOT NULL	DEFAULT 'N',
                              `poster_id`	INT	NOT NULL,
                              `report_target_post_id`	INT	NULL,
                              `report_target_user_id`	INT	NULL,
                              `comment_id`	INT	NULL,
                                CONSTRAINT fk_tbl_report_to_tbl_user FOREIGN KEY (poster_id) REFERENCES tbl_user(user_id),
                                CONSTRAINT fk_tbl_report_to_tbl_board FOREIGN KEY (report_target_post_id) REFERENCES tbl_board(post_id),
                                CONSTRAINT fk_tbl_report_to_tbl_user2 FOREIGN KEY (report_target_user_id) REFERENCES tbl_user(user_id),
                                CONSTRAINT fk_tbl_report_to_tbl_comment FOREIGN KEY (comment_id) REFERENCES tbl_comment(comment_id)
);

INSERT INTO `tbl_report` (
                          `report_content`
                         , `created_at`
                         , `is_processed`
                         , `poster_id`
                         , `report_target_post_id`
                         , `report_target_user_id`
                         , `comment_id`
)
VALUES
   ('부적절한 언어 사용', '2024-03-12 10:05:23', 'N', 1, 15, NULL, NULL),
   ('불법적인 내용의 게시물 업로드', '2024-03-10 18:20:45', 'N', 3, NULL, 10, NULL),
   ('허위 정보 유포', '2023-12-14 07:30:12', 'N', 5, NULL, NULL, 7),
   ('반복적인 악성 댓글 달기', '2024-02-05 16:50:33', 'N', 8, 30, NULL, NULL),
   ('게시물에서 다른 사용자 비방', '2024-01-20 22:10:54', 'N', 2, 10, NULL, 9),
   ('회원 간 개인 정보 유출', '2024-03-01 12:25:10', 'N', 11, 35, 13, NULL),
   ('불법 광고 게시물 등록', '2023-11-25 14:40:08', 'N', 7, NULL, 16, 2),
   ('반복적으로 커뮤니티 규정 위반', '2024-02-16 09:12:28', 'N', 14, 45, 18, NULL),
   ('스팸 메시지 전송', '2023-12-22 03:03:19', 'N', 20, NULL, 19, NULL),
   ('타인의 저작물 무단 복제', '2024-02-01 11:30:47', 'N', 17, 5, NULL, 10),
   ('부적절한 언어 사용', '2024-03-07 20:45:05', 'N', 9, 30, NULL, NULL),
   ('불법적인 내용의 게시물 업로드', '2023-11-05 17:12:34', 'N', 6, 18, 23, 4),
   ('허위 정보 유포', '2024-02-19 10:55:29', 'N', 15, 7, NULL, 8),
   ('반복적인 악성 댓글 달기', '2024-03-11 14:30:11', 'N', 10, 15, NULL, 6),
   ('게시물에서 다른 사용자 비방', '2023-12-25 09:25:47', 'N', 19, 22, 26, NULL),
   ('회원 간 개인 정보 유출', '2024-02-13 11:10:30', 'N', 4, NULL, 27, 11),
   ('불법 광고 게시물 등록', '2024-01-28 16:35:22', 'N', 16, NULL, 28, NULL),
   ('반복적으로 커뮤니티 규정 위반', '2024-02-08 08:12:05', 'N', 18, 39, NULL, 12),
   ('스팸 메시지 전송', '2023-11-11 05:20:13', 'N', 21, 41, 30, 13),
   ('타인의 저작물 무단 복제', '2024-01-10 13:15:18', 'N', 25, 33, 31, NULL),
   ('부적절한 언어 사용', '2023-12-01 18:30:22', 'N', 22, NULL, 32, 2),
   ('불법적인 내용의 게시물 업로드', '2023-11-29 16:05:44', 'N', 12, NULL, 33, 14),
   ('허위 정보 유포', '2024-02-14 10:45:56', 'N', 3, NULL, 34, 8),
   ('반복적인 악성 댓글 달기', '2024-03-01 19:10:37', 'N', 30, NULL, NULL, 15),
   ('게시물에서 다른 사용자 비방', '2023-10-28 04:15:29', 'N', 29, NULL, 36, 7),
   ('회원 간 개인 정보 유출', '2024-02-22 06:30:13', 'N', 28, 49, 37, 9),
   ('불법 광고 게시물 등록', '2024-01-17 12:50:59', 'N', 13, 21, NULL, 3),
   ('반복적으로 커뮤니티 규정 위반', '2024-02-04 15:25:18', 'N', 5, 34, NULL, 15),
   ('스팸 메시지 전송', '2023-12-15 23:00:45', 'N', 10, NULL, NULL, 2),
   ('타인의 저작물 무단 복제', '2024-02-19 13:42:30', 'N', 7, NULL, 41, 2),
   ('부적절한 언어 사용', '2024-03-05 09:55:03', 'N', 6, 32, 42, 12),
   ('불법적인 내용의 게시물 업로드', '2023-12-08 07:15:25', 'N', 8, 50, 43, 13),
   ('허위 정보 유포', '2023-10-22 11:32:12', 'N', 4, NULL, 44, 9),
   ('반복적인 악성 댓글 달기', '2024-01-03 05:25:10', 'N', 20, 28, 45, NULL),
   ('게시물에서 다른 사용자 비방', '2024-02-28 08:45:03', 'N', 12, 15, 46, 6),
   ('회원 간 개인 정보 유출', '2023-12-17 09:35:18', 'N', 23, NULL, 47, NULL),
   ('불법 광고 게시물 등록', '2024-03-06 20:10:29', 'N', 25, 41, 48, 2),
   ('반복적으로 커뮤니티 규정 위반', '2023-11-23 17:50:14', 'N', 14, 10, NULL, 13),
   ('스팸 메시지 전송', '2024-02-02 12:25:33', 'N', 27, NULL, 50, 7);


CREATE TABLE `tbl_processed_report` (
    `processed_report_id`	INT	NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `minus_point`	INT	NOT NULL,
    `report_content`	VARCHAR(255)	NOT NULL,
    `processed_at`	DATETIME	NOT NULL	DEFAULT NOW(),
    `report_id`	INT	NOT NULL,
    `violation_id`	INT	NOT NULL,
    `report_target_user_id`	INT	NOT NULL,
    CONSTRAINT fk_tbl_processed_report_to_tbl_report FOREIGN KEY (report_id) REFERENCES tbl_report(report_id),
    CONSTRAINT fk_tbl_processed_report_to_tbl_report_category FOREIGN KEY (violation_id) REFERENCES tbl_report_category(violation_id),
    CONSTRAINT fk_tbl_processed_report_to_tbl_user FOREIGN KEY (report_target_user_id) REFERENCES tbl_user(user_id)
);

# 신고 테이블 3개(신고, 처리된 신고, 위반사항) 생성 완료

## 멘토 리스트
CREATE TABLE `tbl_mentor_list` (
                                   `mentor_id` INT NOT NULL,
                                   `m_expert` VARCHAR(255) NULL,
                                   `m_content` VARCHAR(255) NULL,
                                   PRIMARY KEY (`mentor_id`)
) ENGINE=InnoDB;

ALTER TABLE `tbl_mentor_list`
    ADD CONSTRAINT `FK_TBL_MENTOR_LIST` FOREIGN KEY (`mentor_id`) REFERENCES `tbl_user`(`user_id`);

## 멘토 리스트
INSERT INTO tbl_mentor_list (mentor_id, m_expert, m_content)
VALUES
    (1, 'SQL Expert', 'SQL 및 데이터베이스 관리에 관한 멘토링 제공'),
    (2, 'Java Developer', 'Java 기반 백엔드 개발 및 시스템 아키텍처 멘토링 제공'),
    (3, 'Frontend Specialist', 'HTML, CSS, JavaScript 및 웹 디자인 멘토링 제공'),
    (4, 'AI Researcher', '인공지능, 머신러닝 및 데이터 사이언스 멘토링 제공'),
    (5, 'Project Manager', '프로젝트 관리 및 팀 리딩 전략에 관한 멘토링 제공');



CREATE TABLE `tbl_mentoring_space` (
                                       `mentoring_space_id`	INT	NOT NULL PRIMARY KEY AUTO_INCREMENT,
                                       `personal_information`	VARCHAR(255)	NOT NULL,
                                       `information_is_opened`	VARCHAR(255)	NOT NULL,
                                       `extension_count`	INT	NOT NULL	DEFAULT 0,
                                       `is_activated`	VARCHAR(255)	NOT NULL	DEFAULT 'Y'	,
                                       `user_id`	INT	NOT NULL,
                                        CONSTRAINT fk_tbl_mentoring_space_to_tbl_user FOREIGN KEY (user_id) REFERENCES tbl_user(user_id)
);

INSERT INTO `tbl_mentoring_space` (
       `personal_information`
      , `information_is_opened`
      , `extension_count`
      , `is_activated`
      , `user_id`
) VALUES
  ('연락처: 010-1234-5678, 카카오톡 ID: mentor1', 'N', 0, 'Y', 1),
  ('연락처: 010-2345-6789, 카카오톡 ID: devmentor2', 'Y', 2, 'Y', 2),
  ('연락처: 010-3456-7890, 카카오톡 ID: codingexpert3', 'Y', 0, 'Y', 3),
  ('연락처: 010-4567-8901, 카카오톡 ID: pythonmentor4', 'Y', 1, 'Y', 4),
  ('연락처: 010-5678-9012, 카카오톡 ID: javaandroid5', 'N', 0, 'Y', 5),
  ('연락처: 010-6789-0123, 카카오톡 ID: reactmentor1', 'Y', 0, 'Y', 1),
  ('연락처: 010-7890-1234, 카카오톡 ID: expressjsmentor2', 'N', 1, 'Y', 2),
  ('연락처: 010-8901-2345, 카카오톡 ID: javaexpert3', 'Y', 0, 'Y', 3),
  ('연락처: 010-9012-3456, 카카오톡 ID: aihelper4', 'N', 0, 'N', 4),
  ('연락처: 010-0123-4567, 카카오톡 ID: vuejsmentor5', 'Y', 3, 'Y', 5),
  ('연락처: 010-1234-5678, 카카오톡 ID: nodementor1', 'N', 2, 'Y', 1),
  ('연락처: 010-2345-6789, 카카오톡 ID: jsreactmentor2', 'Y', 0, 'Y', 2),
  ('연락처: 010-3456-7890, 카카오톡 ID: datasciencementor3', 'N', 1, 'Y', 3),
  ('연락처: 010-4567-8901, 카카오톡 ID: springbootmentor4', 'Y', 3, 'Y', 4),
  ('연락처: 010-5678-9012, 카카오톡 ID: iosmentor5', 'N', 2, 'Y', 5),
  ('연락처: 010-6789-0123, 카카오톡 ID: javamentor1', 'N', 0, 'Y', 1),
  ('연락처: 010-7890-1234, 카카오톡 ID: reactreduxmentor2', 'N', 1, 'N', 2),
  ('연락처: 010-8901-2345, 카카오톡 ID: csharpmentor3', 'N', 0, 'Y', 3),
  ('연락처: 010-9012-3456, 카카오톡 ID: aiandmlmentor4', 'Y', 3, 'Y', 4),
  ('연락처: 010-0123-4567, 카카오톡 ID: angularmentor5', 'Y', 4, 'Y', 5),
  ('연락처: 010-1234-5678, 카카오톡 ID: pythonreactmentor1', 'N', 0, 'Y', 1),
  ('연락처: 010-2345-6789, 카카오톡 ID: rubyrailsmentor2', 'Y', 3, 'Y', 2),
  ('연락처: 010-3456-7890, 카카오톡 ID: javaexpertmentor3', 'N', 2, 'Y', 3),
  ('연락처: 010-4567-8901, 카카오톡 ID: kotlinmentor4', 'N', 0, 'Y', 4),
  ('연락처: 010-5678-9012, 카카오톡 ID: htmlcssmentor5', 'Y', 4, 'Y', 5),
  ('연락처: 010-6789-0123, 카카오톡 ID: vuejstypescriptmentor1', 'N', 0, 'Y', 1),
  ('연락처: 010-7890-1234, 카카오톡 ID: javaspringmentor2', 'Y', 3, 'Y', 2),
  ('연락처: 010-8901-2345, 카카오톡 ID: vuefirebasementor3', 'Y', 0, 'N', 3),
  ('연락처: 010-9012-3456, 카카오톡 ID: aimentalmentor4', 'Y', 2, 'Y', 4),
  ('연락처: 010-0123-4567, 카카오톡 ID: javascriptmentor5', 'Y', 0, 'Y', 5);

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


CREATE TABLE `tbl_board_file` (
  `file_id`	INT	NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `address`	VARCHAR(255)	NOT NULL,
  `board_id`	INT	NOT NULL,
    CONSTRAINT fk_tbl_board_file_to_tbl_board FOREIGN KEY (board_id) REFERENCES tbl_board(post_id)
);

INSERT INTO `tbl_board_file` (`address`, `board_id`)
VALUES
 ('https://example.com/file1.pdf', 12),
 ('https://example.com/file2.pdf', 5),
 ('https://example.com/file3.pdf', 22),
 ('https://example.com/file4.pdf', 8),
 ('https://example.com/file5.pdf', 19),
 ('https://example.com/file6.pdf', 27),
 ('https://example.com/file7.pdf', 15),
 ('https://example.com/file8.pdf', 33),
 ('https://example.com/file9.pdf', 40),
 ('https://example.com/file10.pdf', 26),
 ('https://example.com/file11.pdf', 3),
 ('https://example.com/file12.pdf', 50),
 ('https://example.com/file13.pdf', 44),
 ('https://example.com/file14.pdf', 2),
 ('https://example.com/file15.pdf', 12),
 ('https://example.com/file16.pdf', 39),
 ('https://example.com/file17.pdf', 30),
 ('https://example.com/file18.pdf', 7),
 ('https://example.com/file19.pdf', 18),
 ('https://example.com/file20.pdf', 9),
 ('https://example.com/file21.pdf', 16),
 ('https://example.com/file22.pdf', 24),
 ('https://example.com/file23.pdf', 48),
 ('https://example.com/file24.pdf', 31),
 ('https://example.com/file25.pdf', 25),
 ('https://example.com/file26.pdf', 11),
 ('https://example.com/file27.pdf', 36),
 ('https://example.com/file28.pdf', 4),
 ('https://example.com/file29.pdf', 23),
 ('https://example.com/file30.pdf', 47),
 ('https://example.com/file31.pdf', 34),
 ('https://example.com/file32.pdf', 49),
 ('https://example.com/file33.pdf', 6),
 ('https://example.com/file34.pdf', 28),
 ('https://example.com/file35.pdf', 21),
 ('https://example.com/file36.pdf', 38),
 ('https://example.com/file37.pdf', 41),
 ('https://example.com/file38.pdf', 13),
 ('https://example.com/file39.pdf', 14),
 ('https://example.com/file40.pdf', 32),
 ('https://example.com/file41.pdf', 45),
 ('https://example.com/file42.pdf', 43),
 ('https://example.com/file43.pdf', 46),
 ('https://example.com/file44.pdf', 10),
 ('https://example.com/file45.pdf', 17),
 ('https://example.com/file46.pdf', 20),
 ('https://example.com/file47.pdf', 35),
 ('https://example.com/file48.pdf', 29),
 ('https://example.com/file49.pdf', 50),
 ('https://example.com/file50.pdf', 37);

## 질문
CREATE TABLE `tbl_question` (
                                `question_id` INT NOT NULL AUTO_INCREMENT COMMENT 'AUTO_INCREMENT',
                                `question_content` VARCHAR(255) NOT NULL,
                                `question_created_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                `member_id` INT NOT NULL,
                                `mentoringSpace_id` INT NOT NULL,
                                PRIMARY KEY (`question_id`)
) ENGINE=InnoDB;

ALTER TABLE `tbl_question`
    ADD CONSTRAINT `FK_tbl_question_member` FOREIGN KEY (`member_id`) REFERENCES `tbl_user`(`user_id`);

ALTER TABLE `tbl_question`
    ADD CONSTRAINT `FK_tbl_question_mentoring_space` FOREIGN KEY (`mentoringSpace_id`) REFERENCES `tbl_mentoring_space`(`mentoring_space_id`);

## 질문
INSERT INTO tbl_question (question_content, question_created_time, member_id, mentoringSpace_id)
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
                              `question_id` INT NULL,
                              `answer_member_id` INT NOT NULL,
                              `ref_answer_id` INT NULL,
                              `mentoringSpace_id` INT NOT NULL,
                              PRIMARY KEY (`answer_id`),
                              CONSTRAINT `FK_tbl_answer_question` FOREIGN KEY (`question_id`) REFERENCES `tbl_question`(`question_id`),
                              CONSTRAINT `FK_tbl_answer_user` FOREIGN KEY (`answer_member_id`) REFERENCES `tbl_user`(`user_id`),
                              CONSTRAINT `FK_tbl_answer_ref_answer` FOREIGN KEY (`ref_answer_id`) REFERENCES `tbl_answer`(`answer_id`),
                              CONSTRAINT `FK_tbl_answer_mentoring_space` FOREIGN KEY (`mentoringSpace_id`) REFERENCES `tbl_mentoring_space`(`mentoring_space_id`)
) ENGINE=InnoDB;

## 답변 데이터
INSERT INTO tbl_answer (answer_content, question_id, answer_member_id, ref_answer_id, mentoringSpace_id)
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

##################################################################

CREATE TABLE `tbl_mentoring_file` (
  `file_id`	INT	NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `address`	VARCHAR(255)	NOT NULL,
  `file_type`	VARCHAR(255)	NOT NULL,
  `question_id`	INT	NULL,
  `answer_id`	INT	NULL,
    CONSTRAINT fk_tbl_mentoring_file_to_tbl_question FOREIGN KEY (question_id) REFERENCES tbl_question(question_id),
    CONSTRAINT fk_tbl_mentoring_file_to_tbl_answer FOREIGN KEY (answer_id) REFERENCES tbl_answer(answer_id)
);

## 멘토링 파일 데이터 필요

## 팀 모집
CREATE TABLE tbl_team_recruit (
                                  team_post_id	INT	NOT NULL	COMMENT 'AUTO_INCREMENT',
                                  team_name	VARCHAR(255)	NOT NULL,
                                  team_introduce	VARCHAR(255)	NOT NULL,
                                  leader_id	INT	NOT NULL
);
ALTER TABLE `tbl_team_recruit` ADD CONSTRAINT `PK_TBL_TEAM_RECRUIT` PRIMARY KEY (
                                                                                 `team_post_id`
    );

INSERT INTO tbl_team_recruit (team_post_id, team_name, team_introduce, leader_id)
VALUES
    (1, 'Alpha Tech', '최신 AI와 로보틱스 기술을 활용한 혁신 솔루션 개발 팀입니다.', 7),
    (2, 'Beta Innovators', '친환경 에너지 및 지속 가능한 기술 분야에서 미래를 선도합니다.', 8),
    (3, 'Gamma Solutions', '업무 프로세스 혁신을 위한 맞춤형 소프트웨어 솔루션을 제공합니다.', 9),
    (4, 'Delta Dynamics', '디지털 전환 및 애자일 프로젝트 관리 전문 팀입니다.', 10),
    (5, 'Epsilon Enterprises', '기술과 금융 분야에서 최상의 컨설팅 서비스를 제공하는 팀입니다.', 11),
    (6, 'Zeta Creative', '창의적인 아이디어와 디자인을 결합한 마케팅 팀입니다.', 12),
    (7, 'Eta Developers', '최고의 개발 인력을 모아 안정적인 소프트웨어를 개발합니다.', 13),
    (8, 'Theta Analytics', '빅데이터와 인사이트 분석을 통해 미래 가치를 창출합니다.', 14),
    (9, 'Iota Innovators', '끊임없는 연구와 개발로 새로운 기술 패러다임을 제시합니다.', 15),
    (10, 'Kappa Solutions', '고객 맞춤형 솔루션과 서비스를 제공하는 전문 팀입니다.', 16);

####################################################
## 팀 신청자
CREATE TABLE `tbl_applicant` (
                                 `team_post_id`	INT	NOT NULL,
                                 `user_id`	INT	NOT NULL,
                                 `introduce`	VARCHAR(255)	NOT NULL,
                                 `is_processed`	VARCHAR(255)	NOT NULL
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
    (6, 36, 'Creative designer with strong marketing skills.', 'N'),
    (6, 37, 'Experience in creative campaigns.', 'N'),
    (6, 38, 'Passionate about innovative design.', 'N'),

    -- 팀 7: 4명
    (7, 39, 'Proficient in various programming languages.', 'N'),
    (7, 40, 'Strong developer with team spirit.', 'N'),
    (7, 41, 'I have several years of industry experience.', 'N'),
    (7, 42, 'Looking to contribute to cutting-edge projects.', 'N'),

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

####################################################

####################################################
## 멘토링 신청
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

####################################################
## 별점&리뷰
CREATE TABLE `tbl_rating_and_review` (
                                         `rating_id` INT NOT NULL AUTO_INCREMENT COMMENT 'AUTO_INCREMENT',
                                         `star` INT NOT NULL,
                                         `review` VARCHAR(255) NOT NULL,
                                         `created_at` DATETIME NOT NULL DEFAULT NOW(),
                                         `created_id` INT NOT NULL,
                                         `target_id` INT NOT NULL,
                                         PRIMARY KEY (`rating_id`)
) ENGINE=InnoDB;
ALTER TABLE `tbl_rating_and_review`
    ADD CONSTRAINT `FK_Rating_CreatedID` FOREIGN KEY (`created_id`) REFERENCES `tbl_user`(`user_id`);

ALTER TABLE `tbl_rating_and_review`
    ADD CONSTRAINT `FK_Rating_TargetID` FOREIGN KEY (`target_id`) REFERENCES `tbl_user`(`user_id`);

INSERT INTO tbl_rating_and_review (star, review, created_at, created_id, target_id)
VALUES
    (5, '훌륭한 멘토링과 조언을 주셨습니다.', NOW(), 6, 1),
    (4, '아주 지식이 풍부하고 친근한 멘토입니다.', NOW(), 7, 2),
    (3, '괜찮은 멘토링이었지만, 개선의 여지가 있습니다.', NOW(), 8, 3),
    (5, '탁월한 지원과 커리어 조언에 감사합니다.', NOW(), 9, 4),
    (4, '실용적인 통찰력을 주는 유익한 멘토입니다.', NOW(), 10, 5),
    (5, '훌륭한 멘토, 적극 추천합니다!', NOW(), 11, 1),
    (3, '보통 수준의 경험이었으며, 더 자세한 피드백을 기대했습니다.', NOW(), 12, 2),
    (4, '제 학습 여정에 긍정적인 영향을 주었습니다.', NOW(), 13, 3),
    (5, '매우 영감을 주는 멘토링 세션이었습니다.', NOW(), 14, 4),
    (4, '명확한 소통과 전문적인 안내가 인상적이었습니다.', NOW(), 15, 5);




