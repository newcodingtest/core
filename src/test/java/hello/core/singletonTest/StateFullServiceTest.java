package hello.core.singletonTest;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StateFullServiceTest { //싱글톤 패턴의 단점: 쓰레드 환경에서 치명적이다.

    @Test
    void statefulServiceSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StateFullService statefulService1 = ac.getBean(StateFullService.class);
        StateFullService statefulService2 = ac.getBean(StateFullService.class);

        //ThreadA:  A사용자 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);
        //ThreadB:  B사용자 20000원 주문
        int userBPrice = statefulService1.order("userB", 20000);

        //ThreadA: 사용자A 주문 금액 조회
        //int price = statefulService1.getPrice();
        System.out.println("price = " + userAPrice);

        //Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig{

        @Bean
        public StateFullService stateFullService(){
            return new StateFullService();
        }
    }
}
