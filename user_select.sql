SELECT * FROM tbl_user;


# 로그인 시에 로그인 아이디에 대한 비밀번호를 조회
SELECT password
FROM tbl_user
WHERE login_id = 'user45';

# 아이디 조회 성공
SELECT login_id
FROM tbl_user

WHERE name = 'John Doe' AND phone_number = '010-1234-5678';
# 아이디 조회 실패
SELECT login_id
FROM tbl_user
WHERE name = 'John Doe'
  AND phone_number = '010-1111-1111';

# 비밀번호 조회 성공
SELECT password
FROM tbl_user
WHERE login_id = 'user2'
  AND name = 'Jane Smith'
  AND phone_number = '010-2345-6789';

# 비밀번호 조회 실패
SELECT password
FROM tbl_user
WHERE login_id = 'user2'
  AND name = 'Jane Elizabeth'
  AND phone_number = '010-2222-6789';

# 닉네임 검색
SELECT nickname
FROM tbl_user
WHERE nickname LIKE '%King%';

# 닉네임을 선택했을 때 유저 정보 표시
SELECT
    name
     , nickname
     , created_at
     , is_quitted
     , 깃허브주소
     , extension_count
     , career_info
     , is_mentor
FROM tbl_user
WHERE nickname = 'CloudKing';

# 사용자가 멘토 리스트에 등록하려고 할 때 사용자 id를 참조하여 멘토 여부를 확인
SELECT is_mentor
FROM tbl_user
WHERE user_id = 1;

# 사용자가 본인의 칭호 리스트를 확인
SELECT title_id
FROM tbl_title_list
WHERE user_id = 2;

# 멘토가 본인의 누적 연장 횟수를 조회
SELECT extension_count
FROM tbl_user
WHERE user_id = 5;

# 자신이 받은 쪽지 내역을 확인한다.
SELECT
    mail_id
    , content
    , sender_id
FROM tbl_mail
WHERE receiver_id = 1;

# 자신이 보낸 쪽지 내역을 확인한다.
SELECT
    mail_id
     , content
     , receiver_id
FROM tbl_mail
WHERE sender_id = 1;
