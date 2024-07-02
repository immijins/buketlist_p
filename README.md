## 🖥Buketlist 웹 사이트 제작
Spring을 활용한 게시판 CRUD로 제작한 버킷리스트 사이트입니다.

## 📂프로젝트 소개
버킷리스트를 기록할 수 있는 게시판에 글 추가, 작성한 글을 수정, 작성한 글 삭제 기능을 구현하였습니다.
버킷리스트가 완료되었는지 체크를 할 수 있도록 추가하였고, 완료된 사항에 따라 성공!/대기중으로 표시되도록 taglib를 구현하였습니다.
디자인은 부트스트랩을 사용하여 작업하였습니다.
- 개발기간 : 2일(기획, 구현)
- 참여도 : 100%(개인프로젝트)

## ⚙기술스택
**Tool :** IntelliJ IDE

**Framework/Library :** Spring, Bootstrap, MyBatis

**DataBase :** MariraDB

## 📊주요 기능
- 게시판 : 게시글 생성, 읽기, 수정, 삭제 / 버킷리스트 달성여부 체크 및 표시 / 게시글 페이징 / 현재 총 개수 표시

## 🔗DB
ERD

![DB](https://github.com/immijins/buketlist_p/blob/main/db.png)

## 📋API 설계 구조

![API](https://github.com/immijins/buketlist_p/blob/main/api.png)

## 💻구현 화면
- 버킷리스트 화면
![리스트](https://github.com/immijins/buketlist_p/blob/main/buket_list.png)

- 버킷리스트 추가
![추가](https://github.com/immijins/buketlist_p/blob/main/buket_add.png)

- 버킷리스트 수정
![수정](https://github.com/immijins/buketlist_p/blob/main/buket_modify.png)


## 📌회고 및 피드백
Spring은 초기 세팅이 어려운 부분이 있었는데 몇 번 프로젝트를 반복하다 보니 어느 정도 익숙해지는 것 같습니다.
간단한 CRUD로 버킷리스트를 작업하여 조금 아쉬운 부분이 있어서 쇼핑몰 등 기능을 다양하게 사용할 수 있는 Spring 프로젝트를 만들어보고 싶다는 생각이 들었습니다.
부트스트랩을 통해 CSS 작업을 하니 간편한 점이 좋았고, 더 많은 구현은 어려워 아쉬운 부분이 있어 부트스트랩을 기초로 CSS 작업 파일을 만들어 봐도 괜찮을 것 같다는 생각이 들었습니다.
