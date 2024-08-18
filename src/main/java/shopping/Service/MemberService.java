package shopping.Service;

import org.springframework.stereotype.Service;
import shopping.Model.Member;
import shopping.Repository.MemberRepository;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    // 회원 등록
    public Member registerMember(Member member) {
        memberRepository.save(member);
        return member;
    }

}
