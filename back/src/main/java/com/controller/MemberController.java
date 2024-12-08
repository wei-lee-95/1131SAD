package com.controller;

import org.springframework.web.bind.annotation.RestController;

import com.dao.Member;

import com.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class MemberController {
    
    @Autowired
    private MemberService memberService;

    @GetMapping("/member/{memberID}")
    public Member getMemberById(@PathVariable int memberID){
        return memberService.getMemberByID(memberID);
    }

    @GetMapping("/hello")
    public String getMethodName(){
        return "hello";
    }
    
}
