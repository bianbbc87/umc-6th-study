package umc.study.Ateam.service;

import org.springframework.data.domain.Page;
import umc.study.Ateam.domain.Review;
import umc.study.Ateam.domain.Store;

import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(Long id);

    Page<Review> getReviewList(Long StoreId, Integer page);
}
