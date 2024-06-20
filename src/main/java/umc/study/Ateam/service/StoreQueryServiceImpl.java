package umc.study.Ateam.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.Ateam.domain.Mission;
import umc.study.Ateam.domain.Review;
import umc.study.Ateam.domain.Store;
import umc.study.Ateam.repository.MissionRepository;
import umc.study.Ateam.repository.ReviewRepository;
import umc.study.Ateam.repository.StoreRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreQueryServiceImpl implements StoreQueryService{

    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewList(Long StoreId, Integer page) {
        Store store = storeRepository.findById(StoreId).get();

        Page<Review> StorePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
        return StorePage;
    }

    // 내가 작성한 리뷰 조회
    @Override
    public Page<Review> getMemberReviewList(Long memberId, Integer page) {
        Page<Review> MemberPage = reviewRepository.findAllByMemberId(memberId, PageRequest.of(page, 10));
        return MemberPage;
    }

    @Override
    public Page<Mission> getMissionList(Long storeId, Integer page) {
        Page<Mission> MissionPage = missionRepository.findAllByStoreId(storeId, PageRequest.of(page, 10));
        return MissionPage;
    }
}
