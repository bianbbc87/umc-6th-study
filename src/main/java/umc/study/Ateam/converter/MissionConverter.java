package umc.study.Ateam.converter;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import umc.study.Ateam.domain.Mission;
import umc.study.Ateam.domain.Review;
import umc.study.Ateam.domain.Store;
import umc.study.Ateam.web.dto.MissionRequestDTO;
import umc.study.Ateam.web.dto.MissionResponseDTO;
import umc.study.Ateam.web.dto.ReviewRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

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


    public static MissionResponseDTO.MissionPreViewDTO missionPreViewDTO(Mission mission) {
        return MissionResponseDTO.MissionPreViewDTO.builder()
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .missionSpec(mission.getMissionSpec())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public static MissionResponseDTO.MissionPreViewListDTO missionPreViewListDTO(Page<Mission> missionList) {

        List<MissionResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(MissionConverter::missionPreViewDTO).collect(Collectors.toList());

        return MissionResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }
}
