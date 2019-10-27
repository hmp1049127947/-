package com.wyu160802.base;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 黄明潘
 * @date 2019/10/25-11:22
 */
public abstract class BaseServiceImpl<T extends BaseEntity, D extends BaseDao<T>> implements BaseService<T>{
    @Autowired
    protected D dao;

    @Override
    public List<T> getAll() {
        return dao.getAll();
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(T entity) {
        return dao.insert(entity);
    }

    @Override
    public int insertSelective(T entity) {
        return dao.insertSelective(entity);
    }

    @Override
    public T selectByPrimaryKey(Integer id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(T entity) {
        return dao.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int updateByPrimaryKey(T entity) {
        return dao.updateByPrimaryKey(entity);
    }
}
