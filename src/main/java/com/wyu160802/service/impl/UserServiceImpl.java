package com.wyu160802.service.impl;

import com.wyu160802.base.BaseServiceImpl;
import com.wyu160802.dto.BaseResult;
import com.wyu160802.entity.UserPageDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.wyu160802.entity.User;
import com.wyu160802.dao.UserDao;
import com.wyu160802.service.UserService;

import java.util.List;

/**
@author 黄明潘
@date 2019/10/27-11:27
*/
@Service
public class UserServiceImpl extends BaseServiceImpl<User,UserDao> implements UserService{


    @Override
    public User queryByNumber(String number) {
        return dao.queryByNumber(number);
    }

    @Override
    public BaseResult login(String number, String password) {
        BaseResult baseResult = BaseResult.fail();
        //通过账号获取用户
        User user = dao.queryByNumber(number);
        //如果查到该用户
        if (user != null) {
            //如果密码匹配，登录成功
            if (user.getPassword().equals(password)) {
                baseResult = BaseResult.success(user);
            } else {
                baseResult.setMessage("登录失败，密码错误");
            }
        } else {
            baseResult.setMessage("登录失败，没有该用户");
        }
        return baseResult;
    }

    @Override
    public BaseResult add(User user) {
        BaseResult baseResult = checkUserData(user);
        //数据验证成功
        if (baseResult.status == BaseResult.STATUS_SUCCESS) {
            dao.insert(user);
            baseResult.setMessage("数据插入成功");
            return baseResult;
        } else {
            return baseResult;
        }
    }

    @Override
    public List<User> page(int leftArg, int rightArg) {
        return dao.queryPageUsers(leftArg,rightArg);
    }

    @Override
    public int queryUserTotal() {
        return dao.queryUserTotal();
    }

    @Override
    public void deleteMulti(String[] id) {
        dao.deleteMulti(id);
    }

    @Override
    public List<User> searchUser(UserPageDto userPageDto) {
        return dao.searchUser(userPageDto);
    }

    @Override
    public int flitTotal(UserPageDto userPageDto) {
        return dao.flitTotal(userPageDto);
    }

    @Override
    public BaseResult updateUser(User user) {
        BaseResult baseResult = checkUserData(user);
        //数据验证成功
        if (baseResult.status == BaseResult.STATUS_SUCCESS) {
            dao.updateByPrimaryKeySelective(user);
            baseResult.setMessage("数据修改成功");
            return baseResult;
        } else {
            return baseResult;
        }
    }


    public BaseResult checkUserData(User user) {
        BaseResult baseResult = BaseResult.success();
        if (StringUtils.isBlank(user.getNumber())) {
            baseResult = BaseResult.fail("账号不能为空");
            return baseResult;
        } else {
            //查询数据库中是否存在该账号
            User user1 = dao.queryByNumber(user.getNumber());
            //如果数据库中存在该账号
            if (user1 != null) {
                //判断是新增还是修改账号
                if (user.getId() != null) {
                    //判断存在的账号是否为自己的账号，如果不是则该账号已被注册
                    if (!user.getId().equals(user1.getId())) {
                        baseResult = BaseResult.fail("该账号已被注册");
                        return baseResult;
                    }
                } else {
                    baseResult = BaseResult.fail("该账号已被注册");
                    return baseResult;
                }
            }
        }

        if (StringUtils.isBlank(user.getPhone())) {
            baseResult = BaseResult.fail("手机号不能为空");
            return baseResult;
        }else {
            User user1 = dao.queryOneByPhone(user.getPhone());
            if (user1 != null) {
                if (user.getId() != null) {
                    if (!user.getId().equals(user1.getId())) {
                        baseResult = BaseResult.fail("该手机号已被注册");
                        return baseResult;
                    }
                } else {
                    baseResult = BaseResult.fail("该手机号已被注册");
                    return baseResult;
                }
            }

        }

        if (StringUtils.isBlank(user.getPassword())) {
            baseResult = BaseResult.fail("密码不能为空");
            return baseResult;
        }

        return baseResult;

    }
}
