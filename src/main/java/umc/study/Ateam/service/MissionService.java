package umc.study.Ateam.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.Ateam.apiPayload.code.status.ErrorStatus;
import umc.study.Ateam.apiPayload.exception.handler.AppHandler;
import umc.study.Ateam.converter.MissionConverter;
import umc.study.Ateam.domain.Mission;
import umc.study.Ateam.domain.Store;
import umc.study.Ateam.repository.MissionRepository;
import umc.study.Ateam.repository.StoreRepository;
import umc.study.Ateam.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MissionService {
    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;
    private final MissionConverter missionConverter;

    public Mission addMissionToStore(Long storeId, MissionRequestDTO requestDTO) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new AppHandler(ErrorStatus.MISSION_NOT_FOUND));
        Mission mission = missionConverter.toMissionEntity(requestDTO, store);
        return missionRepository.save(mission);
    }
}
