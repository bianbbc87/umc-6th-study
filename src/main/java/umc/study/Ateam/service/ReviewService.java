package umc.study.Ateam.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.Ateam.apiPayload.code.status.ErrorStatus;
import umc.study.Ateam.apiPayload.exception.handler.AppHandler;
import umc.study.Ateam.converter.ReviewConverter;
import umc.study.Ateam.domain.Member;
import umc.study.Ateam.domain.Review;
import umc.study.Ateam.domain.Store;
import umc.study.Ateam.repository.MemberRepository;
import umc.study.Ateam.repository.ReviewRepository;
import umc.study.Ateam.repository.StoreRepository;
import umc.study.Ateam.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final ReviewConverter reviewConverter;

    public Review addReviewToStore(Long storeId, ReviewRequestDTO requestDTO) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new AppHandler(ErrorStatus.STORE_NOT_FOUND));
        Member member = memberRepository.findById(requestDTO.getMemberId())
                .orElseThrow(() -> new AppHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Review review = reviewConverter.toReviewEntity(requestDTO, store, member);
        return reviewRepository.save(review);
    }
}
