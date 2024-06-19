package umc.study.Ateam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.Ateam.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}