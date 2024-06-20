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
import umc.study.Ateam.service.MissionService;
import umc.study.Ateam.service.StoreQueryService;
import umc.study.Ateam.web.dto.MissionResponseDTO;
import umc.study.Ateam.web.dto.ReviewRequestDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
public class MissionController {

    private final StoreQueryService storeQueryService;

    @GetMapping("{storeId}/missions")
    @Operation(summary = "특정 가게의 미션 목록 조회",description = "사용자가 선택한 가게의 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<MissionResponseDTO.MissionPreViewListDTO> getMemberReviewList(@PathVariable(name = "storeId") Long storeId, @RequestParam(name = "page") Integer page){

        MissionResponseDTO.MissionPreViewListDTO missions = (MissionResponseDTO.MissionPreViewListDTO) storeQueryService.getMissionList(storeId, page);
        return ApiResponse.onSuccess(missions);
    }
}
