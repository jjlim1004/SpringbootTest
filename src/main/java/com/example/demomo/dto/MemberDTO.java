package com.example.demomo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberDTO {
    private Long memberNumber;

    private String memberId;

    private String memberPw;

    private String memberName;

    private String email;

    private Role memberRole;

}
