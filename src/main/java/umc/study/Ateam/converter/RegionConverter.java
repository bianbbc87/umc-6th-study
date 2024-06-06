package umc.study.Ateam.converter;

import org.springframework.stereotype.Component;
import umc.study.Ateam.domain.Region;
import umc.study.Ateam.domain.Store;
import umc.study.Ateam.web.dto.StoreRequestDTO;

@Component
public class RegionConverter {
    public Store toStoreEntity(StoreRequestDTO requestDTO, Region region) {
        return Store.builder()
                .name(requestDTO.getName())
                .address(requestDTO.getAddress())
                .region(region)
                .build();
    }
}
