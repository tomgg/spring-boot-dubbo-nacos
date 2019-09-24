package cn.yase.consumer;

import cn.yase.api.SayHello;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

	@Reference(version = "1.0.0")
	private SayHello sayHello;

	@Bean
	public ApplicationRunner runner() {
		return args -> {
			System.out.println(sayHello.sayHello("yase"));
		};
	}

}
