package com.github.Hugoftf.arquiteturaspring;

import org.h2.security.auth.Configurable;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class ArquiteturaspringApplication {

	public static void main(String[] args) {

		//SpringApplication.run(ArquiteturaspringApplication.class, args);

		SpringApplicationBuilder builder =  new SpringApplicationBuilder(ArquiteturaspringApplication.class);

		builder.bannerMode(Banner.Mode.OFF);

		builder.profiles("producao");
		builder.run(args);

		//Contexto da Applicação

		ConfigurableApplicationContext context = builder.context();
		//var produtoRepository = context.getBean("produtoRepository");

		ConfigurableEnvironment environment = context.getEnvironment();

		String appName =  environment.getProperty("string.application.name");
		System.out.println("Nome da applicação: " + appName);


	}

}
