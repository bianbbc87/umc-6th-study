package umc.study.Ateam.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class StoreResponseDTO {

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateReviewResultDTO {
        Long reviewId;
        LocalDateTime createdAt;
    }
}
