package com.github.gudian1618.cgb2011mybatis;

import com.github.gudian1618.cgb2011mybatis.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

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

    /**
     * 练习5:查询制定id的员工信息
     */
    @Test
    public void testFindById() {
        // 执行SQL语句,返回执行结果
        Integer id = 1;
        Emp emp = session.selectOne("EmpMapper.findById", id);
        System.out.println(emp);

    }

    /**
     * 练习6:新增员工信息:张飞java开发工程师15000
     */
    @Test
    public void testInsert2() {
        // 将SQL语句中的参数值封装到一个map集合中
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张飞");
        map.put("job", "Java开发工程师");
        map.put("salary", 15000);

        int rows = session.update("EmpMapper.insert2", map);
        System.out.println("影响行数:" + rows);
    }

    /**
     * 练习6:新增员工信息:张飞java开发工程师15000
     */
    @Test
    public void testInsert3() {
        // 将SQL语句中的参数值封装到一个POJO对象中
        Emp emp = new Emp();
        emp.setName("关羽");
        emp.setJob("保安");
        emp.setSalary(8000.0);

        int rows = session.update("EmpMapper.insert3", emp);
        System.out.println("影响行数:" + rows);
    }

    /**
     * 删除
     */
    @Test
    public void testDelete2() throws IOException {
        int rows = session.delete("EmpMapper.delete2", 1);
        session.commit();
        System.out.println("影响行数:" + rows);
    }

    /**
     * 更新员工信息
     */
    @Test
    public void testUpdate2() {
        // 将SQL语句中的参数封装到Emp对象中
        Emp emp = new Emp();
        emp.setName("张飞");
        emp.setJob("架构师");
        emp.setSalary(25000.0);
        int rows = session.update("EmpMapper.update2", emp);
        System.out.println("影响的行数:" + rows);
    }

}
