package com.ruoyi.erp.domain.commodity;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Category
 * @Description 商品分类
 * @Date 2021/6/7 12:59
 * @Created by 10525
 */
public class Category extends BaseEntity {
    // 父id
    private String parentId;

    // 父名称
    private String parentName;

    // 名称
    private String name;

    // 子分类
    private List<Category> childrens = new ArrayList<>();

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public List<Category> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<Category> childrens) {
        this.childrens = childrens;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("parentId", getParentId())
                .append("name", getName())
                .toString();
    }
}
