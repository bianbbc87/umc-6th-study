package umc.study.Ateam.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.Ateam.apiPayload.ApiResponse;
import umc.study.Ateam.domain.Store;
import umc.study.Ateam.service.RegionService;
import umc.study.Ateam.web.dto.StoreRequestDTO;

@RestController
@RequestMapping("/regions")
@RequiredArgsConstructor
public class RegionController {
    private final RegionService regionService;

    @PostMapping("/{regionId}/stores")
    public ApiResponse<Store> addStoreToRegion(@PathVariable Long regionId, @RequestBody StoreRequestDTO requestDTO) {
        Store store = regionService.addStoreToRegion(regionId, requestDTO);
        return ApiResponse.onSuccess(store);
    }
}
