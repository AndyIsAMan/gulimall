package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.PaymentInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 支付信息表
 *
 * @author liweilin
 * @email 1257370083@gmail.com
 * @date 2022-02-22 13:27:23
 */
@Mapper
public interface PaymentInfoDao extends BaseMapper<PaymentInfoEntity> {

}
