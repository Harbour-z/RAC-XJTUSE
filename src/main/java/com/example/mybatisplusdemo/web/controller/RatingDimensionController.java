package com.example.mybatisplusdemo.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplusdemo.common.Result;
import com.example.mybatisplusdemo.service.IRatingDimensionService;
import com.example.mybatisplusdemo.model.domain.RatingDimension;


/**
 *
 *  前端控制器
 *
 *
 * @author hxy
 * @since 2025-07-08
 * @version v1.0
 */
@RestController
@RequestMapping("/api/ratingDimension")
public class RatingDimensionController {

    private final Logger logger = LoggerFactory.getLogger( RatingDimensionController.class );

    @Autowired
    private IRatingDimensionService ratingDimensionService;


    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result<RatingDimension> getById(@PathVariable("id") Long id)throws
Exception {
        RatingDimension ratingDimension = ratingDimensionService.getById(id);
        return Result.success(ratingDimension);
    }
}

