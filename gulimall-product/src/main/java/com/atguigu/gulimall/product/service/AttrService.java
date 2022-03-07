package com.atguigu.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.product.entity.AttrEntity;

import java.util.Map;

/**
 * 商品属性
 *
 * @author liweilin
 * @email 1257370083@gmail.com
 * @date 2022-02-22 12:07:55
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

