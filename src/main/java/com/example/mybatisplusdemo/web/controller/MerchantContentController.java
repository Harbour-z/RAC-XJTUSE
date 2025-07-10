package com.example.mybatisplusdemo.web.controller;

import com.example.mybatisplusdemo.common.utls.SessionUtils;
import com.example.mybatisplusdemo.model.dto.ContentDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplusdemo.common.Result;
import com.example.mybatisplusdemo.service.IMerchantContentService;
import com.example.mybatisplusdemo.model.domain.MerchantContent;


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
@RequestMapping("/api/content")
public class MerchantContentController {

    private final Logger logger = LoggerFactory.getLogger( MerchantContentController.class );

    @Autowired
    private IMerchantContentService merchantContentService;


    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result<MerchantContent> getById(@PathVariable("id") Long id)throws
Exception {
        MerchantContent merchantContent = merchantContentService.getById(id);
        return Result.success(merchantContent);
    }

    @PostMapping("/merchant/publish")
    public Result<MerchantContent> publish(@RequestBody ContentDTO content){
        MerchantContent merchantContent = new MerchantContent();
        BeanUtils.copyProperties(content,merchantContent);
        // 传递内容合法性校验
        boolean res = merchantContentService.isValidContent(content);
        if(res) {
            merchantContent.setMerchantId(SessionUtils.getCurrentMerchantInfo().getId());
            merchantContentService.save(merchantContent);
        }
        return  res?Result.success(merchantContent,"内容发布成功！"):Result.failure("内容发布失败");
    }

    @DeleteMapping("/merchant/unPublish/{contentId}")
    public Result<MerchantContent> unPublish(@PathVariable Long contentId){
        // 校验是否为发布者自己删除，即合法性校验
        boolean res = merchantContentService.isValidMerchant(contentId);
        boolean fin = false;
        if(res) {
            fin = merchantContentService.removeById(contentId);
        }
        return fin ? Result.successMessage("删除内容成功！"):Result.failure("内容删除失败");
    }
}

