package umc.study.Ateam.service;

import umc.study.Ateam.web.dto.MemberRequestDTO;

import java.lang.reflect.Member;

public interface MemberCommandService {
    public Member joinMember(MemberRequestDTO.JoinDto request);
}
