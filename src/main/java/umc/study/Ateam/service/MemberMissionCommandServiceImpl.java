package umc.study.Ateam.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.Ateam.apiPayload.code.status.ErrorStatus;
import umc.study.Ateam.apiPayload.exception.handler.AppHandler;
import umc.study.Ateam.converter.MemberMissionConverter;
import umc.study.Ateam.domain.Member;
import umc.study.Ateam.domain.Mission;
import umc.study.Ateam.domain.mapping.MemberMission;
import umc.study.Ateam.repository.MemberMissionRepository;
import umc.study.Ateam.repository.MemberRepository;
import umc.study.Ateam.repository.MissionRepository;
import umc.study.Ateam.web.dto.MemberMissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl {
    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionConverter memberMissionConverter;

    public MemberMissionRequestDTO.MemberMissionDTO addMemberMission(Long memberId, Long missionId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new AppHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new AppHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
        MemberMission memberMission = memberMissionConverter.toEntity(member, mission);
        MemberMission savedMemberMission = memberMissionRepository.save(memberMission);
        return memberMissionConverter.toDto(savedMemberMission);
    }
}
