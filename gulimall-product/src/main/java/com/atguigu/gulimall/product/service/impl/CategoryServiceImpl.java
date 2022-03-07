package com.atguigu.gulimall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        // 功能分析
        // 1. 查询出所有分类
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);

        // 2. 组装成父子的树形结构
        // 1. 查找一级分类
        List<CategoryEntity> levelOneMenus = categoryEntities.stream().filter((categoryItem) -> {
            return categoryItem.getParentCid() == 0;
        }).map((menu) -> {
            menu.setChildren(getChildrens(menu, categoryEntities));
            return menu;
        }).sorted((menu1, menu2) -> {
            return menu1.getSort() - menu2.getSort();
        }).collect(Collectors.toList());
        return levelOneMenus;
    }

    @Override
    public void removeMenuByIds(List<Long> asList) {
        // TODO 1 检查当前要删除的菜单是否被别的地方引用

        // 逻辑删除
        baseMapper.deleteBatchIds(asList);
    }

    /**
     * 递归查找所有菜单的子菜单
     *
     * @param entity
     * @param all
     * @return
     */
    private List<CategoryEntity> getChildrens(CategoryEntity entity, List<CategoryEntity> all) {
        List<CategoryEntity> children = all.stream().filter(categoryEntity -> {
            return categoryEntity.getParentCid() == entity.getCatId();
        }).map((item) -> {
            // 找到子菜单
            item.setChildren(getChildrens(item, all));
            return item;
        }).sorted((menu1, menu2) -> {
            // 排序
            return (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());
        }).collect(Collectors.toList());

        return children;
    }

}