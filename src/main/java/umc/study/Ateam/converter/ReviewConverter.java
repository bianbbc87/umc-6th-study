package umc.study.Ateam.converter;

import org.springframework.stereotype.Component;
import umc.study.Ateam.domain.Member;
import umc.study.Ateam.domain.Review;
import umc.study.Ateam.domain.Store;
import umc.study.Ateam.web.dto.ReviewRequestDTO;

@Component
public class ReviewConverter {
    public Review toReviewEntity(ReviewRequestDTO.ReviewDTO requestDTO, Store store, Member member) {
        return Review.builder()
                .title(requestDTO.getTitle())
                .score(requestDTO.getScore())
                .body(requestDTO.getBody())
                .store(store)
                .member(member)
                .build();
    }
}
