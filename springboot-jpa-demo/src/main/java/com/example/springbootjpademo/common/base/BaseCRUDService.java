package com.example.springbootjpademo.common.base;

import java.io.Serializable;

/**
 * @author sh 2019/3/22 14:05
 * @version ideaIU-2018.2.5.win
 */
public interface BaseCRUDService<T,ID extends Serializable> {
    /**
     * 根据主键获取实体
     *
     * @param id 主键
     * @return 返回实体
     */
    T findOne(ID id);

    /**
     * 根据多个主键获取实体列表
     *
     * @param ids 主键集合
     * @return 实体集合
     */
    Iterable<T> findAll(Iterable<ID> ids);

    /**
     * 新增
     *
     * @param t 实体
     * @return 实体
     */
    T save(T t);

    /**
     * 批量新增
     *
     * @param entities 实体集合
     * @return 实体集合
     */
    Iterable<T> save(Iterable<T> entities);

    /**
     * 更新
     *
     * @param t 实体
     * @return 实体
     */
    T update(T t);

    /**
     * 批量更新
     *
     * @param entities 实体集合
     * @return 实体集合
     */
    Iterable<T> update(Iterable<T> entities);

    /**
     * 根据主键删除
     *
     * @param id 主键
     */
    void delete(ID id);

    /**
     * 删除
     *
     * @param t 实体
     */
    void delete(T t);

    /**
     * 批量删除
     *
     * @param entities 实体集合
     */
    void delete(Iterable<? extends T> entities);


    Iterable<T> testSpecificaiton();
}
