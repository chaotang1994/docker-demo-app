package com.ex.dockerspringboothello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan("com.ex.dockerspringboothello")
public class DockerSpringbootHelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerSpringbootHelloApplication.class, args);
	}

}
