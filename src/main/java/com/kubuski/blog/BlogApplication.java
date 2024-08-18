package com.kubuski.blog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Blog API", version = "1.0", contact = @Contact(name = "kubuski", email = "kubapraszkowski@gmail.com"), license = @License(name = "MIT", url = "https://github.com/jakubpraszkowski/Blog?tab=MIT-1-ov-file"), description = "Blog API Information"), externalDocs = @ExternalDocumentation(description = "Springdoc Blog API", url = "https://github.com/jakubpraszkowski/Blog"))
public class BlogApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

}
