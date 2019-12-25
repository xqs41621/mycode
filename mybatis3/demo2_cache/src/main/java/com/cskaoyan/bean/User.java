package com.cskaoyan.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author xqs
 * @version 1.0
 * @description
 * @date 2019/12/21 14:15
 */
@Data
public class User implements Serializable {
    int id;
    String username;
    String password;
    int age;
    UserDetail userDetail;
    List<Order> orderList;
}
