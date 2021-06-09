package com.ruoyi.erp.service.commodity.impl;

import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.erp.domain.commodity.Commodity;
import com.ruoyi.erp.mapper.commodity.CommodityMapper;
import com.ruoyi.erp.service.commodity.ICommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Classname CommodityServiceImpl
 * @Description 商品
 * @Date 2021/6/7 14:18
 * @Created by 10525
 */
@Service
public class CommodityServiceImpl implements ICommodityService {
    @Autowired
    private CommodityMapper commodityMapper;

    @Override
    public String insert(Commodity commodity) {
        BaseEntity.preInsert(commodity);
        boolean result = commodityMapper.insert(commodity);
        if (result) {
            return commodity.getId();
        }
        return null;
    }

    @Override
    public boolean update(Commodity commodity) {
        return commodityMapper.update(commodity);
    }

    @Override
    public boolean delete(String id) {
        if (StringUtils.isNotEmpty(id)) {
            return commodityMapper.delete(id);
        }
        return false;
    }

    @Override
    public boolean batchDelete(Set<String> ids) {
        if (!CollectionUtils.isEmpty(ids)) {
            return commodityMapper.batchDelete(ids);
        }
        return false;
    }

    @Override
    public Commodity get(String id) {
        if (!StringUtils.isEmpty(id)) {
            return commodityMapper.get(id);
        }
        return null;
    }

    @Override
    public Commodity getUnique(Commodity commodity) {
        return commodityMapper.getUnique(commodity);
    }

    @Override
    public List<Commodity> list(Commodity commodity) {
        return commodityMapper.list(commodity);
    }

    @Override
    public List<Commodity> list(Commodity commodity, Map<String, Object> params) {
        return commodityMapper.conditionList(commodity, params);
    }

    @Override
    public List<Commodity> batchList(Set<String> ids, Map<String, Object> params) {
        return commodityMapper.batchList(ids, params);
    }
}
