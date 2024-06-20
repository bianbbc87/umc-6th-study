package umc.study.Ateam.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.study.Ateam.domain.Mission;
import umc.study.Ateam.domain.Review;
import umc.study.Ateam.domain.mapping.MemberMission;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {
    Page<Mission> findAllByStoreId(Long storeId, PageRequest pageRequest);
}
