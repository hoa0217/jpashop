package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원 가입
     *
     * @param member
     * @return
     */
    @Transactional
    public Long join(Member member){
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member); // em.persist 하게 되면 영속성 컨텍스트에 member를 올림. 그때 key값이 pk(id)가 되고 값도 넣어준다.
        return member.getId(); // id를 돌려줘야 뭐를 저장했는지 알 수 있음.
    }

    /**
     * 중복 회원 검증 로직
     * @param member
     */
    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }

    }

    /**
     * 회원 전체조회
     *
     * @return
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    /**
     * 회원 단건조회
     *
     * @param id
     * @return
     */
    public Member findOne(Long id){
        return memberRepository.findOne(id);
    }

}
