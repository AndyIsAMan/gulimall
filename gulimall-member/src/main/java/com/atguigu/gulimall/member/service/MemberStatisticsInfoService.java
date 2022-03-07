package com.atguigu.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.member.entity.MemberStatisticsInfoEntity;

import java.util.Map;

/**
 * ??Աͳ????Ϣ
 *
 * @author liweilin
 * @email 1257370083@gmail.com
 * @date 2022-02-22 13:22:46
 */
public interface MemberStatisticsInfoService extends IService<MemberStatisticsInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

