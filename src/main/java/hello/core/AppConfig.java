package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

/*    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }
    public OrderService orderService(){
        return new OrderServuceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }*/

    /**
     * 위의 주석문을 아래 리펙토링 한 결과  *중복을 제거하였음음
    *  */

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
        // return new FixDiscountPolicy()
    }


}
