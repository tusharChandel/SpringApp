package com.springBootApp.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.springBootApp.demo.config.FormLoginOperations;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spring.web.plugins.DocumentationPluginsManager;
import springfox.documentation.spring.web.scanners.ApiDescriptionReader;
import springfox.documentation.spring.web.scanners.ApiListingScanner;
import springfox.documentation.spring.web.scanners.ApiModelReader;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final String CONTROLLERS_BASE_PACKAGE = "com.springBootApp.demo.controller";

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage(CONTROLLERS_BASE_PACKAGE)).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("User SignUp").description("Tushar SignUp Application in spring boot..!")
				.build();
	}
	
	@Primary
	@Bean
	public ApiListingScanner addExtraOperations(ApiDescriptionReader apiDescriptionReader,
			ApiModelReader apiModelReader, DocumentationPluginsManager pluginsManager) {
		return new FormLoginOperations(apiDescriptionReader, apiModelReader, pluginsManager);
	}

}
