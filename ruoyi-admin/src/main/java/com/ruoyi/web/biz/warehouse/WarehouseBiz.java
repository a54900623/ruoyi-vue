package com.ruoyi.web.biz.warehouse;

import com.ruoyi.common.enums.YesNoStatus;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.erp.domain.warehouse.Warehouse;
import com.ruoyi.erp.service.warehouse.IWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 10525
 */
@Service
public class WarehouseBiz {
    @Autowired
    private IWarehouseService warehouseService;

    /**
     * @param warehouse
     * @return boolean
     * @author 10525
     * @date 2021/6/7 14:11
     * description 保存或新增仓库信息
     */
    public boolean insertOrUpdateWarehouse(Warehouse warehouse) throws Exception {
        try {
            String errorMsg = this.getIsExist(warehouse);
            if (StringUtils.isNotEmpty(errorMsg)) {
                throw new Exception(errorMsg);
            }
            if (StringUtils.isEmpty(warehouse.getId())) {
                warehouse.setStatus(YesNoStatus.YES.getCode());
                warehouse.setCreateBy(SecurityUtils.getUsername());
                warehouseService.insert(warehouse);
            } else {
                Warehouse warehouseDb = warehouseService.get(warehouse.getId());
                BeanUtils.copyBeanProp(warehouseDb, warehouse);

                warehouse.setUpdateBy(SecurityUtils.getUsername());
                warehouseService.update(warehouseDb);
            }
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 检查是否存在
     *
     * @param warehouse
     * @return
     */
    public String getIsExist(Warehouse warehouse) {
        String name = warehouse.getName();
        String number = warehouse.getNumber();

        Warehouse w = new Warehouse();
        w.setId(warehouse.getId());
        w.setName(name);
        w.setNumber(null);
        if (null != warehouseService.getUnique(w)) {
            return "新增参数'" + warehouse.getName() + "'失败，仓库名称已存在";
        }
        w.setName(null);
        w.setNumber(number);
        if (null != warehouseService.getUnique(w)) {
            return "新增参数'" + warehouse.getNumber() + "'失败，仓库编号已存在";
        }
        return null;
    }
}
