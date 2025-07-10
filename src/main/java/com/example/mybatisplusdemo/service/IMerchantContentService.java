package com.example.mybatisplusdemo.service;

import com.example.mybatisplusdemo.model.domain.MerchantContent;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplusdemo.model.dto.ContentDTO;

/**
 * <p>
 * 商家内容 服务类
 * </p>
 *
 * @author hxy
 * @since 2025-07-08
 */
public interface IMerchantContentService extends IService<MerchantContent> {

  boolean isValidContent(ContentDTO content);

  boolean isValidMerchant(Long contentId);
}
