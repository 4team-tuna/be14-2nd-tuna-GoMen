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
    <img src="https://github.com/user-attachments/assets/597bd467-02ee-4a8e-a475-96dc5b2de964">
   <img src="" >
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
|한석현|언제나 프로젝트를 고민하시는게 눈에 보였어요. 전체적인 진행 상황을 이끌고 나가면서 팀원들의 역할을 적절히 분배하신 덕분에 프로젝트가 원활히 진행된 것 같습니다!|
|이준규|프로젝트 전반을 안정적으로 관리하며 팀원들이 목표를 명확히 이해하고 협업할 수 있도록 도왔다. 진행 상황을 꼼꼼히 정리하고 방향성을 제시해 팀워크가 원활히 이루어질 수 있었다. 열정적으로 문제를 해결하려는 태도가 인상적이었다.따로 팀장 역할을 맡은 건 아니었지만, 그럼에도 먼저 나서서 프로젝트를 이끌어 주어, 프로젝트가 원활히 진행되는데 큰 도움이 되었습니다. 프로젝트 전반에 걸쳐 가장 큰 역할을 하셨다고 생각합니다.|
|김성민|따로 팀장 역할을 맡은 건 아니었지만, 그럼에도 먼저 나서서 프로젝트를 이끌어 주어, 프로젝트가 원활히 진행되는데 큰 도움이 되었습니다. 프로젝트 전반에 걸쳐 가장 큰 역할을 하셨다고 생각합니다.|
|서민종|리더십이 크게 빛났던것 같습니다. 항상 프로젝트와 코드에 대해 고민하고, 프로젝트를 진행하며 놓칠수도 있는 부분을 잘 잡아주어 프로젝트가 올바른 길로 갈 수 있었습니다.|

|한석현|회고 내용--------------- 더미 데이터 입니다 본인 내용 작석하고 본인 이름 괄호 안에 * 달아두면 수정본이라고 알아보겠습니다|
|:---:|-|
|이혜영*|석현님 특유의 센스있는 입담 덕분에 쾌활하게 프로젝트가 진행되었던 것 같습니다! 그리고 다른 팀원들에게 문제가 생기면 적극적으로 함께 문제를 고민해주는 모습이 인상깊었습니다. 특히나 DB모델링과 더미데이터 생성, 그리고 저희만의 특별한 신고기능을 만들 수 있었던 것은 모두 석현님 덕분이라고 생각합니다! 마지막으로, 끼끼 잘키우세요~|
|이즌규|프로젝트의 큰 흐름을 정확히 이해하고 기능 테스트에 필요한 더미 데이터 생성을 책임감 있게 수행했다. 팀원들 간의 오해를 바로잡아주며 협업 과정에서 부족했던 부분을 자연스럽게 메워줬다. 실질적인 피드백과 섬세한 조율이 돋보였다.|
|김성민|AI를 활용한 더미 데이터를 만들어 코드가 제대로 작동하는지 확인하는데 큰 도움을 주었고, 코드들의 피드백을 적극적으로 해주시며 전체적으로 팀의 윤활유 역할을 해주셨습니다.|
|서민종|기능구현과 더불어 프로젝트 전체 진행에 대한 능력이 좋으신것 같습니다. 남들이 생각하지 못한 부분까지 짚어주시고 다양한 의견으로 통해 프로젝트의 퀄리티를 향상시키는데 큰 도움이 되었습니다|

|이준규|회고 내용--------------- 더미 데이터 입니다 본인 내용 작석하고 본인 이름 괄호 안에 * 달아두면 수정본이라고 알아보겠습니다|
|:---:|-|
|이혜영*| 준규님이 항상 PR을 바로 리뷰해주시고, 빠르고 꼼꼼하게 소통해주셔서 원활하게 프로젝트를 진행할 수 있었습니다! 그리고 항상 배려해주신 덕분에 제가 이 팀에 잘 적응할 수 있었다고 생각합니다 특히나 mybatis 조회하실 때 가장 많이 맡으셨는데도 전혀 내색하지 않으시고 밤을 새서라도 다 해오시는 열정이 준규님의 본받을 부분이라고 생각합니다.|
|한석현|기능적인 부분들을 고민할 때 세심한 부분을 잘 캐치하셨던 것 같습니다. 다른 팀원들의 의견을 경청하시면서 수용할 건 수용하며 좋은 아이디어를 많이 제시해주셔서 기능 개발 과정에서 많은 도움을 받았습니다.|
|김성민|실무 경험을 바탕으로 프로젝트를 다른 시야로 보며 세세한 부분들을 놓치지 않도록 잡아주셨습니다. 특히 규칙 없이 나열되어 있던 파일들을 잘 분류해 주셨습니다.|
|서민종|프로그래밍적 접근 방식이 훌륭하시고 최적의 결과를 위해 항상 고민하는 모습이 인상적이었습니다. 또한 팀원들에게 적극적으로 피드백 해주셔서 프로젝트를 진행함에 있어 큰 도움이 되었습니다|

