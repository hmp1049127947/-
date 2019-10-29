package com.wyu160802.service;

import com.wyu160802.base.BaseService;
import com.wyu160802.dto.BaseResult;
import com.wyu160802.entity.User;
import com.wyu160802.entity.UserPageDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
@author 黄明潘
@date 2019/10/27-11:27
*/
public interface UserService extends BaseService<User> {
    /**
     * 通过账号查找用户
     * @param number
     * @return
     */
    User queryByNumber(String number);

    /**
     * 登录
     * @param number
     * @param password
     * @return
     */
    BaseResult login(String number, String password);

    /**
     * 插入用户
     * @param user
     * @return
     */
    BaseResult add(User user);
    /**
     * 多项删除
     * @param id
     */
    void deleteMulti(String[] id);

    /**
     * 通过关键字搜索
     * @param keyword
     * @return
     */
    List<User> searchUser(String keyword);
    /**
     * 更新用户
     * @param user
     * @return
     */
    BaseResult updateUser(User user);

    /**
     * 通过手机号查找
     * @param phone
     * @return
     */
    User queryByPhone(String phone);


}
