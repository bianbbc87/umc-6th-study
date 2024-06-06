package umc.study.Ateam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.study.Ateam.domain.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
