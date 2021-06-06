package com.ruoyi.common.core.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 服务基类
 *
 * @param <T>
 */
public interface IBaseService<T> {

    /**
     * 新增实体
     *
     * @param t 实体信息
     * @return 新增结果（true/false）
     */
    String insert(T t);


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
    boolean batchDelete(Set<String> ids);

    /**
     * 根据ID查询实体
     *
     * @param id 主键
     * @return 实体信息
     */
    T get(String id);

    /**
     * 根据实体信息查询唯一实体
     *
     * @param t 实体信息
     * @return 实体信息
     */
    T getUnique(T t);

    /**
     * 查询实体列表
     *
     * @param t 实体信息
     * @return 实体列表
     */
    List<T> list(T t);

    /**
     * 查询实体列表
     *
     * @param t      实体信息
     * @param params 参数集合
     * @return 实体列表
     */
    List<T> list(T t, Map<String, Object> params);

    /**
     * 根据主键集合批量查询列表
     *
     * @param ids    主键集合
     * @param params 参数集合
     * @return 实体列表
     */
    List<T> batchList(Set<String> ids, Map<String, Object> params);
}
