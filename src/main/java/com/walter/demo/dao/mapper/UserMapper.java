package com.walter.demo.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.walter.demo.dao.entity.User;

import java.util.List;

/**
 * @author tyx
 * @date 2021/7/11
 *
 */
public interface UserMapper extends BaseMapper<User> {

    List<User> findAllUser();
}
