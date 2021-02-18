package com.github.gudian1618.cgb2011mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/2/18 10:07 下午
 * 编写mybatis增删改查与占位符(#{},${})
 */

public class TestMybatis02 {

    private static SqlSession session = null;

    static {
        // 对SqlSession进行初始化
        try {
            // 1.读取mybatis的核心配置文件mybatis-config.xml
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

            // 2.基于配置信息获取一个SqlSessionFactory工厂对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
            session = factory.openSession(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询emp表中的所以员工信息
     */
    @Test
    public void testInsert() {
        // 执行sql语句,返回结果
        int rows = session.insert("EmpMapper.insert");
        System.out.println("影响行数:" + rows);
    }

    /**
     * 修改员工信息
     */
    @Test
    public void testUpdate() {
        // 执行sql语句,返回执行结果
        int rows = session.update("EmpMapper.update");
        System.out.println("影响行数:" + rows);
    }

    /**
     * 删除员工信息
     */
    @Test
    public void testDelete() {
        // 执行sql语句,返回执行结果
        int rows = session.delete("EmpMapper.delete");
        System.out.println("影响的行数:" + rows);
    }

}
