package com.github.gudian1618.cgb2011mybatis;

import com.github.gudian1618.cgb2011mybatis.dao.EmpMapper;
import com.github.gudian1618.cgb2011mybatis.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/2/22 7:43 下午
 * mybatis的mapper接口开发
 * 1.创建为一个mapper接口,要求接口的全限定类名 和 mapper文件的namespace值相同
 * 2.mapper文件中的每条SQL语句,在mapper接口中要添加一个对应的方法,并且接口中的方法名和SQL标签上的id值要相同
 * 3.mapper接口中方法上的参数类型,和mapper文件中的SQL语句接收的参数类型要相同
 * 4.接口中方法的返回值类型和SQL标签的resultType即返回值类型也要相同,如果返回值是一个集合(比如List<Emp>)
 * 需要在resultType中只需要指定集合中的泛型,即Emp类型
 */

public class TestMybatis03 {
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

    // ==============mapper接口开发=================

    @Test
    public void testFindAll() {
        // 1.获取EmpMapper接口的子类对象/实例
        // 将EmpMapper接口的字节码对象传给getMapper方法,框架底层会根据EmpMapper接口的字节码对象为接口提供一个实现类,
        // 动态的生成实现类/子类,再根据实现类/子类创建一个实例并返回
        EmpMapper mapper = session.getMapper(EmpMapper.class);

        // 2.调用findAll方法查询所有员工信息
        // findAll方法底层如何实现:findAll方法底层会根据 [接口的全限定类名+当前方法的名字] 找到要执行的SQl语句,执行SQL语句,返回执行的结构即可
        List<Emp> list = mapper.findAll();

    }

}
