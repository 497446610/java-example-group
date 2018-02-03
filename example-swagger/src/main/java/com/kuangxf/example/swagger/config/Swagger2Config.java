package com.kuangxf.example.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("user").apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.kuangxf.example.swagger.controller"))
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Spring Boot中使用Swagger2构建RESTful APIs")//
				.description("更多Spring Boot相关文章请关注：http://www.kuangxf.com/")//
				.termsOfServiceUrl("http://www.kuangxf.com/")//
				.contact(new Contact("况小锋", "http://www.kuangxf.com/", "497446610@qq.com"))//
				.version("1.0").build();
	}

}
