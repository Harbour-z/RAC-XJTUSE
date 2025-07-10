package com.example.mybatisplusdemo.model.dto;


import lombok.Data;

@Data
public class SearchShopDTO {
    private Integer pageNum = 1;
    private Integer pageSize = 10;
    private Integer categoryId;
    private Double avgRating;
}
