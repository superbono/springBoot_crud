package com.example.crud.service;

import com.example.crud.domain.entity.MemberEntity;
import com.example.crud.domain.repository.MemberRepository;
import com.example.crud.dto.MemberDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberService {

    private final MemberRepository repository;

    public Long join(MemberDto dto) {
        return repository.save(dto.toEntity()).getId();
    }
}
