package com.board.board.service;

import com.board.board.domain.Member;
import com.board.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public List<Member> findAll() {
        List<Member> members = new ArrayList<>();
        return members = memberRepository.findAll();
    }
    public Optional<Member> findById(Long mbrNo) {
        Optional<Member> member = memberRepository.findById(mbrNo); //null 검사를 하지 않아도 된다
        return member;
    }

    public void deleteById(Long mbrNo) {
        memberRepository.deleteById(mbrNo);
    }
    public Member save(Member member) {
        memberRepository.save(member);
        return member;
    }

    public void updateById(Long mbrNo, Member member) {
        Optional <Member> e = memberRepository.findById(mbrNo);
        if(e.isPresent()) {
            e.get().setMbrNo(member.getMbrNo());
            e.get().setId(member.getId());
            e.get().setName(member.getName());
            memberRepository.save(member);
        }
    }
}
