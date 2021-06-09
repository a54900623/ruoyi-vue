package com.ruoyi.erp.mapper.commodity;

import com.ruoyi.common.core.dao.BaseDao;
import com.ruoyi.erp.domain.commodity.Category;
import org.springframework.stereotype.Repository;

/**
 * @Classname CategoryMapper
 * @Description 商品分类
 * @Date 2021/6/7 14:19
 * @Created by 10525
 */
@Repository
public interface CategoryMapper extends BaseDao<Category> {
    /**
     * @param categoryId 分类id
     * @return boolean
     * @author 10525
     * @date 2021/6/7 17:06
     * description 查询该分类是否有子级
     */
    int hasChildren(String categoryId);
}
