package com.tencent.tars.server.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = DefinitionException.class)
  @ResponseBody
  public Result bizExceptionHandler(DefinitionException e) {
    return ResultUtil.defineError(e);
  }

  @ExceptionHandler(value = Exception.class)
  @ResponseBody
  public Result exceptionHandler(Exception e) {
    return ResultUtil.otherError(ErrorEnum.INTERNAL_SERVER_ERROR);
  }

}
