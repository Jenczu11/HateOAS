package com.atos.rest.Hateoas;

import com.atos.rest.controller.RestStudentController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan(basePackageClasses = RestStudentController.class)
public class HateoasApplication {

	public static void main(String[] args) {
		SpringApplication.run(HateoasApplication.class, args);
	}

}
