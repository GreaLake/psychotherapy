package cn.lake.psychotherapy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: lake
 * @Date: 2022/5/20 11:34
 * @Description:
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket webApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(webApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.lake.psychotherapy.controller"))
                .build();

    }
    private ApiInfo webApiInfo(){

        return new ApiInfoBuilder()
                .title("心理咨询系统api")
                .description("本文档描述了心理咨询的应用接口定义")
                .version("1.0")
                .contact(new Contact("lake", "", "lake456@qq.com"))
                .build();
    }
}
