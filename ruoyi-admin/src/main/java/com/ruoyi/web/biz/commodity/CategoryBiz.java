package com.ruoyi.web.biz.commodity;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.erp.domain.commodity.Category;
import com.ruoyi.erp.service.commodity.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author 10525
 */
@Service
public class CategoryBiz {

    @Autowired
    private ICategoryService categoryService;

    /**
     * @param category
     * @return boolean
     * @author 10525
     * @date 2021/6/7 14:11
     * description 保存或新增仓库信息
     */
    public boolean insertOrUpdateWarehouse(Category category) throws Exception {
        try {
            String errorMsg = this.getIsExist(category);
            if (StringUtils.isNotEmpty(errorMsg)) {
                throw new Exception(errorMsg);
            }
            if (StringUtils.isEmpty(category.getId())) {
                category.setCreateBy(SecurityUtils.getUsername());
                categoryService.insert(category);
            } else {
                Category categoryDb = categoryService.get(category.getId());
                BeanUtils.copyBeanProp(categoryDb, category);

                category.setUpdateBy(SecurityUtils.getUsername());
                categoryService.update(categoryDb);
            }
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 检查是否存在
     *
     * @param category
     * @return
     */
    public String getIsExist(Category category) {
        String name = category.getName();

        Category w = new Category();
        w.setId(category.getId());
        w.setName(name);
        if (null != categoryService.getUnique(w)) {
            return "新增'" + w.getName() + "'失败，名称已存在";
        }
        return null;
    }
}
