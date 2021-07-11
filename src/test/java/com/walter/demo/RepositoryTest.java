package com.walter.demo;

import com.walter.demo.dao.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author tyx
 * @date 2021/7/12
 *
 */
public class RepositoryTest extends BaseTests{

    @Autowired
    private UserRepository userRepository;

    @Test
    public void count(){
        System.out.println(userRepository.count());
    }

    @Test
    public void findAllUser(){
        userRepository.findAllUser().forEach(user -> System.out.println(user));
    }

    @Test
    public void findByAgeLessThen(){
        userRepository.findByAgeLessThen(22).forEach(user -> System.out.println(user));
    }
}
