package com.tencent.tars.server.servant.Impl;

import com.qq.tars.spring.annotation.TarsServant;
import com.tencent.tars.server.dao.AnswerDao;
import com.tencent.tars.server.dao.OrderDao;
import com.tencent.tars.server.entity.Order;
import com.tencent.tars.server.exception.Result;
import com.tencent.tars.server.exception.ResultUtil;
import com.tencent.tars.server.servant.OrderServant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import java.util.Date;
import java.util.List;


@Slf4j
@Service
@TarsServant("OrderObj")
public class OrderServantImpl implements OrderServant {

  @Resource
  private OrderDao orderDao;

  public Result addOrder(Long qid,String url) {
    Date cur = new Date();
    Order order = new Order();
    order.setQid(qid);
    order.setOrder_time(cur);
    int index = orderDao.addOrder(order);
    if(index<0) {
      log.error("add order failure :(");
      return ResultUtil.error(new Result());
    } else {
      log.info("add order succ :)");
      return ResultUtil.oSucc(new Result(),order,"add");
    }
  }

  public Result payOrder(Long qid) {
    if(orderDao.searchOrderByQid(qid)==null) {
      log.error("question is not existed");
      return ResultUtil.empty(new Result());
    }
    Date cur = new Date();
    int result = orderDao.payOrder(qid,1,cur);
    Order order = orderDao.searchOrderByQid(qid);
    if(result<0) {
      log.error("pay order failure :(");
      return ResultUtil.error(new Result());
    } else {
      log.info("pay order succ :)");
      return ResultUtil.oSucc(new Result(),order,"pay");
    }
  }

  public Result refund(Long qid) {
    if(orderDao.searchOrderByQid(qid)==null) {
      log.error("question is not existed");
      return ResultUtil.empty(new Result());
    }
    int result = orderDao.refundOrder(qid,1);
    Order order = orderDao.searchOrderByQid(qid);
    if(result<0) {
      log.error("refund failure :(");
      return ResultUtil.error(new Result());
    } else {
      log.info("refund succ :)");
      return ResultUtil.oSucc(new Result(),order,"pay");
    }
  }

  public Result searchOrdersByQid(Long qid) {
    List<Order> orders = orderDao.searchOrdersByQid(qid);
    return ResultUtil.SearchSucc(new Result(),orders,"orders");

  }

}
