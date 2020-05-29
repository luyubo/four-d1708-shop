package com.four.d1780.shop.cartAndOrderServer;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;

public class CodeGenerator {

    //程序入口
    public static void main(String[] args) {
        //创建代码生成器对象
        AutoGenerator mpg = new AutoGenerator();

        //全局配置
        GlobalConfig gc = new GlobalConfig();
        //设置输出路径
        gc.setOutputDir(System.getProperty("user.dir") + "/src/main/java");
        //设置作者
        gc.setAuthor("wh");
        //返回生成结果
        gc.setBaseColumnList(true);
        gc.setBaseResultMap(true);

        //生成是否打开文件
        gc.setOpen(false);
        //全局设置
        mpg.setGlobalConfig(gc);


        //数据源配置
        DataSourceConfig data = new DataSourceConfig();

        //设置驱动类
        data.setDriverName("com.mysql.jdbc.Driver");
        //设置的url
        data.setUrl("jdbc:mysql://localhost:3306/hypermarket?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC");
        //设置的用户名
        data.setUsername("root");
        //设置的密码
        data.setPassword("123");

        //设置代码生成器对象的数据
        mpg.setDataSource(data);

        //设置生成到哪里  包
        PackageConfig pc = new PackageConfig();
        //设置包名称
        pc.setParent(CodeGenerator.class.getPackage().getName());

        //设置包的路径 com.libin.demohello  /entity/service/mapper/controller
        mpg.setPackageInfo(pc);

        //生成的策略
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("hypermarket_cart","hypermarket_sku");
        //strategy.setTablePrefix("t_");

        //生成哪些表
        //strategy.setInclude();
        //排除哪些表
        //strategy.setExclude();
        //表的前缀
        //strategy.setTablePrefix();
        //
        //strategy.setFieldPrefix();

        //采用lombok处理
        strategy.setEntityLombokModel(true);

        //设置生成策略
        mpg.setStrategy(strategy);

        //执行生成
        mpg.execute();
    }
}