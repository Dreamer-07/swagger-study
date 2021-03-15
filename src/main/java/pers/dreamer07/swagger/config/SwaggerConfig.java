package pers.dreamer07.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * @program: swagger
 * @description:
 * @author: EMTKnight
 * @create: 2021-03-15
 **/
@Configuration
public class SwaggerConfig {

    /**
     * 配置 Swagger
     * @param env 当前项目的运行环境对象
     * @return
     */
    @Bean
    public Docket docket(Environment env){

        // 检查当前环境是否为指定的环境变量
        Profiles profile = Profiles.of("dev", "test");
        // 判断是否处在指定的环境中
        boolean flag = env.acceptsProfiles(profile);

        return new Docket(DocumentationType.OAS_30)
                .enable(flag)
                .groupName("Dreamer07")
                .apiInfo(apiInfo()) // 设置 Api 文档信息
                /*
                * Docket.select(): 配置 Swagger 扫描接口
                *   apis(): 配置要扫描的接口
                *       - 需要传入一个 Predicate<RequestHandler> 类实例，
                *         但我们可以通过 RequestHandlerSelectors 的静态方法创建
                *       - RequestHandlerSelectors 可选值
                *           #basePackage(): 传入要扫描的包路径
                *           #any()：所有
                *           #none(): 不扫描
                *           #withMethodAnnotation(): 传入注解类，只有具有该注解的方法才会被扫描
                *           #withClassAnnotation()：传入注解类，只有具有该注解的类才会被扫描
                *   paths()：配置需要过滤的路径
                *       - 需要传入一个 Predicate<String> 类实例，但可以通过 PathSelectors 的静态方法创建
                *       - PathSelectors 可选值
                *           #any & #none ~
                *           #regex() 根据正则规则
                *           #ant() 根据 ant 风格的匹配规则，只留下符合规则的接口
                * */
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.ant("/byq/**"))
                .build();
    }

    @Bean
    public Docket docket01(){
        return new Docket(DocumentationType.OAS_30)
                .groupName("A")
                .select()
                .apis(RequestHandlerSelectors.basePackage("pers.dreamer07.swagger"))
                .build();
    }
    @Bean
    public Docket docket02(){
        return new Docket(DocumentationType.OAS_30).groupName("B");
    }
    @Bean
    public Docket docket03(){
        return new Docket(DocumentationType.OAS_30).groupName("C");
    }

    /**
     * 配置 Api 文档信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Dreamer07 Swagger 测试" // 标题
                , "巴御前天地第一" // 描述
                , "1.0" // 版本
                , "http://www.baidu.com" // 网址?
                , new Contact("Dreamer07", "http://www.baidu.com", "2391105059@qq.com") // 配置作者信息
                , "Apache 2.0"
                , "http://www.apache.org/licenses/LICENSE-2.0"
                , new ArrayList()
        );
    }
}
