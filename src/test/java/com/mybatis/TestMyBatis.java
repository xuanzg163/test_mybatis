package com.mybatis;

import com.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestMyBatis {

    @Test
    public void test01() throws IOException {
        /**
         a)、读取mybatis 的配置文件
         b)、加载配置文件创建SqlSessionFactory
         c)、根据SqlSessionFactory 创建SqlSession
         d)、通过sqlSession 操作数据库
         e)、处理结果
         f)、关闭session
         */

        /**
         * a)、读取mybatis 的配置文件
         */
        InputStream is = Resources.getResourceAsStream("mybatis.xml");

        /**
         * b)、创建会话工厂
         */

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        /**
         * c)、创建SqlSession
         */

         SqlSession sqlSession= sqlSessionFactory.openSession();

        /**
         * d)、通过sqlSession 操作数据库
         */

        User user = sqlSession.selectOne("com.mybatis.mapper.UserMapper.queryUserById",1);

        /**
         *  e)、处理结果
         */
        System.out.println(user);

        /**
         * f)、关闭session
         */
        sqlSession.close();

    }
}
