package com.example.mybatisplusdemo.model.dto;

import lombok.Data;

@Data
public class CommentDTO {
  private Integer pageNum = 1;
  private Integer pageSize = 10;
  private Long userId;
  private Long merchantId;
  private String username;
  private Long contentId;
  private String content;
  private Double overallRating;
  private Byte status;
  private String picture;
  private String video;
}
