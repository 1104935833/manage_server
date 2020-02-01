package hxc.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableCaching
@EnableAsync//开启异步任务
public class ManagerServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagerServerApplication.class, args);
	}
}
