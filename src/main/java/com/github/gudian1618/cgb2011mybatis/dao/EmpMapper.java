package com.github.gudian1618.cgb2011mybatis.dao;

import com.github.gudian1618.cgb2011mybatis.pojo.Emp;

import java.util.List;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/2/22 7:59 下午
 * Mapper接口
 * 全限定类名:
 * com.github.gudian1618.cgb2011mybatis.dao.EmpMapper
 */

public interface EmpMapper {

    /**
     * 练习1: 查询
     */
    public List<Emp> findAll();

}
