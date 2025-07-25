package com.example.mybatisplusdemo.model.dto;

import com.example.mybatisplusdemo.model.domain.Shop;
import lombok.Data;

import java.util.List;

@Data
public class ShopDTO {
//  店面注册的前端传参
  private String address;
  private String description;
  private Double latitude;
  private String licenseNumber ;
  private Double longitude;
  private String merchantName;
  private Integer categoryId;
  private String username;
  private String license;//许可证图片
  private String health ;//卫生许可证
  private List<String> otherPermit;//其它许可证


  private Long avgRating;
  private String cover;
  private String priceRange;
  private String tag ;
}
