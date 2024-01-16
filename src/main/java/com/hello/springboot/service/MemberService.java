package com.hello.springboot.service;

import com.hello.springboot.domain.Member;
import com.hello.springboot.repository.MemberRepository;
import com.hello.springboot.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {
        getValidateDuplicatemember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void getValidateDuplicatemember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException(m.getId() + "는 이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}






