package com.atguigu.gulimall.coupon.dao;

import com.atguigu.gulimall.coupon.entity.CouponHistoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券领取历史记录
 *
 * @author liweilin
 * @email 1257370083@gmail.com
 * @date 2022-02-22 12:56:09
 */
@Mapper
public interface CouponHistoryDao extends BaseMapper<CouponHistoryEntity> {

}
