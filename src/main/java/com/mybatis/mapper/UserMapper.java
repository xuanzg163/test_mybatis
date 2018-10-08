package com.mybatis.mapper;

import com.mybatis.po.User;

/**
 * UserDAO
 */
public interface UserMapper {
    public User queryUserById(Integer id);
}
