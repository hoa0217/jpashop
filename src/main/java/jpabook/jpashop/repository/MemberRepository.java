package jpabook.jpashop.repository;

import java.util.List;
import jpabook.jpashop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

  // select m from Member m where m.name = :name 자동으로 JPQL 쿼리 실행
  List<Member> findByName(String name);
}
