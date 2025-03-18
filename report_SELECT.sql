### 신고 목록 전체 조회 ###
SELECT
    r.report_id,
    r.report_content,
    r.created_at,
    r.is_processed,
    r.is_processed_time,
    u.name AS reporter_name,
    v.content AS violation_type,
    r.report_target_post_id,
    r.report_target_user_id,
    r.comment_id
FROM tbl_report r
         JOIN tbl_user u ON r.poster_id = u.user_id
         JOIN tbl_report_category v ON r.violation_id = v.violation_id
ORDER BY r.created_at DESC;

### 신고목록 중 신고_id 1번으로 조회 ###
SELECT
    r.report_id,
    r.report_content,
    r.created_at,
    r.is_processed,
    r.is_processed_time,
    u.name AS reporter_name,
    v.content AS violation_type,
    r.report_target_post_id,
    r.report_target_user_id,
    r.comment_id
FROM tbl_report r
         JOIN tbl_user u ON r.poster_id = u.user_id
         JOIN tbl_report_category v ON r.violation_id = v.violation_id
WHERE r.report_id = 1;


### 신고 내역 중 신고당한 "게시글별" 개별 신고 조회 ###
SELECT
    r.report_id,
    r.report_content,
    r.created_at,
    r.is_processed,
    r.is_processed_time,
    u.name AS reporter_name,
    v.content AS violation_type,
    r.report_target_post_id,
    r.report_target_user_id,
    r.comment_id
FROM tbl_report r
         JOIN tbl_user u ON r.poster_id = u.user_id
         JOIN tbl_report_category v ON r.violation_id = v.violation_id
WHERE r.report_target_post_id = 1;

### 신고 내역 중 신고당한 "회원별" 개별 신고 조회 ###
SELECT
    r.report_id,
    r.report_content,
    r.created_at,
    r.is_processed,
    r.is_processed_time,
    u.name AS reporter_name,
    v.content AS violation_type,
    r.report_target_post_id,
    r.report_target_user_id,
    r.comment_id
FROM tbl_report r
         JOIN tbl_user u ON r.poster_id = u.user_id
         JOIN tbl_report_category v ON r.violation_id = v.violation_id
WHERE r.report_target_user_id = 8;

### 신고 내역 중 신고당한 "댓글별" 개별 신고 조회 ###
SELECT
    r.report_id,
    r.report_content,
    r.created_at,
    r.is_processed,
    r.is_processed_time,
    u.name AS reporter_name,
    v.content AS violation_type,
    r.report_target_post_id,
    r.report_target_user_id,
    r.comment_id
FROM tbl_report r
         JOIN tbl_user u ON r.poster_id = u.user_id
         JOIN tbl_report_category v ON r.violation_id = v.violation_id
WHERE r.comment_id = 33;

### 신고 내역 중 신고당한 "신고한 회원별" 개별 신고 조회 ###
SELECT
    r.report_id,
    r.report_content,
    r.created_at,
    r.is_processed,
    r.is_processed_time,
    u.name AS reporter_name,
    v.content AS violation_type,
    r.report_target_post_id,
    r.report_target_user_id,
    r.comment_id
FROM tbl_report r
         JOIN tbl_user u ON r.poster_id = u.user_id
         JOIN tbl_report_category v ON r.violation_id = v.violation_id
WHERE r.poster_id = 10;

### 신고 유형 id별 신고 조회 ###
SELECT
    r.report_id,
    r.report_content,
    r.created_at,
    r.is_processed,
    r.is_processed_time,
    u.name AS reporter_name,
    v.content AS violation_type,
    r.report_target_post_id,
    r.report_target_user_id,
    r.comment_id
FROM tbl_report r
         JOIN tbl_user u ON r.poster_id = u.user_id
         JOIN tbl_report_category v ON r.violation_id = v.violation_id
WHERE r.violation_id = 10;

### 신고 처리 여부별 신고 조회 ###
SELECT
    r.report_id,
    r.report_content,
    r.created_at,
    r.is_processed,
    r.is_processed_time,
    u.name AS reporter_name,
    v.content AS violation_type,
    r.report_target_post_id,
    r.report_target_user_id,
    r.comment_id
FROM tbl_report r
         JOIN tbl_user u ON r.poster_id = u.user_id
         JOIN tbl_report_category v ON r.violation_id = v.violation_id
WHERE r.is_processed = 'Y'  ## 'N'
ORDER BY r.is_processed_time DESC;
