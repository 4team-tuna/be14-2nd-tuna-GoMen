# be14-2nd-tuna-GoMen
<img src="https://github.com/user-attachments/assets/ad9fbe23-7288-43b9-ae23-ad764aebf340" width="550" height="400">

## GoMen -  코딩 멘토-멘티 매칭 서비스

### 목차
1. [📁 프로젝트 기획](#1)
   - [1-1. 개요](#1-1)
   - [1-2. 배경 및 필요성](#1-2)
   - [1-3. 주요 기능](#1-3)
   - [1-4. WBS](#1-4)
   - [1-5. 요구사항 명세서](#1-5)
2. [🔎 모델링](#2)
   - [2-1. 논리 모델링](#2-1)
   - [2-2. ERD](#2-2)
   - [2-3. DDD](#2-2)
3. [⚙️ SPRING SECURITY , 유레카 서버](#3)
   - [3-1. 유레카 서버](#3-1)
   - [3-2. SPRING SECURITY](#3-2)
4. [✍🏻 API TEST](#4)
   - [4-1. Applicant](#4-1)
   - [4-2. MENTORING](#4-2)
   - [4-3. BOOKMARK&LIKE](#4-3)
   - [4-4. BOARD](#4-4)
   - [4-5. Mail](#4-5)
   - [4-6. Report](#4-6)
   - [4-7. Signup&Login](#4-7)
   - [4-8.TeamRecruit](#4-8)
   - [4-9.Title](#4-9)
   - [4-10.User](#4-10)
5. [🎮 기술 스택](#5)
6. [📗 회고록](#6)
7. [ 📋 Peer Review - Team Spark](#7)

---

## 팀원 소개

| 이혜영 | 이준규 | 한석현 | 김성민 | 서민종 |
|--------|--------|--------|--------|--------|
|<img src="https://github.com/user-attachments/assets/90d69166-6eee-4d9b-bdd0-ac230c4b42ef" width="200" height="200"> | <img src="https://github.com/user-attachments/assets/058daceb-2a13-4c5d-a6c6-59dfd3b5e62f" width="200" height="200"> | <img src="https://github.com/user-attachments/assets/c17d7bc2-4a71-4323-8fb4-7fb38f518daa" width="200" height="200"> | <img src="https://github.com/user-attachments/assets/2e2ec6dc-d653-4fbe-85a5-d8cb2706097b" width="200" height="200"> | <img src="https://github.com/user-attachments/assets/369c6510-e8bd-48f4-b7d4-c1ed56d4fcdb" width="200" height="200"> |
| ISTP | ESTP | ENFP | ESFP | ENFP |



---

## 📁 1. 프로젝트 기획
### 1-1. 개요
이 플랫폼은 개발자를 준비하는 학생 및 준비생들이 경력 기반으로 검증된 멘토 혹은 GitHub 링크 등을 통해 실력을 인증받은 멘토들과 1:1 또는 팀 단위로 멘토링을 받을 수 있는 커뮤니티 기반 웹사이트입니다. 사용자는 개발 실력 향상을 위한 멘토링뿐 아니라, 서로 프로젝트 팀을 구성하거나 개발 정보를 공유하며 실무 경험을 쌓을 수 있습니다.
멘토의 신뢰성 확보와 체계적인 커뮤니케이션 기능을 통해, 사용자에게 보다 실질적이고 질 높은 성장 경험을 제공합니다.

### 1-2. 배경 및 필요성
최근 개발자 취업 시장은 경쟁이 치열해지고 있으며, 단순 이론 학습만으로는 실무 역량을 갖추기에 한계가 있습니다. 준비생들은 실제 개발 환경에서의 경험 부족, 멘토 부재, 협업 경험 부족 등의 문제를 공통적으로 겪고 있습니다.

기존의 멘토링 서비스는 멘토의 전문성과 신뢰도 검증이 어려운 경우가 많았으나, 본 플랫폼은 실제 경력 기반 또는 GitHub 등 외부 포트폴리오를 통해 검증된 멘토만 등록할 수 있어 신뢰성 있는 멘토링이 가능합니다.

또한, 사용자는 멘토링을 통해 실시간 피드백을 받고, 커뮤니티 게시판을 통해 정보를 공유하며, 프로젝트 팀을 구성해 협업 능력까지 키울 수 있습니다. 이러한 환경은 개발자로서의 성장과 커리어 준비에 큰 도움을 줄 것입니다.


### 1-3. 주요 기능
1.함께 프로젝트를 진행할 팀원 모집 및 생성 가능
2.인증된 멘토들에게 팀단위, 개인단위의 멘토링 가능
3.칭호, 커뮤니티등을 통해 학습욕구 및 정보공유 가능
4.별점및 리뷰 시스템을 통해 사용자 퀄리티 향상 가능
5.신고를 통한 벌점 제도를 통해효율적인 회원관리 가능

### 1-4. WBS
[WBS 링크](https://docs.google.com/spreadsheets/d/19VZI_1LJ8Jx2r8srhHZ5M0GApO66an1NkPZsmz7pS5Y/edit?gid=1013678623#gid=1013678623)
![Image](https://github.com/user-attachments/assets/75c8af85-c9b2-4ad8-9297-c3fe8afb94ea)
### 1-5. 요구사항 명세서
[요구사항 명세서 링크](https://docs.google.com/spreadsheets/d/19VZI_1LJ8Jx2r8srhHZ5M0GApO66an1NkPZsmz7pS5Y/edit?gid=0#gid=0)

![image](https://github.com/user-attachments/assets/8e653510-e6ef-4c2e-927d-ec7bceee39c6)



## 🔎 2. 모델링

### 2-1. 논리 모델링
![image](https://github.com/user-attachments/assets/2ee7f082-4db7-4cac-8b7b-be8b655933f3)


### 2-2. ERD
![image](https://github.com/user-attachments/assets/3ca9a60c-8660-47b3-995d-29a4a0999833)


### 2-3. DDD

<details>
   <summary>이미지 보기</summary>
     <div style="display: grid; grid-template-columns: repeat(auto-fill, minmax(150px, 1fr)); gap: 10;">
    <img src="https://github.com/user-attachments/assets/597bd467-02ee-4a8e-a475-96dc5b2de964">
   <img src="https://github.com/user-attachments/assets/4a16d359-8ff7-4ff1-9afc-c695eef7859f" >
   <img src="https://github.com/user-attachments/assets/445f7fa9-60f5-4981-96fb-1b06b28df171">
   <img src="https://github.com/user-attachments/assets/c800ce07-2cf9-4d9d-bfa1-5422b503511d">
   <img src="https://github.com/user-attachments/assets/49b7ce69-7d5a-4696-9f8a-3eb340e817e9">
    </div>
</details>


## ⚙️ 3. SPRING SECURITY , 유레카 서버
### 3-1. 유레카 서버
![image](https://github.com/user-attachments/assets/d55c799f-ff23-4e41-a63c-31b8de0534a3)
![image](https://github.com/user-attachments/assets/04e33356-310c-44ce-84d8-eeabd2206e05)


### 3-2. SPRING SECURITY
[DDL 파일](#)

---

## ✍🏻 4. API TEST

### 4-1. Applicant


### 4-2. MENTORING
<details><summary> 사용자 정보</summary>
(쿼리문 예시)
</details>

<details><summary> 매칭 서비스 </summary>
(쿼리문 예시)
</details>


### 4-3. BOOKMARK&LIKE

<details><summary> 북마크 생성 </summary>

   <img src="https://github.com/user-attachments/assets/033097ec-59db-4b5f-a2c6-72df59827582">

</details>

<details><summary>북마크 삭제 </summary>
  <img src="https://github.com/user-attachments/assets/118b17e0-66c7-4630-af2e-9148add920c1">

</details>

<details><summary>북마크 조회 </summary>
  <img src="https://github.com/user-attachments/assets/d64d851d-34e1-4751-a85e-0900c2fea437">
</details>


<details><summary> 좋아요 생성 </summary>
<img src="https://github.com/user-attachments/assets/7c430507-76f3-4ad4-bae9-36045f3a6b3a">

</details>


<details><summary> 좋아요 삭제 </summary>

   <img src="https://github.com/user-attachments/assets/e21b3cb9-4129-462f-800a-18cc0ba38286">

</details>


### 4-4. Board
<details><summary> 게시글 전체 조회</summary>
      <img src="https://github.com/user-attachments/assets/b2f23985-e829-49d2-8f47-0aa0d9e79ea3">
</details>

<details><summary> 게시글 id로 게시글조회</summary>
   <img src="https://github.com/user-attachments/assets/02f73e9c-3cce-4da6-96d3-3cd8c3eceef4">
</details>

<details><summary> 게시글 작성 </summary>
   <img src="https://github.com/user-attachments/assets/528b402e-acbb-4654-899c-d9aeaa25cd05">
</details>

<details><summary> 게시글 수정 </summary>
  <img src="https://github.com/user-attachments/assets/e3fbfa6e-1f6b-4919-971f-0b9b2ef99595">
</details>

<details><summary> 게시글 삭제 </summary>
 <img src="https://github.com/user-attachments/assets/c5e9d992-430a-4fb6-8426-067744f92f9d">

</details>

<details><summary> 댓글 작성 </summary>
  <img src="https://github.com/user-attachments/assets/7f4da93c-f281-4e51-85d3-8a029b38d36c">

</details>

<details><summary> 댓글 수정 </summary>
 <img src="https://github.com/user-attachments/assets/ae5d7b99-8b66-4b15-8156-2eca49ac440a">

</details>

<details><summary> 댓글 삭제 </summary>
<img src="https://github.com/user-attachments/assets/ad08a823-5269-4f77-ac9f-5392c73ef38e">
</details>


### 4-5. Mail
### 4-6. Report
<details><summary> 회원 신고 </summary>
<img src="https://github.com/user-attachments/assets/c45e5149-335a-4a1a-8606-cd34910e384a">
</details>

<details><summary> 게시글 신고 </summary>
<img src="https://github.com/user-attachments/assets/cacaf9b2-0ce7-46d4-acf5-f0d81455c9e5">
   </details>
   
<details><summary> 댓글 신고 </summary>
<img src="https://github.com/user-attachments/assets/d2688cd4-0b2c-41e1-9d0d-d6192e07b7dd">
</details>

<details><summary> 신고 처리상태 변경 </summary>
<img src="https://github.com/user-attachments/assets/34a5e9e0-8d47-4fcb-96d5-e396e90c697d">
   </details>
   
<details><summary> 신고 처리 완료 목록 </summary>
<img src="https://github.com/user-attachments/assets/a057e70f-64ac-4d6c-bf88-cf69e03348ca">
   </details>

### 4-7. Singtup&Login
### 4-8. TeamRecruit
### 4-9. Title
### 4-10. User
<details><summary> 회원 전체 조회 </summary>
      <img src="https://github.com/user-attachments/assets/433f93df-3f1c-44d6-b1c3-ad0cdd79de81">
</details>


<details><summary> 회원 ID로 회원 조회 </summary>
      <img src="https://github.com/user-attachments/assets/ec463662-48a2-4525-baa4-36e6467ddba1">
</details>


### 4-11. Login
<details><summary> 관리자 계정 생성 </summary>
   <img src="https://github.com/user-attachments/assets/b5848192-ea6b-4f9f-83a2-fc20cb4087f8">
</details>

<details><summary> 관리자 로그인 </summary>
   <img src="https://github.com/user-attachments/assets/f2004b83-3a1c-4da1-91ea-68693fc551cc">
</details>

<details><summary> 회원 가입 </summary>
   <img src="https://github.com/user-attachments/assets/ee415f9c-1fd0-4628-a4cb-bec22a0ca5d4">
</details>

<details><summary> 일반 회원 로그인 </summary>
   <img src="https://github.com/user-attachments/assets/cebe8d5f-d73f-414f-8154-a9df807538d2">
</details>



---

## 🎮 5. 기술 스택
<div align=center><h1>📚 STACKS</h1></div>

<div align=center> 
  <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> 
  <img src="https://img.shields.io/badge/mariaDB-003545?style=for-the-badge&logo=mariaDB&logoColor=white"> 
  <br>
  <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
  <br>
  <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
  <img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">
  <br>
  <img src="https://img.shields.io/badge/MyBatis-FF2D20?style=for-the-badge&logo=mybatis&logoColor=white">
  <img src="https://img.shields.io/badge/JPA-6E4C13?style=for-the-badge">
  <br>
</div>

---
## 📋 6.Peer Review - Team Spark

## 🤝 Peer Review Table - Team Spark
|이혜영|회고 내용--------------- 더미 데이터 입니다 본인 내용 작석하고 본인 이름 괄호 안에 * 달아두면 수정본이라고 알아보겠습니다|
|:---:|-|
|한석현*|기능 개발을 훌륭하게 함과 더불어 협업을 위한 깃허브 브랜치 관리, 발표준비까지 완벽하게 수행하시는 모습을 보고 큰 자극을 받았습니다. 프로젝트를 진행하며 길을 잃어갈 때쯤 방향을 제시해 주셔서 원만하게 프로젝트가 진행되고 성공적으로 결과물을 낼 수 있었던 것 같습니다. "모두 잘 하는 멀티플레이어적인 모습을 가장 닮고 싶은 팀원."|
|이준규*|성별, 나이, 흡연 여부, 프로젝트 시작 전 팀원들과의 친분 어떤 컬럼으로 봐도 팀에 스며들기 쉽지 않았을 텐데 너무 잘 적응해줘서 고마웠다. 전공자로서 책임감을 갖고 누구보다 적극적으로 임해주는 모습이 너무 잘 보였다. 프로젝트 흐름을 잘 파악하고 우리가 어떤 점이 부족하고 어떤 점을 채워나가야 할 지 누구보다 빨리 파악하여 회의를 진행시켰다. 팀원 누구도 발견하지 못 하고 넘어간 부분을 스스로 점검하여 새벽 늦은 시간 혹은 이른 아침 시간 카카오톡 단톡방에 커밋한 내용들을 보며 정말 믿음직스럽고 감사했다. 막내임에도 유능한 리더로 느껴질 만큼 프로젝트에 큰 기여를 했다. 마지막 발표준비부터 발표까지 잘 끝내준 멋진 팀원이다.|
|김성민|따로 팀장 역할을 맡은 건 아니었지만, 그럼에도 먼저 나서서 프로젝트를 이끌어 주어, 프로젝트가 원활히 진행되는데 큰 도움이 되었습니다. 프로젝트 전반에 걸쳐 가장 큰 역할을 하셨다고 생각합니다.|
|서민종|리더십이 크게 빛났던것 같습니다. 항상 프로젝트와 코드에 대해 고민하고, 프로젝트를 진행하며 놓칠수도 있는 부분을 잘 잡아주어 프로젝트가 올바른 길로 갈 수 있었습니다.|

|한석현|회고 내용--------------- 더미 데이터 입니다 본인 내용 작석하고 본인 이름 괄호 안에 * 달아두면 수정본이라고 알아보겠습니다|
|:---:|-|
|이혜영*|석현님 특유의 센스있는 입담 덕분에 쾌활하게 프로젝트가 진행되었던 것 같습니다! 그리고 다른 팀원들에게 문제가 생기면 적극적으로 함께 문제를 고민해주는 모습이 인상깊었습니다. 특히나 DB모델링과 더미데이터 생성, 그리고 저희만의 특별한 신고기능을 만들 수 있었던 것은 모두 석현님 덕분이라고 생각합니다! 마지막으로, 끼끼 잘키우세요~|
|이준규*|우리 프로젝트의 꽃이라고 볼 수 있다. 지치고 힘들 때 석현님 덕분에 힘을 낼 수 있었다. 도저히 웃음이 안 나오는 상황에도 그의 재치 덕에 웃을 수 있었다. 개인적으로 사회생활을 하고 프로젝트를 진행함에 있어 축복받은 재능이라 생각한다. 무엇보다 상대적으로 친분이 덜 했던 혜영님이 팀에 잘 적응할 수 있게 팀과 혜영님과의 연결다리가 되어준 느낌이라 너무 감사하고 다행이라 생각한다. 우리 프로젝트의 아하 모먼트인 신고 관리 기능도 아무 탈 없이 잘 작업해주어 너무나 고맙다. 작업속도가 매우 빠르고 팀원들의 피드백 수용속도도 매우 빠르며 주제 선정시 그의 넘쳐나는 아이디어 덕에 불필요한 고민을 줄일 수 있었다. |
|김성민|AI를 활용한 더미 데이터를 만들어 코드가 제대로 작동하는지 확인하는데 큰 도움을 주었고, 코드들의 피드백을 적극적으로 해주시며 전체적으로 팀의 윤활유 역할을 해주셨습니다.|
|서민종|기능구현과 더불어 프로젝트 전체 진행에 대한 능력이 좋으신것 같습니다. 남들이 생각하지 못한 부분까지 짚어주시고 다양한 의견으로 통해 프로젝트의 퀄리티를 향상시키는데 큰 도움이 되었습니다|

|이준규|회고 내용--------------- 더미 데이터 입니다 본인 내용 작석하고 본인 이름 괄호 안에 * 달아두면 수정본이라고 알아보겠습니다|
|:---:|-|
|이혜영*| 준규님이 항상 PR을 바로 리뷰해주시고, 빠르고 꼼꼼하게 소통해주셔서 원활하게 프로젝트를 진행할 수 있었습니다! 그리고 항상 배려해주신 덕분에 제가 이 팀에 잘 적응할 수 있었다고 생각합니다 특히나 mybatis 조회하실 때 가장 많이 맡으셨는데도 전혀 내색하지 않으시고 밤을 새서라도 다 해오시는 열정이 준규님의 본받을 부분이라고 생각합니다.|
|한석현*|비전공자임에도 불구하고, 엄청난 양의 노력을 통해 기능개발에 상당한 부분을 담당했고, 주도적으로 프로젝트를 이끌어 주시면서 계획된 일정 안에 개발이 진행되고 다음단계로 넘어갈 수 있도록 하는데 큰 도움이 되었습니다. "열정과 노력을 가장 닮고 싶은 팀원."|
|김성민|실무 경험을 바탕으로 프로젝트를 다른 시야로 보며 세세한 부분들을 놓치지 않도록 잡아주셨습니다. 특히 규칙 없이 나열되어 있던 파일들을 잘 분류해 주셨습니다.|
|서민종|프로그래밍적 접근 방식이 훌륭하시고 최적의 결과를 위해 항상 고민하는 모습이 인상적이었습니다. 또한 팀원들에게 적극적으로 피드백 해주셔서 프로젝트를 진행함에 있어 큰 도움이 되었습니다|

|김성민|회고 내용--------------- 더미 데이터 입니다 본인 내용 작석하고 본인 이름 괄호 안에 * 달아두면 수정본이라고 알아보겠습니다|
|:---:|-|
|이혜영*|깃허브를 이번 프로젝트에서 엄청 썼음에도불구하고 큰 문제가 생기지 않았던 것은 모두 성민허브님의 꼼꼼함 덕분이라고 생각합니다! 특힌 PR을 날리거나 브랜치생성시 미리 양식을 정해주시고 틀을 잡아주셔서 좋은 결과물이 나올 수 있었다고 생각합니다. 무엇보다 저희의 주요 기능이 멘토링이다보니 멘토링 부분의 로직을 꼼꼼하게 짜주셔서 감사합니다!|
|한석현*|프로젝트의 가장 메인 기능인 멘토링과 관련된 부분을 담당하여 개발하였으며, 능숙은 협업툴 사용과 분석 능력으로 팀원들의 깃허브 병합 문제 처리나 코드 문제들을 해결하는데 큰 기여를 해주셨습니다 "협업 능력을 가장 닮고 싶은 팀원."|
|이준규*|전공자로서 많은 경험과 지식을 가지고 있음에도 불구하고 회의할 때 항상 마지막에 의견을 제시한다. 팀원들의 의견을 언제나 긍정적으로 수용하려는 태도를 가지고 있다. 만약 팀원의 의견에 문제점이 있다면 충분히 들어보고 고민한 후에 피드백을 해주는 것을 보며 배울 점이 많다고 생각하였다. 꼼꼼하고 섬세한 성격을 지니고 있어 깃허브를 포함한 여러 문서 작업과 DA# 논리모델링 작업의 시작과 끝을 도맡아 진행해줬다. 귀찮은 일임에도 먼저 나서서 해주신 것에 큰 감사함을 느낀다. 우리 프로젝트의 메인 기능인 멘토링 도메인을 문제 없이 잘 진행해주었다. 작업량도 많고 여러 테이블이 연결되어 있어 힘들었을 텐데 묵묵하게 끝까지 열심히 하는 모습이 멋있었다.|
|서민종|프로그래밍적 접근 방식이 훌륭하시고 최적의 결과를 위해 항상 고민하는 모습이 인상적이었습니다. 또한 팀원들에게 적극적으로 피드백 해주셔서 프로젝트를 진행함에 있어 큰 도움이 되었습니다 |

|서민종|회고 내용--------------- 더미 데이터 입니다 본인 내용 작석하고 본인 이름 괄호 안에 * 달아두면 수정본이라고 알아보겠습니다|
|:---:|-|
|이혜영*|이번에  SPRING SECURITY라는 가장 큰 임무를 맡게 되셨는데 처음엔 굉장히 막막해하셨지만, 끝까지 포기하지 않고 전날 새벽까지 붙잡아 주셔서 결국 완성도 높은 프로젝트를 만들 수 있었다고 생각합니다. 또한 DB 모델링도 엄청 꼼꼼하게 해주시고, 예외상황같은 것도 엄청 생각해주신 덕분에 큰 문제 없이 지나갈 수 있었습니다!! 감사합니다.|
|한석현*|비전공자임에도 불구하고 다들 기피하던 spring security 부분을 맡아 개발해 주셨으며, 뛰어난 프로그래밍 능력과 이해력으로 기능 구현을 성공적으로 해주셨습니다. MSA와 sping security를 적용하여 결과물을 확인 할 수 있었던 데에 가장 큰 기여를 한 것 같습니다. "이해력을 가장 닮고 싶은 팀원."|
|이준규*|부트캠프에서 만난 사람 중 가장 놀라운 재능을 갖고 있다고 생각한다. 비전공자에 부트캠프 이전 코딩 경험이 없음에도 불구하고 높은 이해력과 실력을 지니고 있다. 이번 프로젝트에서 가장 핵심이었던 회원가입/로그인 파트를 혼자 맡아서 고군분투 하는 모습이 멋있었다. 초반 DDD, ERD 설계 단계에서 팀내 기여도가 가장 높았다고 생각하며 Security기능까지 완벽하게 성공해내는 모습은 나에게 큰 자극이었다. 서글서글한 성격 또한 팀 분위기에 큰 도움이 되었다. 앞으로가 매우매우 기대되는 사람이다. 아마 민종님의 책임감과 지식 습득력으로 미루어 보았을 때 유능한 개발자로 성장할 것이라 감히 예상한다.|
|김성민|재치 있는 아이디어로 프로젝트의 방향성을 잡아주셨고, AI를 적극적으로 활용하여 작업을 효율적으로 진행해 주셨으며, 팀의 분위기 메이커를 담당해 프로젝트가 힘들지 않게 느껴지도록 해주셨습니다.|
