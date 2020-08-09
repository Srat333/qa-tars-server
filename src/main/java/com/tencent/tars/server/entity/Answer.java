package com.tencent.tars.server.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


@Setter
@Getter
@ToString
@NoArgsConstructor
public class Answer implements Serializable {

  private Long aid;

  private Long qid;

  private Long answer_uid;

  private String a_content;

  private String pid;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date answer_time;

  private Double score;

  private String comment;

}
