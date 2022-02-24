package com.example.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Enumerated;

@AllArgsConstructor
@Getter
public enum Role {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    private String value;
}
