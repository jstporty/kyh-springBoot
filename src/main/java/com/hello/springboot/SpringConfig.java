package com.hello.springboot;

import com.hello.springboot.repository.MemberRepository;
import com.hello.springboot.repository.MemoryMemberRepository;
import com.hello.springboot.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
