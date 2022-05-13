package com.board.board.repository;

import com.board.board.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    public List<Member> findById(String id);
    public List<Member> findByName(String name);
    public List<Member> findByNameLike(String keyword);
}