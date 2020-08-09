package com.tencent.tars.server.servant;


import com.qq.tars.protocol.annotation.Servant;
import com.tencent.tars.server.entity.Question;
import com.tencent.tars.server.exception.Result;

import java.util.List;

@Servant
public interface QuestionServant {
  Result addQuestion(String qContent, String tag, String qTitle, String category,String uid);

  Result updateQuestion(String qContent, Long qid, String qTitle);

  Result deleteQuestion(Long qid);

  Result searchQuestions(String keyword);

  Question searchOneQuestion(Long qid);

  List<Question> listAllQuestions();

  Result searchQuestionsByUid(String uid);

  Result searchAuditsByQid(Long qid);

  Result updateAuditsByQid(Long qid, String uid);
}
