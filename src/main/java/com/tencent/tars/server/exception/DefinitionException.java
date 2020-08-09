package com.tencent.tars.server.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DefinitionException extends RuntimeException {


  public Integer errorCode;

  protected String errorMsg;

}
