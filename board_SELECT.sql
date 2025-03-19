SELECT
    b.post_id,
    b.category,
    b.title,
    b.content,
    b.created_at,
    b.modified_at,
    b.is_blinded,
    b.is_deleted,
    u.user_id,
    u.nickname AS author_nickname
FROM tbl_board b
         JOIN tbl_user u ON b.user_id = u.user_id
ORDER BY b.created_at DESC;    -- 최신순 정렬

SELECT
    b.post_id,
    bo.category,
    bo.title,
    bo.content,
    bo.created_at,
    bo.modified_at,
    bo.is_blinded,
    bo.is_deleted,
    u.user_id,
    u.nickname AS user_nickname
FROM tbl_bookmark b
         JOIN tbl_board bo ON b.post_id = bo.post_id
         JOIN tbl_user u ON bo.user_id = u.user_id
WHERE b.user_id = 50; -- 특정 사용자가 북마크한 게시글 정보 조회
ORDER BY b.created_at DESC; -- 최신 북마크 순 정렬





SELECT
    b.post_id, b.category, b.title, b.content,
    b.created_at, b.modified_at, b.is_blinded,
    b.is_deleted, b.user_id, u.nickname AS author_nickname,
    f.file_id, f.address
FROM tbl_board b
         JOIN tbl_user u ON b.user_id = u.user_id
         LEFT JOIN tbl_board_file f ON b.post_id = f.board_id --파일없어도 조회가능
WHERE b.is_deleted = 'N' AND b.post_id = 28; --특정 게시글의 정보조회



SELECT
     u.user_id,
    u.login_id,
    u.name,
    u.nickname,
    u.phone_number,
    u.personal_number,
    u.created_at AS user_created_at,
    u.updated_at,
    u.will_be_activated,
    u.is_quitted,
    u.github_adress,
    u.extension_count,
    u.career_info,
    u.is_mentor,
    u.violation_score
FROM tbl_board bo
         JOIN tbl_user u ON bo.user_id = u.user_id
WHERE bo.post_id = 2; -- 특정 게시글의 작성자의 정보 조회







SELECT 
    c.comment_id, 
    c.comment_content, 
    c.created_at, 
    c.updated_at, 
    c.is_blinded, 
    c.is_deleted,
    c.user_id, 
    u.nickname AS commenter_nickname, 
    c.post_id, 
    c.ref_comment_id
FROM tbl_comment c
JOIN tbl_user u ON c.user_id = u.user_id
WHERE c.post_id = 8 -- 특정 게시글의 댓글 조회
ORDER BY c.created_at ASC; -- 댓글 작성 시간 순 정렬
