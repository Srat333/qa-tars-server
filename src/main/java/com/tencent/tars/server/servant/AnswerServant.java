package com.tencent.tars.server.servant;


import com.qq.tars.protocol.annotation.Servant;
import com.tencent.tars.server.entity.Answer;
import com.tencent.tars.server.exception.*;

@Servant
public interface AnswerServant {



  Result addAnswer(Long qid, String aContent, String uid);

  Result updateAnswer(String content, Long aid);

  Result comment(String comment, Long aid, double score);

  Result deleteAnswer(Long aid);

  Answer searchOneQuestion(Long qid);

  Answer searchOneAnswer(Long aid);

  Result searchAnswersByUid(String uid);


}
