package com.tencent.tars.server.servant;


import com.qq.tars.protocol.annotation.Servant;
import com.tencent.tars.server.exception.Result;

@Servant
public interface OrderServant {

  Result addOrder(Long qid,String url);

  Result payOrder(Long qid);

  Result refund(Long qid);

  public Result searchOrdersByQid(Long qid);

}
