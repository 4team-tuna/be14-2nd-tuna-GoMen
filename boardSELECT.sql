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



SELECT
    post_id,
    category,
    title,
    content,
    created_at,
    modified_at,
    is_blinded,
    is_deleted,
    user_id
FROM tbl_board
WHERE post_id = 2; --  게시글의 내용(컬럼들) 조회


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
WHERE bo.post_id = 2; -- 특정 게시글 작성자의 정보 조회


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
WHERE c.post_id = 8 -- 특정 게시글의 댓글 조회, ref_comment_id로 대댓글구분
ORDER BY c.created_at ASC; -- 댓글 작성 시간 순 정렬