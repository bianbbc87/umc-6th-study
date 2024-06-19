package umc.study.Ateam.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.Ateam.apiPayload.code.status.ErrorStatus;
import umc.study.Ateam.apiPayload.exception.handler.AppHandler;
import umc.study.Ateam.converter.RegionConverter;
import umc.study.Ateam.domain.Region;
import umc.study.Ateam.domain.Store;
import umc.study.Ateam.repository.RegionRepository;
import umc.study.Ateam.repository.StoreRepository;
import umc.study.Ateam.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class RegionService {
    private final RegionRepository regionRepository;
    private final StoreRepository storeRepository;
    private final RegionConverter regionConverter;

    public Store addStoreToRegion(Long regionId, StoreRequestDTO requestDTO) {
        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new AppHandler(ErrorStatus.REGION_NOT_FOUND));
        Store store = regionConverter.toStoreEntity(requestDTO, region);
        return storeRepository.save(store);
    }
}
