package com.example.demomo.service.memberService;


import com.example.demomo.dto.MemberDTO;
import com.example.demomo.entity.Member;

public interface MemberService {

     int Join(MemberDTO memberDto);

     int login(Member member);

     int logout();

     int deleteMember(Long memberNumber);

}
