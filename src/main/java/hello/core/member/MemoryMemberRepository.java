package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class MemoryMemberRepository implements MemberRepository {

    //HashMap은 실무에선 동시성 이슈가 있을수 있지만, 예제 개발용도로 일단 쓴다.
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
