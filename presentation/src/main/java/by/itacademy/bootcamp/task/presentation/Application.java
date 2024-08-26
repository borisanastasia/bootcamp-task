package by.itacademy.bootcamp.task.presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;

@SpringBootApplication(scanBasePackages = "by.itacademy.bootcamp.task")
@EnableJpaRepositories(basePackages = "by.itacademy.bootcamp.task")
@EntityScan(basePackages = "by.itacademy.bootcamp.task")
@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
