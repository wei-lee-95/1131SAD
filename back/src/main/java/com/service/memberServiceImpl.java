package com.service;

import com.dao.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.Member;

@Service
public class memberServiceImpl implements MemberService{

    @Autowired
    private MemberRepository memberRepository;
    
    @Override
    public Member getMemberByID(int memberID){
        return memberRepository.findById(memberID).orElse(null);
    }
    
}
