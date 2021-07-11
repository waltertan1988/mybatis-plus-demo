package com.walter.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.walter.demo.dao.entity.User;
import com.walter.demo.dao.mapper.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ApplicationTest extends BaseTests{

    @Autowired
    private UserMapper userMapper;

    @Test
    public void select() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .select(User::getId, User::getName, User::getAge, User::getEmail)
                .like(User::getName, "B%")
                .or(c -> c.lt(User::getId, 4L)
                        .ge(User::getAge, 20)
                        .like(User::getName, "%J%"));

        List<User> userList = userMapper.selectList(wrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void insert(){
        User user = new User()
                .setId(6L)
                .setName("Walter")
                .setAge(20)
                .setEmail("abc@123.com");
        userMapper.insert(user);
    }

    @Test
    public void update(){
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.lambda()
                .set(User::getEmail, "walter@123.com")
                .eq(User::getId, 6L);
        userMapper.update(null, wrapper);
    }

    @Test
    public void delete(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(User::getId, 6L);
        userMapper.delete(wrapper);
    }
}
