package com.ruoyi.erp.service.commodity;

import com.ruoyi.common.core.service.IBaseService;
import com.ruoyi.erp.domain.commodity.Category;

/**
 * @Classname ICategoryService
 * @Description 商品分类
 * @Date 2021/6/7 14:19
 * @Created by 10525
 */
public interface ICategoryService extends IBaseService<Category> {
    /**
     * @param categoryId 分类id
     * @return boolean
     * @author 10525
     * @date 2021/6/7 17:06
     * description 查询该分类是否有子级
     */
    boolean hasChildren(String categoryId);
}
