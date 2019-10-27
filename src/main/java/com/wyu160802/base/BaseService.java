package com.wyu160802.base;

import java.util.List;

/**
 * @author 黄明潘
 * @date 2019/10/25-11:18
 */
public interface BaseService<T extends BaseEntity> {


    /**
     * 获取全部数据
     * @return
     */
    List<T> getAll();

    /**
     * 通过主键删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);


    /**
     * 新增，插入全部字段
     * @param entity
     * @return
     */
    int insert(T entity);

    /**
     * 新增，选择性插入字段
     * @param entity
     * @return
     */
    int insertSelective(T entity);

    /**
     * 通过主键查找
     * @param id
     * @return
     */
    T selectByPrimaryKey(Integer id);

    /**
     * 更新，通过主键，选择性更新字段
     * @param entity
     * @return
     */
    int updateByPrimaryKeySelective(T entity);

    /**
     * 更新，更新全部字段
     * @param entity
     * @return
     */
    int updateByPrimaryKey(T entity);
}
