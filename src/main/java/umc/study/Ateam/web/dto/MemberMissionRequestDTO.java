package umc.study.Ateam.web.dto;

import lombok.Builder;
import lombok.Data;

public class MemberMissionRequestDTO {

    @Data
    @Builder
    public static class MemberMissionDTO {
        private Long memberId;
        private Long missionId;
    }
}
