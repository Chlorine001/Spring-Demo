package com.example.demo;

import com.example.demo.entity.SysUsers;
import com.example.demo.mapper.SysUsersMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * @version 1.0
 * @Author chenglong
 * @className MybatisPlusApplicationTests
 * @Description
 * @Date 2025-07-23
 */
@SpringBootTest
//扫描mapper接口所在包
@MapperScan("com.kuang.mybatis_plus.mapper")
class MybatisPlusApplicationTests {

    //继承了BaseMapper，所有的方法都来自父类
    //我们也可以编写自己的扩展方法
    //通过类型自动装配UserMapper接口
    @Autowired
    private SysUsersMapper sysUsersMapper;

    //测试插入用户数据
    @Test
    public void testInsert() {
        //获取User对象
        SysUsers user = new SysUsers();
        //设置用户名和年龄以及邮箱等属性
        //使用ASSign_UUID主键策略
        user.setName("杨宗纬");
        user.setAge(44);
        user.setEmail("yzw123456@qq.com");

        //返回受影响的行数(自动帮我们生成Id)
        int result = sysUsersMapper.insert(user);
        //打印受影响行数
        System.out.println(result);
        //打印插入的用户信息
        System.out.println(user);
    }
    //测试更新
    @Test
    public void testUpdate() {
        //获取User对象
        SysUsers user = new SysUsers();
        //设置修改用户的Id
        user.setId(1L);
        //设置用户要修改的信息(修改多个属性)
        user.setName("周杰伦");
        user.setAge(27);
        user.setEmail("zjl123456@qq.com");
        //通过Id修改用户,并且返回影响行数
        //注意：虽然updateById是通过Id修改信息，但是参数其实是一个对象！
        int result = sysUsersMapper.updateById(user);
        //打印受影响行数
        System.out.println(result);
    }

}