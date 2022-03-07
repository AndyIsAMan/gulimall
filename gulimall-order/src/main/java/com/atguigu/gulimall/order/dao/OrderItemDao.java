package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 *
 * @author liweilin
 * @email 1257370083@gmail.com
 * @date 2022-02-22 13:27:23
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {

}
