package com.wyu160802.dao;
import com.wyu160802.entity.UserPageDto;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.wyu160802.base.BaseDao;
import com.wyu160802.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
@author 黄明潘
@date 2019/10/27-11:27
*/
@Mapper
public interface UserDao extends BaseDao<User> {
    /**
     * 通过账号查找用户
     * @param number
     * @return
     */
    User queryByNumber(@Param("number")String number);

    /**
     * 通过username查找用户
     * @param username
     * @return
     */
    List<User> queryByUsername(@Param("username")String username);

    /**
     * 通过手机号查找
     * @param phone
     * @return
     */
    User queryOneByPhone(@Param("phone")String phone);

    /**
     * 分页获取用户
     * @param leftArg
     * @param rightArg
     * @return
     */
    List<User> queryPageUsers(@Param("leftArg") int leftArg, @Param("rightArg") int rightArg);

    /**
     * 获取数据总数
     * @return
     */
    int queryUserTotal();

    /**
     * 多项删除
     * @param id
     */
    void deleteMulti(String[] id);

    /**
     * 通过关键字搜索
     * @param userPageDto
     * @return
     */
    List<User> searchUser(UserPageDto userPageDto);

    /**
     * 通过关键字搜索后的数据总数
     * @param userPageDto
     * @return
     */
    int flitTotal(UserPageDto userPageDto);

}