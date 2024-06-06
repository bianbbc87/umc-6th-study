package umc.study.Ateam.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.Ateam.apiPayload.code.status.ErrorStatus;
import umc.study.Ateam.converter.MemberPreferConverter;
import umc.study.Ateam.domain.FoodCategory;
import umc.study.Ateam.domain.mapping.MemberPrefer;
import umc.study.Ateam.repository.FoodCategoryRepository;
import umc.study.Ateam.repository.MemberRepository;
import umc.study.Ateam.web.dto.MemberRequestDTO;
import umc.study.Ateam.domain.Member;
import umc.study.Ateam.converter.MemberConverter;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}