|김성민|회고 내용--------------- 더미 데이터 입니다 본인 내용 작석하고 본인 이름 괄호 안에 * 달아두면 수정본이라고 알아보겠습니다|
|:---:|-|
|이혜영*|깃허브를 이번 프로젝트에서 엄청 썼음에도불구하고 큰 문제가 생기지 않았던 것은 모두 성민허브님의 꼼꼼함 덕분이라고 생각합니다! 특힌 PR을 날리거나 브랜치생성시 미리 양식을 정해주시고 틀을 잡아주셔서 좋은 결과물이 나올 수 있었다고 생각합니다. 무엇보다 저희의 주요 기능이 멘토링이다보니 멘토링 부분의 로직을 꼼꼼하게 짜주셔서 감사합니다!|
|한석현|SQL 쿼리 작성에서 돋보이는 실력을 지니고 계셨어요. 오류가 발생했을 때는 문제점을 빠르게 찾아내 해결하셨고, 복잡한 프로시져 작성도 훌륭하게 해내셔서 팀 내 브레인 역할 담당이셨다고 생각합니다. |
|이준규|코드 리뷰를 꼼꼼히 진행해 프로젝트의 완성도를 높이는 데 큰 도움을 줬다. 특히 SQL 지식을 활용해 내가 미처 생각하지 못했던 아이디어들을 제시하며 프로젝트에 새로운 관점을 더했다. 논리적이고 체계적인 접근이 돋보였다.|
|서민종|프로그래밍적 접근 방식이 훌륭하시고 최적의 결과를 위해 항상 고민하는 모습이 인상적이었습니다. 또한 팀원들에게 적극적으로 피드백 해주셔서 프로젝트를 진행함에 있어 큰 도움이 되었습니다 |

|서민종|회고 내용--------------- 더미 데이터 입니다 본인 내용 작석하고 본인 이름 괄호 안에 * 달아두면 수정본이라고 알아보겠습니다|
|:---:|-|
|이혜영*|이번에  SPRING SECURITY라는 가장 큰 임무를 맡게 되셨는데 처음엔 굉장히 막막해하셨지만, 끝까지 포기하지 않고 전날 새벽까지 붙잡아 주셔서 결국 완성도 높은 프로젝트를 만들 수 있었다고 생각합니다. 또한 DB 모델링도 엄청 꼼꼼하게 해주시고, 예외상황같은 것도 엄청 생각해주신 덕분에 큰 문제 없이 지나갈 수 있었습니다!! 감사합니다.|
|한석현|팀 내에서 가장 활동적이면서 분위기를 잘 풀어내 주셨던 분이에요. 프로젝트를 진행하면서 과열된 분위기를 환기시켜 주면서 원활한 진행을 도와주셨고, 외부 자료를 참고하면서 모델링 과정에서 전체적인 틀을 잡아주셨습니다.|
|이준규|GPT를 능숙히 활용하며 작업의 효율성을 높였고, 내가 놓쳤던 기능이나 세부 사항들을 꼼꼼히 점검해 팀에 공유했다. 빠르게 누락된 부분을 파악하고 보완하며 프로젝트의 완성도 향상에 기여했다.|
|김성민|재치 있는 아이디어로 프로젝트의 방향성을 잡아주셨고, AI를 적극적으로 활용하여 작업을 효율적으로 진행해 주셨으며, 팀의 분위기 메이커를 담당해 프로젝트가 힘들지 않게 느껴지도록 해주셨습니다.|
