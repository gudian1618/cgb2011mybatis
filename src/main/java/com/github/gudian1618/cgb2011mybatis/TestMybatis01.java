package com.github.gudian1618.cgb2011mybatis;

import com.github.gudian1618.cgb2011mybatis.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/2/16 9:07 上午
 * 编写mybatis快速入门程序
 */

public class TestMybatis01 {

    /**
     * 查询emp表中的所以员工信息
     */
    @Test
    public void findAll() throws IOException {

        // 1.读取mybatis的核心配置文件mybatis-config.xml
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        // 2.基于配置信息获取一个SqlSessionFactory工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        // 3.通过工厂独享获取一个SqlSession对象
        // 默认是false,表示手动提交事务,true表示自动提交事务
        SqlSession session = factory.openSession(true);

        // 4.执行SQL语句(EmpMapper.xml),接收处理后的结果
        List<Emp> list = session.selectList("EmpMapper.findAll");

        // 5.输出结果
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

}
