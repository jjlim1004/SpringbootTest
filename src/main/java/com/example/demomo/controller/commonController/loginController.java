package com.example.demomo.controller.commonController;


import com.example.demomo.dto.MemberDTO;
import com.example.demomo.entity.Member;
import com.example.demomo.service.kakaoService.KakaoAPI;
import com.example.demomo.service.memberService.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class loginController {

    @Autowired
    private KakaoAPI kakaoAPI;

    @Autowired
    private MemberService memberService;

    @GetMapping("/")
    public String index(){
        return "login";
    }

    @GetMapping("/login")
    public String loginPage(Member member , HttpSession session){

        return "login";
    }

    @PostMapping("/login")
    public String login(MemberDTO member, HttpSession session){

        return "lobbyPage";
    }

    @GetMapping("/join")
    public void goToMemberJoin(){
    }

    @PostMapping("/join")
    @ResponseBody
    public ResponseEntity memberJoin(MemberDTO memberDto){
        memberService.Join(memberDto);
        MemberDTO member = memberDto;
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @GetMapping("/myPage")
    public void goMyPage(){
    }

    @PostMapping("/myPage")
    public void getKakaoinfo(@RequestParam("code") String code , HttpSession session){
        String access_token = kakaoAPI.getAccessToken(code);

        System.out.println("controller access_token : " + access_token);

        HashMap<String,Object> userInfo = kakaoAPI.getUserInfo(access_token);

        for(Map.Entry<String,Object> entry : userInfo.entrySet()){
            System.out.println("!!! " + entry.getKey() + "  : " + entry.getValue());
        }

        if (userInfo.get("email") != null) {
            session.setAttribute("userId", userInfo.get("email"));
            session.setAttribute("access_Token", access_token);
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){

        return "index";
    }

}

