package com.example.mybatisplusdemo.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplusdemo.common.Result;
import com.example.mybatisplusdemo.service.IMerchantQulificationService;
import com.example.mybatisplusdemo.model.domain.MerchantQulification;


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
@RequestMapping("/api/merchantQulification")
public class MerchantQulificationController {

    private final Logger logger = LoggerFactory.getLogger( MerchantQulificationController.class );

    @Autowired
    private IMerchantQulificationService merchantQulificationService;


    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result<MerchantQulification> getById(@PathVariable("id") Long id)throws
Exception {
        MerchantQulification merchantQulification = merchantQulificationService.getById(id);
        return Result.success(merchantQulification);
    }

    @PostMapping("/getByMerchantId")
    @ResponseBody
    public Result<MerchantQulification> getByMerchantId(@RequestBody MerchantQulification request) {
        Long merchantId = request.getMerchantId();
        if (merchantId == null) {
            return Result.failure("merchantId不能为空");
        }
        QueryWrapper<MerchantQulification> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("merchant_id", merchantId);
        MerchantQulification merchantQulification = merchantQulificationService.getOne(queryWrapper);

        if (merchantQulification == null) {
            return Result.failure("未找到该商户的资质信息");
        }
        return Result.success(merchantQulification);
    }
}

