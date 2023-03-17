# TODO-Project

## Setting
- Springboot 2.7.9
- Java 11 version

## 기능 요구사항
- 할일 조회하기
- 할일 만들기
- 할일 수정하기
    - 할일 내용 수정 하기
    - 할일 달성 여부 체크하기
- 할일 삭제하기
- 예외 페이지 만들기

## API Info
### GET /todo
모든 할일 조회하기
- OUT<br>
  result {<br>
  {<br>
  todoNo, <br>
  todoName, <br>
  todoContent,<br>
  todoSuccess,<br>
  },<br>
  {...}<br>
  },<br>
  exception_message 
- STATUS 
  - 성공 -> 200

### GET /todo/{todoNo}
할일 상세조회 하기

- OUT <br>
  result
  <br>{<br>
  todoNo,<br>
  todoName,<br>
  todoContent,<br>
  todoSuccess<br>
  },<br>
  exception_message<br>
- STATUS
    - 200,201 -> 400
    - 성공 -> 200

### POST /todo
할일 만들기
- IN<br>
  todoName,<br>
  todoContent<br>
- OUT<br>
    result
    <br>{<br>
    todoNo,<br>
    todoName,<br>
    todoContent,<br>
    todoSuccess<br>
    },<br>
  exception_message<br>
- STATUS
    - 100,102 -> 400
    - 성공 -> 200

### PATCH /todo/{todoNo}
할일 수정하기
- IN<br>
  todoName,<br>
  todoContent,<br>
  todoSuccess<br>
- OUT<br>
  result
  <br>{<br>
  todoNo,<br>
  todoName,<br>
  todoContent,<br>
  todoSuccess<br>
  },<br>
  exception_message<br>
- STATUS
    - 100,101,102,103,200,201 -> 400
    - 성공 -> 200

### DELETE /todo/{todoNo}
할일 삭제하기
- OUT<br>
  exception_message<br>
- STATUS
    - 200,201 -> 400
    - 성공 -> 200

## Error
- HTTP_STATUS
  - 200 : 성공
  - 400 : 실패
- error code
  - 100 : todoName 누락 또는 비어있음
  - 101 : todo_contant 누락 또는 비어있음
  - 102 : todoSuccess 누락
  - 103 : 올바르지 않은 todoSuccess
  - 200 : todoNo가 일치하는 todo가 없음
  - 201 : 올바르지 않은 todoNo

## DB
mysql

### 변수 정보
- todoNo number(10) PK : 투두 고유아이디
- todoName varchar(20): 투두 이름
- todoContent varchar(100) : 투두 내용
- todoContent varchar(1) default 'N' : 투두 달성 여부 (N : 미달성, Y :달성)

## 추가 구현하면 좋은 점
- 프론트 구현
- nosql db 사용해보기
- 동기방식으로 구현 (/todo_sync~)
- TDD