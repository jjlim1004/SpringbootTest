package com.example.demomo.service.memberService;


import com.example.demomo.dto.MemberDTO;
import com.example.demomo.dto.Role;
import com.example.demomo.entity.Member;
import com.example.demomo.entity.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    MemberRepository memberRepository;


    @Override
    public int Join(MemberDTO memberDto) {
        memberDto.setMemberRole(Role.GUEST);
        Member member = Member.builder()
                .memberId(memberDto.getMemberId())
                .memberPw(memberDto.getMemberPw())
                .memberRole(memberDto.getMemberRole())
                .memberEmail(memberDto.getEmail())
                .memberName(memberDto.getMemberName())
                .build();
        memberRepository.save(member);
        return 0;
    }

    @Override
    public int login(Member member) {

        return 0;
    }

    @Override
    public int logout() {

        return 0;
    }

    @Override
    public int deleteMember(Long memberNumber) {

        return 0;
    }
}
