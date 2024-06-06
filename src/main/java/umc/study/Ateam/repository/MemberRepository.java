package umc.study.Ateam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.Ateam.domain.Member;


public interface MemberRepository extends JpaRepository<Member, Long> {
}