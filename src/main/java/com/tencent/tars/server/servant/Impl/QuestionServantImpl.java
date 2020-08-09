package com.tencent.tars.server.servant.Impl;

import com.qq.tars.spring.annotation.TarsServant;
import com.tencent.tars.server.dao.QuestionDao;
import com.tencent.tars.server.entity.Question;
import com.tencent.tars.server.exception.Result;
import com.tencent.tars.server.exception.ResultUtil;
import com.tencent.tars.server.servant.QuestionServant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@TarsServant("QuestionObj")
public class QuestionServantImpl implements QuestionServant {

  @Resource
  private QuestionDao questionDao;

  @Autowired
  private ResourceLoader resourceLoader;

//  @Autowired
//  private RedisTemplate redisTemplate;


  @Override
  public Result addQuestion(String qContent, String tag, String qTitle, String category,String uid) {

    if(qContent.equals("") || tag.equals("")) {
      log.error("content empty");
      return ResultUtil.empty(new Result());
    }
    Date curDate = new Date();
    Question q = new Question();
    q.setQuestionUid(uid);
    q.setQTitle(qTitle);
    q.setQContent(qContent);
    q.setCategory(category);
    q.setTag(tag);
    q.setPrice(0.99);
    q.setCreateTime(curDate);
    int index = questionDao.addQuestion(q);
  //  redisTemplate.opsForValue().set("question"+q.getQid(),q);
    Result result = new Result();
    if(index>0) {
      log.info("add a question succ :)");
      return ResultUtil.qSucc(result,q,"add");
    } else {
      log.error("add question failed :(");
      return ResultUtil.error(result);
    }

  }



  public Result updateQuestion(String qContent, Long qid, String qTitle) {
    if(qContent.equals("")  || qid<=0 || qTitle.equals("")) {
      log.error("content empty or qid invalid");
      return ResultUtil.empty(new Result());
    }
   // Question question = (Question) redisTemplate.opsForValue().get("question"+qid);
//    if(question==null) {
//      log.info("cannot find it in redis");
    Question question = questionDao.searchOneQuestion(qid);
  //  }
    if(question==null) {
      return ResultUtil.empty(new Result());
    }
    question.setQTitle(qTitle);
    question.setQContent(qContent);
  //  redisTemplate.opsForValue().set("question"+qid,question);
    int index = questionDao.updateQuestion(question);
    Result result = new Result();
    if(index>0) {
      log.info("update succ :)");
      return ResultUtil.qSucc(result,question,"update");
    } else {
      log.error("update failed :(");
      return ResultUtil.error(result);
    }

  }

  public Result searchQuestions(String keyword) {
    if(keyword.equals("") || keyword==null) {
      return ResultUtil.empty(new Result());
    }
    List<Question> questions = questionDao.searchQuestions(keyword);
    if(questions!=null) {
      log.info("Found Something");
      return ResultUtil.SearchSucc(new Result(),questions,"question");
    } else {
      log.info("No Similar Results");
      return ResultUtil.empty(new Result());
    }

  }

  public Result searchOneQuestion(Long qid) {
    if(qid<=0) {
      return null;
    }
    Question question = questionDao.searchOneQuestion(qid);
    return ResultUtil.qSucc(new Result(),question,"search");
  }


  public Result deleteQuestion(Long qid) {
//    Question question = (Question) redisTemplate.opsForValue().get("question"+qid);
//    if(question!=null)
//      redisTemplate.delete("question"+qid);
//    if(question==null) {
//      log.info("cannot find in redis");
      Question question = questionDao.searchOneQuestion(qid);
   // }
    if(question==null)
      return ResultUtil.empty(new Result());
    //question= searchOneQuestion(qid);
    int index = questionDao.deleteQuestion(qid);
    if(index>0) {
      log.info("delete succ :)");
      return ResultUtil.qSucc(new Result(),question,"delete");
    } else {
      log.error("delete failed :(");
      return ResultUtil.error(new Result());
    }
  }


  public Result listAllQuestions() {
    return ResultUtil.SearchSucc(new Result(),questionDao.listAllQuestion(),"search");

  }

  public Result searchQuestionsByUid(String uid) {
    List<Question> questions= questionDao.searchQuestionsByUid(uid);
    if(questions!=null) {
      return ResultUtil.SearchSucc(new Result(),questions,"user's question");
    } else {
      return ResultUtil.error(new Result());
    }
  }

  public Result searchAuditsByQid(Long qid) {
    if(qid<0) {
      return ResultUtil.empty(new Result());
    }
    Question q= questionDao.searchOneQuestion(qid);
    String tmp = q.getAudits();
    String[] audit = tmp.split(",");
    List<String> audits = Arrays.asList(audit);
    log.info("audits are "+audits);
    if(q!=null) {
      return ResultUtil.SearchSucc(new Result(),audits,"search audits");
    } else {
      return ResultUtil.error(new Result());
    }
  }

  public Result updateAuditsByQid(Long qid, String uid) {
    if(qid<0) {
      return ResultUtil.empty(new Result());
    }
    Question q = questionDao.searchOneQuestion(qid);
    String audits = q.getAudits();
    if(audits==null) {
      audits=uid+",";
    } else
      audits+=uid+",";
    log.info("update audits "+audits);
    int index = questionDao.updateAudits(qid,audits);
    if(index>0) {
      return ResultUtil.SearchSucc(new Result(),Arrays.asList(audits.split(",")),"update audits");
    } else {
      return ResultUtil.error(new Result());
    }
  }

  public boolean uploadPicture() {
    return false;
  }

}
