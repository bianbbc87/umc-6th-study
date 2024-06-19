package umc.study.Ateam.service;

import umc.study.Ateam.web.dto.MemberRequestDTO;
import umc.study.Ateam.domain.Member;

public interface MemberCommandService {
    public Member joinMember(MemberRequestDTO.JoinDto request);
}
