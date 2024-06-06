package umc.study.Ateam.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.Ateam.repository.MemberRepository;
import umc.study.Ateam.web.dto.MemberRequestDTO;
import umc.study.Ateam.domain.Member;
import umc.study.Ateam.converter.MemberConverter;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    @Override
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        return null;
    }
}