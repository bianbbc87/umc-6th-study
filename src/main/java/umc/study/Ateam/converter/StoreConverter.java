package umc.study.Ateam.converter;

import umc.study.Ateam.domain.Review;
import umc.study.Ateam.domain.Store;
import umc.study.Ateam.web.dto.ReviewRequestDTO;
import umc.study.Ateam.web.dto.StoreRequestDTO;
import umc.study.Ateam.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

public class StoreConverter {
    public static Review toReview(ReviewRequestDTO.ReviewDTO request) {
        return Review.builder()
                .title(request.getTitle())
                .score(request.getScore())
                .body(request.getBody())
                .build();
    }

    public static StoreResponseDTO.CreateReviewResultDTO toCreateReviewResultDTO(Review review) {
        return StoreResponseDTO.CreateReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static ReviewRequestDTO.ReviewPreViewDTO reviewPreViewDTO(Review review) {
        return null;
    }

    public static ReviewRequestDTO.ReviewPreViewListDTO reviewPreViewListDTO(List<Review> reviewList) {
        return null;
    }
}
