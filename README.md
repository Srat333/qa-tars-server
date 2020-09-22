# Program Introduction
Question and Answer Community Website

## Function

- [x] User Login
- [x] Ask Questions
- [x] User Profile
- [x] Search Answers
- [x] Answer Questions
- [x] Audit
- [x] Comment
- [x] Details Page
- [x] History Orders
  * unpaid
  * uncommented
  * finished
- [x] Check Answerer Details
  * Questioners' comment
  * Show status (receive new questions)
- [ ] Uniform UI
- [ ] Add New Functions
  * Follow and Subscribe
  * Limited Time Asking
- [ ] Released
- [ ] Integrated WeChat Pay API


## UI example
![ui](https://github.com/Srat333/mini-program-frontend/blob/master/ui.png)
## 

![architecture](https://github.com/Srat333/qa-tars-client/blob/master/tarsproject.jpg)

## Code Directory
### frontend
```
├── README.md
├── api
│   └── request.js
├── app.js
├── app.json
├── app.wxss
├── images
│   ├── .DS_Store
│   ├── avatar1.png
│   ├── avatar2.png
│   ├── camera.png
│   ├── delete.png
│   ├── home.png
│   ├── people1.jpeg
│   ├── people2.jpeg
│   ├── profile.png
│   ├── star0.png
│   ├── star1.png
│   └── testOrderPage.jpg
├── pages
│   ├── .DS_Store
│   ├── answer
│   │   ├── answer.js
│   │   ├── answer.json
│   │   ├── answer.wxml
│   │   └── answer.wxss
│   ├── commentList
│   │   ├── commentList.js
│   │   ├── commentList.json
│   │   ├── commentList.wxml
│   │   └── commentList.wxss
│   ├── evaluation
│   │   ├── evaluation.js
│   │   ├── evaluation.json
│   │   ├── evaluation.wxml
│   │   └── evaluation.wxss
│   ├── index
│   │   ├── index.js
│   │   ├── index.json
│   │   ├── index.wxml
│   │   └── index.wxss
│   ├── logs
│   │   ├── logs.js
│   │   ├── logs.json
│   │   ├── logs.wxml
│   │   └── logs.wxss
│   ├── profile
│   │   ├── profile.js
│   │   ├── profile.json
│   │   ├── profile.wxml
│   │   └── profile.wxss
│   ├── question
│   │   ├── question.js
│   │   ├── question.json
│   │   ├── question.wxml
│   │   └── question.wxss
│   ├── questionDetail
│   │   ├── questionDetail.js
│   │   ├── questionDetail.json
│   │   ├── questionDetail.wxml
│   │   └── questionDetail.wxss
│   ├── questionList
│   │   ├── questionList.js
│   │   ├── questionList.json
│   │   ├── questionList.wxml
│   │   └── questionList.wxss
│   └── userAccount
│       ├── userAccount.js
│       ├── userAccount.json
│       ├── userAccount.wxml
│       └── userAccount.wxss
├── project.config.json
├── sitemap.json
└── utils
    ├── .DS_Store
    ├── common.util.js
    ├── object.util.js
    ├── promise.util.js
    └── util.js
```
### Tars-server
```
.
├── pom.xml
├── src
│   └── main
│       ├── java
│       │   └── com
│       │       └── tencent
│       │           └── tars
│       │               └── server
│       │                   ├── Application.java
│       │                   ├── dao
│       │                   │   ├── AnswerDao.java
│       │                   │   ├── OrderDao.java
│       │                   │   └── QuestionDao.java
│       │                   ├── entity
│       │                   │   ├── Answer.java
│       │                   │   ├── Order.java
│       │                   │   └── Question.java
│       │                   ├── exception
│       │                   │   ├── DefinitionException.java
│       │                   │   ├── ErrorEnum.java
│       │                   │   ├── GlobalExceptionHandler.java
│       │                   │   ├── Result.java
│       │                   │   └── ResultUtil.java
│       │                   └── servant
│       │                       ├── AnswerServant.java
│       │                       ├── Impl
│       │                       │   ├── AnswerServantImpl.java
│       │                       │   ├── OrderServantImpl.java
│       │                       │   └── QuestionServantImpl.java
│       │                       ├── OrderServant.java
│       │                       └── QuestionServant.java
│       └── resources
│           ├── application.properties
│           └── hello.tars
└── tree.text
```
### Tars-client
```
.
├── pom.xml
├── src
│   └── main
│       ├── java
│       │   └── com
│       │       └── tencent
│       │           └── tars
│       │               └── client
│       │                   ├── Application.java
│       │                   ├── exception
│       │                   │   └── Result.java
│       │                   ├── testclient
│       │                   │   ├── AnswerServant.java
│       │                   │   ├── Impl
│       │                   │   │   ├── AnswerServantImpl.java
│       │                   │   │   ├── OrderServantImpl.java
│       │                   │   │   └── QuestionServantImpl.java
│       │                   │   ├── OrderServant.java
│       │                   │   └── QuestionServant.java
│       │                   └── testserver
│       │                       ├── AnswerPrx.java
│       │                       ├── OrderPrx.java
│       │                       └── QuestionPrx.java
│       └── resources
│           ├── application.properties
│           ├── client.tars
│           └── hello.tars
└── tree.text
```
# Related
## Frontend
https://github.com/Srat333/mini-program-frontend
## Tars-Server
https://github.com/Srat333/qa-tars-server.git
## Tars-Client
https://github.com/Srat333/qa-tars-client.git
