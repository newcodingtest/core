package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    /**
     * 현재 DIP 원칙에 위배된다. 구체화에 의존하고있다. WHY?
     *     FixDiscountPolicy 를 RateDiscountPolicy로 변경하는 순간 OrderServuceImpl 소스코드도 함께 변경해야한다. OCP 위반!
     */
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    /**
     * 그렇기 때문에 해당  private DiscountPolicy discountPolicy; 문을 선언해주면 인터페이스에만 의존한다(추상화에만 의존상태)
     */
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    /**
     * 단일 책임 원칙(SRP)을 잘 지킨것 WHY?
        OrderService 입장에서는 할인에 대해서 무관하다, 할인에 대한것은 DiscountPolicy 가 갖고있고 결과만 OrderService에게 던져주기 때문에
        할인과 관련된 변경은  DiscountPolicy 만 변경하면 된다.
     */
   @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
         //  1.회원조회
        Member member = memberRepository.findById(memberId);
        //  2.회원조회를 통해 DiscountPolicy 에게 할인등급 조회
        int discountPrice = discountPolicy.discount(member, itemPrice);
        // 3. 최종적으로 할인된 금액을 받음
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
