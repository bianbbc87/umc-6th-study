package umc.study.Ateam.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.Ateam.apiPayload.ApiResponse;
import umc.study.Ateam.domain.Mission;
import umc.study.Ateam.domain.Review;
import umc.study.Ateam.service.MissionService;
import umc.study.Ateam.service.ReviewService;
import umc.study.Ateam.web.dto.MissionRequestDTO;
import umc.study.Ateam.web.dto.ReviewRequestDTO;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    private final MissionService missionService;

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<Review> addReviewToStore(@PathVariable Long storeId, @RequestBody ReviewRequestDTO requestDTO) {
        Review review = reviewService.addReviewToStore(storeId, requestDTO);
        return ApiResponse.onSuccess(review);
    }

    @PostMapping("/{storeId}/missions")
    public ApiResponse<Mission> addMissionToStore(@PathVariable Long storeId, @RequestBody MissionRequestDTO requestDTO) {
        Mission mission = missionService.addMissionToStore(storeId, requestDTO);
        return ApiResponse.onSuccess(mission);
    }
}