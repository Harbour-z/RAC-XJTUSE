package com.example.mybatisplusdemo.service.impl;

import com.example.mybatisplusdemo.common.utls.SessionUtils;
import com.example.mybatisplusdemo.model.domain.MerchantContent;
import com.example.mybatisplusdemo.mapper.MerchantContentMapper;
import com.example.mybatisplusdemo.model.dto.ContentDTO;
import com.example.mybatisplusdemo.service.IMerchantContentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * <p>
 * 商家内容 服务实现类
 * </p>
 *
 * @author hxy
 * @since 2025-07-08
 */
@Service
public class MerchantContentServiceImpl extends ServiceImpl<MerchantContentMapper, MerchantContent> implements IMerchantContentService {

  @Autowired
  private MerchantContentMapper merchantContentMapper;

  @Override
  public boolean isValidContent(ContentDTO content) {
    boolean res = !content.getTitle().isEmpty() && !content.getContent().isEmpty() && !(content.getContentType() ==null);
    return res;
  }

  @Override
  public boolean isValidMerchant(Long contentId) {
    MerchantContent merchantContent = merchantContentMapper.selectById(contentId);
    return Objects.equals(merchantContent.getMerchantId(), SessionUtils.getCurrentMerchantInfo().getId());
  }
}
