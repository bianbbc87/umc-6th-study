package umc.study.Ateam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.study.Ateam.domain.mapping.MemberMission;

@Repository
public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
}
