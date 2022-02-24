package com.example.crud.dto;

import com.example.crud.domain.entity.MemberEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String nickname;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public MemberEntity toEntity() {
        return  MemberEntity.builder()
                .id(id)
                .username(username)
                .password(password)
                .email(email)
                .nickname(nickname)
                .build();
    }

    @Builder
    public MemberDto(Long id, String username, String password, String email, String nickname, LocalDateTime createDate, LocalDateTime updateDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}
