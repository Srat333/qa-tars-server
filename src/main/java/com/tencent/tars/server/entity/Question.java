package com.tencent.tars.server.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Setter
@Getter
@ToString
@NoArgsConstructor
public class Question implements Serializable {

  private Long qid;

  private String questionUid;

  private String qTitle;

  private String qContent;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date createTime;

  private String pid;

  private String category;

  private String tag;

  private double price;

  private String audits;



}
