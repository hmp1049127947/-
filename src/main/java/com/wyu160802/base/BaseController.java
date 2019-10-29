package com.wyu160802.base;

import com.alibaba.fastjson.JSON;
import com.wyu160802.dto.BaseResult;
import com.wyu160802.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author 黄明潘
 * @date 2019/10/27-22:35
 */
public abstract class BaseController<T extends BaseEntity, S extends BaseService<T>> {

    /**
     * 注入业务逻辑层
     */
    @Autowired
    protected S service;

    /**
     * 数据列表
     * @return
     */
    @PostMapping(value = "lists")
    @ResponseBody
    public List<T> lists() {
        return service.getAll();
    }

    @PostMapping(value = "update")
    @ResponseBody
    public BaseResult update(T entity) {
        return BaseResult.CrudMsg(service.updateByPrimaryKey(entity), "更新");
    }


    @PostMapping(value = "add")
    @ResponseBody
    public BaseResult add(T entity) {
        return BaseResult.CrudMsg(service.insert(entity), "新增");
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    public abstract BaseResult delete(int id);

    /**
     * 获取页面
     * @return
     */
    public abstract String page();
}
