package com.idea.realize;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * @author happyxu
 * @Description: TODO
 * @Title: SideaApplication
 * @ProjectName sidea
 * @date 2018/9/11下午11:16
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.idea")
//@ImportResource(locations = {"classpath:myBean.xml"})
//@MapperScan("com.idea.realize")
public class SideaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SideaApplication.class, args);
    }


    


}
