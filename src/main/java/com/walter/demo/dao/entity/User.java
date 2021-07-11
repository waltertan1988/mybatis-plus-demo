package com.walter.demo.dao.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author tyx
 * @date 2021/7/11
 *
 */
@Data
@Accessors(chain = true)
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
