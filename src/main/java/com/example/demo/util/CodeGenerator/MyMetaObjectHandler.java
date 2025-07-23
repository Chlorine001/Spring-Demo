package com.example.demo.util.CodeGenerator;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @version 1.0
 * @Author chenglong
 * @className MyMetaObjectHandler
 * @Description 编写自动填充处理器
 * @Date 2025-07-23
 */
@Slf4j
@Component // 一定不要忘记把处理器加到IOC容器中！
public class MyMetaObjectHandler implements MetaObjectHandler {

    // 插入时的填充策略
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill.....");
        // setFieldValByName(String fieldName, Object fieldVal, MetaObject metaObject
        //是否开启了插入填充
//        this.openInsertFill();
        /* *
         * setFieldValByName方法有三个参数：
         * String fieldName, Object fieldVal, MetaObject metaObject
         * @param fieldName  Java实体类的属性名称
         * @param fieldVal   Java实体类的属性值
         * @param metaObject 数据源对象参数
         */
        //设置创建时间属性和值
        //3.3.0之前使用setFieldValByName方法
//        this.setFieldValByName("createTime",new Date(),metaObject);
        //3.3.0之后推荐使用strictInsertFill方法
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        //设置修改时间属性和值
        //3.3.0之前使用setFieldValByName方法
//        this.setFieldValByName("updateTime",new Date(),metaObject);
        //3.3.0之后推荐使用strictInsertFill方法
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
    }

    // 更新时的填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill.....");
        //设置修改时间属性和值
        //3.3.0之前使用setFieldValByName方法
//        this.setFieldValByName("updateTime",new Date(),metaObject);
        //3.3.0之后推荐使用strictUpdateFill方法
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
    }

}

