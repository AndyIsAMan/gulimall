package com.atguigu.gulimall.coupon.dao;

import com.atguigu.gulimall.coupon.entity.HomeSubjectEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 *
 * @author liweilin
 * @email 1257370083@gmail.com
 * @date 2022-02-22 12:56:09
 */
@Mapper
public interface HomeSubjectDao extends BaseMapper<HomeSubjectEntity> {

}
