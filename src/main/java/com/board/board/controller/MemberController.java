package com.board.board.controller;

import com.board.board.domain.Member;
import com.board.board.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("memberTest")
public class MemberController {
    @Autowired
    MemberService memberService;

    //모든 회원 조회
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Member>> getAllmembers() {
        List<Member> member = memberService.findAll();
//        System.out.println(member);
        return new ResponseEntity<List<Member>>(member, HttpStatus.OK);
    }

    @GetMapping(value = "/{mbrNo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Member> getMember(@PathVariable("mbrNo") Long mbrNo) {
        Optional<Member> member = memberService.findById(mbrNo);
        System.out.println(member);
        return new ResponseEntity<Member> (member.get(), HttpStatus.OK);
    }
    @DeleteMapping(value = "/{mbrNo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> deleteMember(@PathVariable("mbrNo") Long mbrNo) {
        memberService.deleteById(mbrNo);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
    @PutMapping(value = "/{mbrNo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Member> updateMember(@PathVariable("mbrNo") Long mbrNo, Member member) {
        memberService.updateById(mbrNo, member);
        return new ResponseEntity<Member>(member, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Member> save(Member member) {
        return new ResponseEntity<Member>(memberService.save(member), HttpStatus.OK);
    }
    @RequestMapping(value="/saveMember", method = RequestMethod.GET)
    public ResponseEntity<Member> save(HttpServletRequest req, Member member) {
        return new ResponseEntity<Member>(memberService.save(member), HttpStatus.OK);
    }
}
