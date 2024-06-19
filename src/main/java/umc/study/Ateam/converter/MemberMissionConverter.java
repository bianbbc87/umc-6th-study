package umc.study.Ateam.converter;

import org.springframework.stereotype.Component;
import umc.study.Ateam.domain.Member;
import umc.study.Ateam.domain.Mission;
import umc.study.Ateam.domain.mapping.MemberMission;
import umc.study.Ateam.web.dto.MemberMissionRequestDTO;

@Component
public class MemberMissionConverter {
    public MemberMission toEntity(Member member, Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .build();
    }

    public MemberMissionRequestDTO.MemberMissionDTO toDto(MemberMission memberMission) {
        return MemberMissionRequestDTO.MemberMissionDTO.builder()
                .memberId(memberMission.getMember().getId())
                .missionId(memberMission.getMission().getId())
                .build();
    }
}
