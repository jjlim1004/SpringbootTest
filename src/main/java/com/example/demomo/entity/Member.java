package com.example.demomo.entity;

import com.example.demomo.dto.Role;
import lombok.*;


import javax.persistence.*;

@Entity(name = "member")
@NoArgsConstructor
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNumber;

    @Column(nullable=false)
    private String memberId;

    @Column(nullable=false)
    private String memberPw;

    @Column
    private String memberName;

    @Column
    private String memberEmail;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role memberRole;


    public String getRoleKey(){
        return this.memberRole.getKey();
    }

    @Builder
    public Member(String memberId, String memberPw, String memberName,
                  String memberEmail, Role memberRole) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberRole = memberRole;
    }
}
