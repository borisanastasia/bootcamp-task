package by.itacademy.bootcamp.task.presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "by.itacademy.bootcamp.task")
@EnableJpaRepositories(basePackages = "by.itacademy.bootcamp.task")
@EntityScan(basePackages = "by.itacademy.bootcamp.task")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
