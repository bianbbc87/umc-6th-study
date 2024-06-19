package umc.study.Ateam.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.Ateam.apiPayload.ApiResponse;
import umc.study.Ateam.converter.MemberMissionConverter;
import umc.study.Ateam.service.MemberMissionCommandServiceImpl;
import umc.study.Ateam.web.dto.MemberMissionRequestDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MemberMissionController {
    private final MemberMissionCommandServiceImpl memberMissionService;

    @PostMapping("/{missionId}/members/{memberId}")
    public ApiResponse<MemberMissionRequestDTO.MemberMissionDTO> addMemberMission(@PathVariable Long missionId, @PathVariable Long memberId) {
        MemberMissionRequestDTO.MemberMissionDTO createdMemberMission = memberMissionService.addMemberMission(memberId, missionId);
        return ApiResponse.onSuccess(createdMemberMission);
    }
}
