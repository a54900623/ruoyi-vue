package com.ruoyi.web.controller.erp;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.annotation.RepeatSubmit;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.erp.domain.warehouse.Warehouse;
import com.ruoyi.erp.service.warehouse.IWarehouseService;
import com.ruoyi.web.biz.WarehouseBiz;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 仓库
 */
@RestController
@RequestMapping("/erp/warehouse")
public class WarehouseController extends BaseController {

    @Autowired
    private IWarehouseService warehouseService;

    @Autowired
    private WarehouseBiz warehouseBiz;

    /**
     * 获取仓库列表
     */
    @PreAuthorize("@ss.hasPermi('warehouseBus:warehouse:list')")
    @GetMapping("/list")
    public TableDataInfo list(Warehouse warehouse) {
        startPage();
        List<Warehouse> list = warehouseService.list(warehouse);
        return getDataTable(list);
    }

    /**
     * 根据参数编号获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('warehouseBus:warehouse:query')")
    @GetMapping(value = "/{warehouseId}")
    public AjaxResult getInfo(@PathVariable String warehouseId) {
        if (StringUtils.isEmpty(warehouseId)) {
            return AjaxResult.error("id为空");
        }
        return AjaxResult.success(warehouseService.get(warehouseId));
    }

    /**
     * 新增仓库
     */
    @PreAuthorize("@ss.hasPermi('warehouseBus:warehouse:add')")
    @Log(title = "仓库管理", businessType = BusinessType.INSERT)
    @PostMapping
    @RepeatSubmit
    public AjaxResult add(@Validated @RequestBody Warehouse warehouse) {
        try {
            warehouseBiz.insertOrUpdateWarehouse(warehouse);
            return AjaxResult.success();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 修改仓库
     */
    @PreAuthorize("@ss.hasPermi('warehouseBus:warehouse:edit')")
    @Log(title = "仓库管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody Warehouse warehouse) {
        try {
            warehouseBiz.insertOrUpdateWarehouse(warehouse);
            return AjaxResult.success();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 删除仓库
     */
    @PreAuthorize("@ss.hasPermi('warehouseBus:warehouse:delete')")
    @Log(title = "仓库管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{warehouseIds}")
    public AjaxResult remove(@PathVariable String warehouseIds) {
        try {
            if (StringUtils.isEmpty(warehouseIds)) {
                return AjaxResult.error("id为空，无法删除");
            }
            if (StringUtils.contains(warehouseIds, ',')) {
                String[] idsArray = warehouseIds.split(",");
                warehouseService.batchDelete(new HashSet<>(Arrays.asList(idsArray)));
            } else {
                warehouseService.delete(warehouseIds);
            }
            return AjaxResult.success();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
    }
}
