package com.ruoyi.erp.service.commodity.impl;

import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.erp.domain.commodity.Category;
import com.ruoyi.erp.mapper.commodity.CategoryMapper;
import com.ruoyi.erp.service.commodity.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Classname CategoryServiceImpl
 * @Description 商品分类
 * @Date 2021/6/7 14:20
 * @Created by 10525
 */
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public String insert(Category category) {
        BaseEntity.preInsert(category);
        boolean result = categoryMapper.insert(category);
        if (result) {
            return category.getId();
        }
        return null;
    }

    @Override
    public boolean update(Category category) {
        return categoryMapper.update(category);
    }

    @Override
    public boolean delete(String id) {
        if (StringUtils.isNotEmpty(id)) {
            return categoryMapper.delete(id);
        }
        return false;
    }

    @Override
    public boolean batchDelete(Set<String> ids) {
        if (!CollectionUtils.isEmpty(ids)) {
            return categoryMapper.batchDelete(ids);
        }
        return false;
    }

    @Override
    public Category get(String id) {
        if (!StringUtils.isEmpty(id)) {
            return categoryMapper.get(id);
        }
        return null;
    }

    @Override
    public Category getUnique(Category category) {
        return categoryMapper.getUnique(category);
    }

    @Override
    public List<Category> list(Category category) {
        return categoryMapper.list(category);
    }

    @Override
    public List<Category> list(Category category, Map<String, Object> params) {
        return categoryMapper.conditionList(category, params);
    }

    @Override
    public List<Category> batchList(Set<String> ids, Map<String, Object> params) {
        return categoryMapper.batchList(ids, params);
    }


    @Override
    public boolean hasChildren(String categoryId) {
        int count = categoryMapper.hasChildren(categoryId);
        return count > 0 ? true : false;
    }
}
