package com.walter.demo.dao.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.walter.demo.dao.entity.User;
import com.walter.demo.dao.mapper.UserMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author tyx
 * @date 2021/7/12
 *
 */
@Repository
public class UserRepository extends ServiceImpl<UserMapper, User> {

    public List<User> findByAgeLessThen(int age) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda().lt(User::getAge, age);
        List<User> list = baseMapper.selectList(wrapper);
        return CollectionUtils.isEmpty(list) ? Arrays.asList() : list;
    }

    public List<User> findAllUser() {
        List<User> list = baseMapper.findAllUser();
        return CollectionUtils.isEmpty(list) ? Arrays.asList() : list;
    }
}
