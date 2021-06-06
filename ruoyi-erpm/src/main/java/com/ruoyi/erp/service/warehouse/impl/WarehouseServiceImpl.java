package com.ruoyi.erp.service.warehouse.impl;

import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.erp.domain.warehouse.Warehouse;
import com.ruoyi.erp.mapper.warehouse.WarehouseMapper;
import com.ruoyi.erp.service.warehouse.IWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 仓库
 *
 * @author 10525
 */
@Service
public class WarehouseServiceImpl implements IWarehouseService {

    @Autowired
    private WarehouseMapper warehouseMapper;

    @Override
    public String insert(Warehouse warehouse) {
        BaseEntity.preInsert(warehouse);
        boolean result = warehouseMapper.insert(warehouse);
        if (result) {
            return warehouse.getId();
        }
        return null;
    }

    @Override
    public boolean update(Warehouse warehouse) {
        return warehouseMapper.update(warehouse);
    }

    @Override
    public boolean delete(String id) {
        if (StringUtils.isNotEmpty(id)) {
            return warehouseMapper.delete(id);
        }
        return false;
    }

    @Override
    public boolean batchDelete(Set<String> ids) {
        if (!CollectionUtils.isEmpty(ids)) {
            return warehouseMapper.batchDelete(ids);
        }
        return false;
    }

    @Override
    public Warehouse get(String id) {
        if (!StringUtils.isEmpty(id)) {
            return warehouseMapper.get(id);
        }
        return null;
    }

    @Override
    public Warehouse getUnique(Warehouse warehouse) {
        return warehouseMapper.getUnique(warehouse);
    }

    @Override
    public List<Warehouse> list(Warehouse warehouse) {
        return warehouseMapper.list(warehouse);
    }

    @Override
    public List<Warehouse> list(Warehouse warehouse, Map<String, Object> params) {
        return warehouseMapper.conditionList(warehouse, params);
    }

    @Override
    public List<Warehouse> batchList(Set<String> ids, Map<String, Object> params) {
        return warehouseMapper.batchList(ids, params);
    }
}