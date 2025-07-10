package com.example.mybatisplusdemo.model.dto;

import lombok.Data;

@Data
public class CommentDTO {
  private String username;
  private Long contentId;
  private String content;
  private Double overallRating;
  private Byte status;
  private String picture;
  private String video;
}
