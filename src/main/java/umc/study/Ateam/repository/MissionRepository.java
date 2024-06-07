package umc.study.Ateam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.study.Ateam.domain.Mission;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {
}
