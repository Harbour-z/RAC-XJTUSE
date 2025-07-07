package com.example.mybatisplusdemo.web.controller;

import com.example.mybatisplusdemo.mapper.UserMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplusdemo.common.Result;
import com.example.mybatisplusdemo.service.IMerchantService;
import com.example.mybatisplusdemo.model.domain.Merchant;


/**
 *
 *  前端控制器
 *
 *
 * @author hxy
 * @since 2025-07-07
 * @version v1.0
 */
@RestController
@RequestMapping("/api/merchant")
public class MerchantController {

    private final Logger logger = LoggerFactory.getLogger( MerchantController.class );

    @Autowired
    private IMerchantService merchantService;
    @Autowired
    private UserMapper userMapper;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result<Merchant> getById(@PathVariable("id") Long id)throws Exception {
        Merchant merchant = merchantService.getById(id);
        return Result.success(merchant);
    }

    @PostMapping("login")
    public Result login(@RequestBody Merchant merchant) throws Exception {
        Merchant login = merchantService.login(merchant);
        return Result.success(login);
    }
}

