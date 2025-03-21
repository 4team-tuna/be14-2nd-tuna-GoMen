# 팀 모집 게시글을 작성한 회원으로 조회
SELECT tr.team_post_id, tr.post_title, tr.team_name, tr.team_introduce, 
       tr.created_at, tr.modified_at, tr.is_completed, 
       u.nickname AS leader_nickname
FROM tbl_team_recruit tr
JOIN tbl_user u ON tr.leader_id = u.user_id
WHERE tr.is_deleted = 'N' 
ORDER BY tr.team_post_id DESC;

# 팀 모집 게시글을 작성한 회원의 닉네임으로 조회
SELECT tr.team_post_id, tr.post_title, tr.team_name, tr.team_introduce, 
       tr.created_at, tr.modified_at, tr.is_completed, 
       u.nickname AS leader_nickname
FROM tbl_team_recruit tr
JOIN tbl_user u ON tr.leader_id = u.user_id
WHERE tr.is_deleted = 'N' 
AND u.nickname = 'DevPro'
ORDER BY tr.team_post_id DESC;

# 팀 모집 게시글 제목으로 조회
SELECT tr.team_post_id, tr.post_title, tr.team_name, tr.team_introduce, 
       tr.created_at, tr.modified_at, tr.is_completed, 
       u.nickname AS leader_nickname
FROM tbl_team_recruit tr
JOIN tbl_user u ON tr.leader_id = u.user_id
WHERE tr.is_deleted = 'N' 
AND tr.post_title LIKE '%AI%'
ORDER BY tr.team_post_id DESC;

# 팀 모집 게시글 팀명으로 조회
SELECT tr.team_post_id, tr.post_title, tr.team_name, tr.team_introduce, 
       tr.created_at, tr.modified_at, tr.is_completed, 
       u.nickname AS leader_nickname
FROM tbl_team_recruit tr
JOIN tbl_user u ON tr.leader_id = u.user_id
WHERE tr.is_deleted = 'N' 
AND tr.team_name = 'React 개발팀'
ORDER BY tr.team_post_id DESC;

# 팀 모집 게시글 최신순으로 조회
SELECT tr.team_post_id, tr.post_title, tr.team_name, tr.team_introduce, 
       tr.created_at, tr.modified_at, tr.is_completed, 
       u.nickname AS leader_nickname
FROM tbl_team_recruit tr
JOIN tbl_user u ON tr.leader_id = u.user_id
WHERE tr.is_deleted = 'N'
ORDER BY tr.team_post_id DESC;

# 팀 모집 게시글 기간으로 조회
SELECT tr.team_post_id, tr.post_title, tr.team_name, tr.team_introduce, 
       tr.created_at, tr.modified_at, tr.is_completed, 
       u.nickname AS leader_nickname
FROM tbl_team_recruit tr
JOIN tbl_user u ON tr.leader_id = u.user_id
WHERE tr.is_deleted = 'N'
AND tr.created_at BETWEEN '2024-03-01 00:00:00' AND '2024-03-10 23:59:59'
ORDER BY tr.team_post_id DESC;

# 모집 중인 팀 모집 게시글 조회
SELECT tr.team_post_id, tr.post_title, tr.team_name, tr.team_introduce, 
       tr.created_at, tr.modified_at, tr.is_completed, 
       u.nickname AS leader_nickname
FROM tbl_team_recruit tr
JOIN tbl_user u ON tr.leader_id = u.user_id
WHERE tr.is_deleted = 'N'
AND tr.is_completed = 'N'
ORDER BY tr.team_post_id DESC;

# 팀 모집 신청을 한 모든 유저 조회
SELECT tr.team_post_id, tr.post_title, tr.team_name, 
       u.nickname AS applicant_nickname, a.is_processed
FROM tbl_applicant a
JOIN tbl_user u ON a.user_id = u.user_id
JOIN tbl_team_recruit tr ON a.team_post_id = tr.team_post_id
WHERE tr.is_deleted = 'N';

# 특정 팀 모집 게시글에 신청한 회원 조회
SELECT tr.team_post_id, tr.post_title, tr.team_name, tr.team_introduce, 
       tr.created_at, tr.modified_at, u.nickname AS applicant_nickname, 
       a.introduce, a.is_processed
FROM tbl_applicant a
JOIN tbl_user u ON a.user_id = u.user_id
JOIN tbl_team_recruit tr ON a.team_post_id = tr.team_post_id
WHERE tr.is_deleted = 'N'
AND a.team_post_id = 1;

# 내가 신청한 팀 모집 게시글 및 수락여부 조회
SELECT tr.team_post_id, tr.post_title, tr.team_name, tr.team_introduce, 
       tr.created_at, tr.modified_at, u.nickname AS leader_nickname, 
       a.introduce, a.is_processed
FROM tbl_applicant a
JOIN tbl_team_recruit tr ON a.team_post_id = tr.team_post_id
JOIN tbl_user u ON tr.leader_id = u.user_id
WHERE tr.is_deleted = 'N'
AND a.user_id = (SELECT user_id FROM tbl_user WHERE nickname = 'DataScienceKing')
ORDER BY tr.created_at DESC;
