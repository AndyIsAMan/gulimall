package com.atguigu.gulimall.product.dao;

import com.atguigu.gulimall.product.entity.CommentReplayEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价回复关系
 *
 * @author liweilin
 * @email 1257370083@gmail.com
 * @date 2022-02-22 12:07:55
 */
@Mapper
public interface CommentReplayDao extends BaseMapper<CommentReplayEntity> {

}
