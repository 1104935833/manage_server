package hxc.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ManagerServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagerServerApplication.class, args);
	}
}
