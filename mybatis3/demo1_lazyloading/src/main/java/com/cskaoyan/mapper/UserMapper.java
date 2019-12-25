package com.cskaoyan.mapper;

import com.cskaoyan.bean.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author xqs
 * @version 1.0
 * @description
 * @date 2019/12/21 14:17
 */
public interface UserMapper {
    User queryUserById(@Param("id") int id);
}
