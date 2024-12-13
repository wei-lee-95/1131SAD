package com.service;

import com.dao.Member;

import com.dao.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemberService {
    
    @Autowired
    private MemberRepository memberRepository;
    
    public Member getMemberByID(int memberID){
        return memberRepository.findById(memberID).orElse(null);
    }
}
