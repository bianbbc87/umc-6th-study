package umc.study.Ateam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.study.Ateam.domain.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
}
