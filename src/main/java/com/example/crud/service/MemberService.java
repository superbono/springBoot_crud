package com.example.crud.service;

import com.example.crud.domain.entity.MemberEntity;
import com.example.crud.domain.repository.MemberRepository;
import com.example.crud.dto.MemberDto;
import com.example.crud.dto.Role;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService implements UserDetailsService {

    private final MemberRepository repository;

    public Long join(MemberDto dto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        dto.setPassword(encoder.encode(dto.getPassword()));
        System.out.println(dto);
        return repository.save(dto.toEntity()).getId();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MemberEntity> response = repository.findByUsername(username);
        MemberEntity entity = response.get();
        System.out.println("ENTITY: "+entity.getUsername());

        List<GrantedAuthority> authorities = new ArrayList<>();
        if(("admin").equals(username)) {
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(Role.USER.getValue()));
        }
        System.out.println("ROLE: "+authorities);
        return new User(entity.getUsername(),entity.getPassword(),authorities);

    }
}
