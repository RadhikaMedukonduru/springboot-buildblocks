package com.spring.restservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {
	
	@Bean
	public Docket api()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getApiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.spring.restservices"))
				.paths(PathSelectors.ant("/user/**"))
				.build();
	}
	
	//Swagger-Metadata : http://localhost:8555/v2/api-docs
	//Swagger UI url : http://localhost:8555/swagger-ui.html
	
	public ApiInfo getApiInfo()
	{
		return new ApiInfoBuilder()
				.title("User Management service")
				.description("This doc contins all apis realated to User Management Service")
				.version("2.0")
				.contact(new Contact("Radhika","http://www.ums.com","radhika.m@gmail.com"))
				.license("License 2.0")
				.licenseUrl("http://www.ums.com/license.html")
				.build();
	}
				
				
	}


