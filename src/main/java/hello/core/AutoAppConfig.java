package hello.core;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
//@ComponentScan: 스프링 빈을 쫙 가져오는것
@ComponentScan(
        //basePackages = "hello.core.member", 를 쓰면 hello.core.member 여기서 부터 스프링이 빈 들을 스캔하거나 위의 package hello.core; 경로만 설정해둬도 이와 같은 역핥
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {


}
