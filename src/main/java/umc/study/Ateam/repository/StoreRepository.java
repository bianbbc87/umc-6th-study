package umc.study.Ateam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.study.Ateam.domain.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
}
