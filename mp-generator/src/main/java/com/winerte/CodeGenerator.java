package com.winerte;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.querys.DB2Query;
import com.baomidou.mybatisplus.generator.config.querys.DbQueryRegistry;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

public class CodeGenerator {
    public static void main(String[] args) {
        //代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();
        //配置全局设置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("winerte");
        gc.setOpen(false);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true);
        gc.setIdType(IdType.AUTO);
        gc.setBaseColumnList(true);
        gc.setBaseResultMap(true);
        gc.setFileOverride(true);

        autoGenerator.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://192.168.67.132:3307/springboot-learn?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("docker_mysql8");

        autoGenerator.setDataSource(dsc);

        //4、策略配置 ，可以单个设置对应的表
 /*       StrategyConfig sy = new StrategyConfig();
        sy.setInclude("user");//设置要映射的表，可以设置多张
        sy.setNaming(NamingStrategy.underline_to_camel);//从数据库表到文件的命名策略,下划线转驼峰命名
        sy.setColumnNaming(NamingStrategy.underline_to_camel);//列的命名策略
        sy.setEntityLombokModel(true);//开启lombok支持
        sy.setLogicDeleteFieldName("deleted");//设置逻辑删除字段
        sy.setVersionFieldName("version");//设置乐观锁
        sy.setRestControllerStyle(true);//开启controller的restful命名
        sy.setControllerMappingHyphenStyle(true);//开启controller中请求映射的连字符样式，如：localhost:8080/hello_id_1
        //设置自动填充
        TableFill create_time = new TableFill("create_time", FieldFill.INSERT);
        TableFill update_time = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(create_time);
        tableFills.add(update_time);
        autoGenerator.setStrategy(sy);
*/

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.winerte.auto");
        autoGenerator.setPackageInfo(pc);

        autoGenerator.execute();
    }
}
