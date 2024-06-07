package umc.study.Ateam.converter;

import org.springframework.stereotype.Component;
import umc.study.Ateam.domain.Mission;
import umc.study.Ateam.domain.Store;
import umc.study.Ateam.web.dto.MissionRequestDTO;

@Component
public class MissionConverter {
    public Mission toMissionEntity(MissionRequestDTO requestDTO, Store store) {
        return Mission.builder()
                .reward(requestDTO.getReward())
                .deadline(requestDTO.getDeadline())
                .missionSpec(requestDTO.getMissionSpec())
                .store(store)
                .build();
    }
}
