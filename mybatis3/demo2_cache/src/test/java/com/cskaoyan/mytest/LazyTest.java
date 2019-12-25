package com.cskaoyan.mytest;

import com.cskaoyan.bean.User;
import com.cskaoyan.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @author xqs
 * @version 1.0
 * @description
 * @date 2019/12/21 15:29
 */
public class LazyTest {
    SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession;

    @Before
    public void before() throws IOException {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.xml"));
    }
    @After
    public void after(){
        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }
    }

    //注意表名不能和关键字同名，比如order
    @Test
    public void mytest1(){
        sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = mapper.queryUserById(1);
        sqlSession.commit();
        User user2 = mapper.queryUserById(1);
        User user3 = mapper.queryUserById(1);
        User user4 = mapper.queryUserById(1);
        User user5 = mapper.queryUserById(1);
        //System.out.println(user);
        //懒加载时如果打印user，会调用user.getUserDetail和user.getOrder
        //System.out.println(user.getAge());
    }

    @Test
    public void mytest2(){
        sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = mapper.queryUserById(1);
        sqlSession.commit();
        User user2 = mapper.queryUserById(1);
        User user3 = mapper.queryUserById(1);
        int i = mapper.deleteUserById(6);
        sqlSession.commit();
        User user4 = mapper.queryUserById(1);
        User user5 = mapper.queryUserById(1);
        User user6 = mapper.queryUserById(1);
        //System.out.println(user);
        //懒加载时如果打印user，会调用user.getUserDetail和user.getOrder
        //System.out.println(user.getAge());
    }
}
