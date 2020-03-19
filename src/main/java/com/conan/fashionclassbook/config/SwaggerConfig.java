package com.conan.fashionclassbook.config;

import com.conan.fashionclassbook.commons.Const;
import com.conan.fashionclassbook.utils.PropertiesUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(Boolean.valueOf(PropertiesUtil.getProperty(Const.Swagger.ENABLE)))
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.conan.fashionclassbook.web"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(PropertiesUtil.getProperty(Const.Swagger.TITLE))
                .description(Const.Swagger.DESCRIPTION)
                .termsOfServiceUrl(Const.Swagger.TERMSOFSERVICEURL)
                .version(Const.Swagger.VERSION)
                .build();
    }
}
