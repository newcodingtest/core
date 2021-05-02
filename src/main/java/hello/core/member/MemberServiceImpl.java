package hello.core.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//alt+enter: 저절로 임폴트 해주는거
public class MemberServiceImpl implements MemberService {

    //ctrl + shift + enter = ; 까지 자동생성된다.

    // #DIP 위반사항
    // 아래주석기준 해당 클래스는 MemberService라는 추상화에 의존하고있으며 해당 필드는 MemoryMemberRepository 구체화에도 의존하고있다다
   //private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final MemberRepository memberRepository;

    @Autowired // ac.getBean(MemberRepository.class)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }


}
