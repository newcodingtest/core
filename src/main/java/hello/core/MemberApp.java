package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    //psvm 만 치면 main문 저절로 생성

    //현재 순수한 자바코드 스프링 관련 1도 없음, 좋은 방법은 아님
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
        //MemberService memberService = new MemberServiceImpl();

        //AppConfig 클래스에 스프링 bean으로 등록된 파일들을 불러올수 있음 불러올땐 모든 빈은 스프링의 ApplicationContext(스프링 컨테이너)에 저장되어있음
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //getBean 으로 등록된 Bean클래스를 가져올 수 있음
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1l, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1l);
        System.out.println("newMember = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
