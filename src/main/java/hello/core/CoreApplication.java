package hello.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//순수 자바로만 개발 진행



@SpringBootApplication
public class CoreApplication {
	//file-setting-gradle 가서 intelli j 로 바꿔주기 >> 빌드시 gradle을 통하지 않기 때문에 바로 인텔리 j 로 돌려서 더 빠름
	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}

}
