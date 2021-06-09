package com.ruoyi.web.controller.erp.commodity;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.annotation.RepeatSubmit;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.erp.domain.commodity.Category;
import com.ruoyi.erp.service.commodity.ICategoryService;
import com.ruoyi.web.biz.commodity.CategoryBiz;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 10525
 * @Classname SpCategoryController
 * @Description 分类
 * @Date 2021/6/7 15:30
 */
@RestController
@RequestMapping("/erp/spCategory")
public class SpCategoryController extends BaseController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private CategoryBiz categoryBiz;

    /**
     * 获取分类列表
     */
    @PreAuthorize("@ss.hasPermi('commodityBus:category:list')")
    @GetMapping("/list")
    public AjaxResult list(Category category) {
        List<Category> list = categoryService.list(category);
        return AjaxResult.success(list);
    }

    /**
     * @param categoryId 分类id
     * @return com.ruoyi.common.core.domain.AjaxResult
     * @author 10525
     * @date 2021/6/7 14:10
     * description 根据参数编号获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('commodityBus:category:query')")
    @GetMapping(value = "/{categoryId}")
    public AjaxResult getInfo(@PathVariable String categoryId) {
        if (StringUtils.isEmpty(categoryId)) {
            return AjaxResult.error("id为空");
        }
        Category category = categoryService.get(categoryId);
        if (!"0".equals(category.getParentId())) {
            Category parentCategory = categoryService.get(category.getParentId());
            category.setParentName(parentCategory.getName());
        }
        return AjaxResult.success(category);
    }

    /**
     * 新增分类
     */
    @PreAuthorize("@ss.hasPermi('commodityBus:category:add')")
    @Log(title = "分类管理", businessType = BusinessType.INSERT)
    @PostMapping
    @RepeatSubmit
    public AjaxResult add(@Validated @RequestBody Category category) {
        try {
            categoryBiz.insertOrUpdateWarehouse(category);
            return AjaxResult.success();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 修改分类
     */
    @PreAuthorize("@ss.hasPermi('commodityBus:category:edit')")
    @Log(title = "分类管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody Category category) {
        try {
            categoryBiz.insertOrUpdateWarehouse(category);
            return AjaxResult.success();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 删除分类
     */
    @PreAuthorize("@ss.hasPermi('commodityBus:category:delete')")
    @Log(title = "分类管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{categoryId}")
    public AjaxResult remove(@PathVariable String categoryId) {
        try {
            if (StringUtils.isEmpty(categoryId)) {
                return AjaxResult.error("id为空，无法删除");
            }
            if (categoryService.hasChildren(categoryId)) {
                return AjaxResult.error("存在子分类,不允许删除");
            } else {
                categoryService.delete(categoryId);
            }
            return AjaxResult.success();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
    }
}
