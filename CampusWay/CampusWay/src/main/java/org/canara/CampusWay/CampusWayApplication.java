package org.canara.CampusWay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("org.canara.CampusWay.repository")
public class CampusWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampusWayApplication.class, args);
		System.out.println("hi");
	}

}
