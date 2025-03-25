# 팀 모집 게시글을 작성한 회원으로 조회
SELECT
       tr.team_post_id,
       tr.post_title,
       tr.team_name,
       tr.team_introduce,
       tr.created_at,
       tr.modified_at,
       tr.is_deleted,
       tr.is_completed,
       u.nickname AS leader_nickname
  FROM tbl_team_recruit tr
  JOIN tbl_user u ON tr.leader_id = u.user_id
 WHERE tr.is_deleted = 'N'
 ORDER BY tr.team_post_id DESC

# 팀 모집 게시글을 작성한 회원의 닉네임으로 조회
SELECT
       tr.team_post_id,
       tr.post_title,
       tr.team_name,
       tr.team_introduce,
       tr.created_at,
       tr.modified_at,
       tr.is_deleted,
       tr.is_completed,
       u.nickname AS leader_nickname
  FROM tbl_team_recruit tr
  JOIN tbl_user u ON tr.leader_id = u.user_id
 WHERE u.nickname = #{nickname}
   AND tr.is_deleted = 'N'
 ORDER BY tr.team_post_id DESC

# 팀 모집 게시글 제목으로 조회
SELECT
       tr.team_post_id,
       tr.post_title,
       tr.team_name,
       tr.team_introduce,
       tr.created_at,
       tr.modified_at,
       tr.is_deleted,
       tr.is_completed,
       u.nickname AS leader_nickname
  FROM tbl_team_recruit tr
  JOIN tbl_user u ON tr.leader_id = u.user_id
 WHERE tr.post_title LIKE CONCAT('%', #{title}, '%')
   AND tr.is_deleted = 'N'
 ORDER BY tr.team_post_id DESC

# 팀 모집 게시글 팀명으로 조회
SELECT
       tr.team_post_id,
       tr.post_title,
       tr.team_name,
       tr.team_introduce,
       tr.created_at,
       tr.modified_at,
       tr.is_deleted,
       tr.is_completed,
       u.nickname AS leader_nickname
  FROM tbl_team_recruit tr
  JOIN tbl_user u ON tr.leader_id = u.user_id
 WHERE tr.team_name = #{teamName}
   AND tr.is_deleted = 'N'
 ORDER BY tr.team_post_id DESC

# 팀 모집 게시글 최신순으로 조회
SELECT
       tr.team_post_id,
       tr.post_title,
       tr.team_name,
       tr.team_introduce,
       tr.created_at,
       tr.modified_at,
       tr.is_deleted,
       tr.is_completed,
       u.nickname AS leader_nickname
  FROM tbl_team_recruit tr
  JOIN tbl_user u ON tr.leader_id = u.user_id
 WHERE tr.is_deleted = 'N'
 ORDER BY tr.team_post_id DESC

# 팀 모집 게시글 기간으로 조회
SELECT
       tr.team_post_id,
       tr.post_title,
       tr.team_name,
       tr.team_introduce,
       tr.created_at,
       tr.modified_at,
       tr.is_deleted,
       tr.is_completed,
       u.nickname AS leader_nickname
  FROM tbl_team_recruit tr
  JOIN tbl_user u ON tr.leader_id = u.user_id
 WHERE tr.created_at BETWEEN #{startDate} AND #{endDate}
   AND tr.is_deleted = 'N'
 ORDER BY tr.team_post_id DESC

# 모집 중인 팀 모집 게시글 조회
SELECT
       tr.team_post_id,
       tr.post_title,
       tr.team_name,
       tr.team_introduce,
       tr.created_at,
       tr.modified_at,
       tr.is_deleted,
       tr.is_completed,
       u.nickname AS leader_nickname
  FROM tbl_team_recruit tr
  JOIN tbl_user u ON tr.leader_id = u.user_id
 WHERE tr.is_completed = 'N'
   AND tr.is_deleted = 'N'
 ORDER BY tr.team_post_id DESC

# 팀 모집 신청을 한 모든 유저 조회
SELECT a.user_id,
       u.nickname,
       a.introduce,
       a.is_processed,
       t.team_post_id,
       t.post_title,
       t.team_name
  FROM tbl_applicant a
  JOIN tbl_user u ON a.user_id = u.user_id
  JOIN tbl_team_recruit t ON a.team_post_id = t.team_post_id
 WHERE a.team_post_id = #{teamPostId}

# 특정 팀 모집 게시글에 신청한 회원 조회
SELECT a.user_id,
       u.nickname,
       a.introduce,
       a.is_processed,
       t.team_post_id,
       t.post_title,
       t.team_name
  FROM tbl_applicant a
  JOIN tbl_user u ON a.user_id = u.user_id
  JOIN tbl_team_recruit t ON a.team_post_id = t.team_post_id
 WHERE a.user_id = #{userId}

# 특정 유저가 지원한 모집 게시글 상세 조회       
SELECT a.user_id,
       u.nickname,
       a.introduce,
       a.is_processed,
       t.team_post_id,
       t.post_title,
       t.team_name,
       leader.nickname AS leader_nickname
  FROM tbl_applicant a
  JOIN tbl_user u ON a.user_id = u.user_id
  JOIN tbl_team_recruit t ON a.team_post_id = t.team_post_id
  JOIN tbl_user leader ON t.leader_id = leader.user_id 
 WHERE a.user_id = #{userId}
