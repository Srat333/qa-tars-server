package com.tencent.tars.server.servant;


import com.qq.tars.protocol.annotation.Servant;
import com.tencent.tars.server.entity.Answer;

@Servant
public interface AnswerServant {
  boolean addAnswer(String a_content,Long qid);

  boolean updateAnswer(String a_content,Long aid);

  boolean comment(String comment,double score,Long aid);

  boolean deleteAnswer(Long aid);

  Answer searchOneQuestion(Long qid);
}
