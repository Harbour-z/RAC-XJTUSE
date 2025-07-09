package com.example.mybatisplusdemo.model.dto;

import com.example.mybatisplusdemo.model.domain.Shop;
import lombok.Data;

@Data
public class ShopDTO {
  private Integer categoryId;
  private String address;
  private String merchantName;
  private Long logitude;
  private Long latitude;
  private Long avgRating;
  private String description;
  private String cover;
  private String priceRange;
  private String tag;
  private Long username;
}
