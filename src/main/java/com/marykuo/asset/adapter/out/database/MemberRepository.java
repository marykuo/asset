package com.marykuo.asset.adapter.out.database;

import com.marykuo.asset.adapter.out.database.entity.MemberEntity;
import com.marykuo.asset.domain.member.Member;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface MemberRepository {
    MemberEntity save(Member member);

    Optional<MemberEntity> findById(Long memberId);

    Optional<MemberEntity> findByEmail(String email);

    Page<MemberEntity> findAll(Integer pageSize, Integer pageOffset, String sortBy, boolean isAscending);
}
