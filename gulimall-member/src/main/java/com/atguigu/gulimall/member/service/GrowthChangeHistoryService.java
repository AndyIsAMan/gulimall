package com.atguigu.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.member.entity.GrowthChangeHistoryEntity;

import java.util.Map;

/**
 * ?ɳ?ֵ?仯??ʷ??¼
 *
 * @author liweilin
 * @email 1257370083@gmail.com
 * @date 2022-02-22 13:22:46
 */
public interface GrowthChangeHistoryService extends IService<GrowthChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

