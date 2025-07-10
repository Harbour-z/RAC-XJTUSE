package com.example.mybatisplusdemo.model.dto;

import lombok.Data;

@Data
public class ContentDTO {
  private String title;
  private String content;
  private Byte contentType;
  private String picture;
  private String video;
}
