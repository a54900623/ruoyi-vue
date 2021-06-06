package com.ruoyi.common.core.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface BaseDao<T> {
    /**
     * 根据ID查询实体
     *
     * @param id 主键
     * @return 实体信息
     */
    T get(String id);

    /**
     * 根据参数查询实体
     *
     * @param t 实体信息
     * @return 实体信息
     */
    T getUnique(T t);

    /**
     * 根据参数查询数量
     *
     * @param t 实体信息
     * @return 实体信息
     */
    Long count(T t);


    /**
     * 新增实体
     *
     * @param t 实体信息
     * @return 新增结果（true/false）
     */
    boolean insert(T t);


    /**
     * 更新实体
     *
     * @param t 实体信息
     * @return 更新结果（true/false）
     */
    boolean update(T t);

    /**
     * 物理删除
     *
     * @param id 实体主键
     * @return 删除结果（true/false）
     */
    boolean delete(String id);

    /**
     * 批量物理删除
     *
     * @param ids 主键集合
     * @return 删除结果（true/false）
     */
    boolean batchDelete(@Param("ids") Set<String> ids);

    /**
     * 查询列表
     *
     * @param t 实体信息
     * @return 实体列表
     */
    List<T> list(T t);

    /**
     * 查询列表
     *
     * @param t      实体信息
     * @param params 查询参数集合
     * @return 实体列表
     */
    List<T> conditionList(@Param("model") T t, @Param("params") Map<String, Object> params);

    /**
     * 批量查询
     *
     * @param ids    id集合
     * @param params 查询参数集合
     * @return 实体列表
     */
    List<T> batchList(@Param("ids") Set<String> ids, @Param("params") Map<String, Object> params);
}
