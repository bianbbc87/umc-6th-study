package umc.study.Ateam.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.Ateam.apiPayload.ApiResponse;
import umc.study.Ateam.domain.Mission;
import umc.study.Ateam.domain.Review;
import umc.study.Ateam.service.MissionService;
import umc.study.Ateam.service.ReviewService;
import umc.study.Ateam.service.StoreQueryService;
import umc.study.Ateam.service.StoreQueryServiceImpl;
import umc.study.Ateam.web.dto.MissionRequestDTO;
import umc.study.Ateam.web.dto.ReviewRequestDTO;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    private final MissionService missionService;
    private final StoreQueryService storeQueryService;

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<Review> addReviewToStore(@PathVariable Long storeId, @RequestBody ReviewRequestDTO.ReviewDTO requestDTO) {
        Review review = reviewService.addReviewToStore(storeId, requestDTO);
        return ApiResponse.onSuccess(review);
    }

    @PostMapping("/{storeId}/missions")
    public ApiResponse<Mission> addMissionToStore(@PathVariable Long storeId, @RequestBody MissionRequestDTO requestDTO) {
        Mission mission = missionService.addMissionToStore(storeId, requestDTO);
        return ApiResponse.onSuccess(mission);
    }

    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<ReviewRequestDTO.ReviewPreViewListDTO> getReviewList(@PathVariable(name = "storeId") Long storeId, @RequestParam(name = "page") Integer page){
        return null;
    }

    @GetMapping("{memberId}/{storeId}/reviews")
    @Operation(summary = "내가 작성한 리뷰 목록 조회 API",description = "내가 작성한 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<ReviewRequestDTO.ReviewMemberPreViewListDTO> getMemberReviewList(@PathVariable(name = "storeId") Long memberId, @RequestParam(name = "page") Integer page){

        ReviewRequestDTO.ReviewMemberPreViewListDTO reviews = (ReviewRequestDTO.ReviewMemberPreViewListDTO) storeQueryService.getMemberReviewList(memberId, page);
        return ApiResponse.onSuccess(reviews);
    }
}
