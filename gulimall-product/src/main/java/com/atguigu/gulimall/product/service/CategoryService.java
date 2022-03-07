package com.atguigu.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author liweilin
 * @email 1257370083@gmail.com
 * @date 2022-02-22 12:07:55
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listWithTree();


    void removeMenuByIds(List<Long> asList);
}

