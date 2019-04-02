package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
     *
	 * @return the cdmp-hbase-api-1.0 group apis
	 */
	@Bean
	public Docket clientApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("api-1.0").select()
				.apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
				.build();

	}
}