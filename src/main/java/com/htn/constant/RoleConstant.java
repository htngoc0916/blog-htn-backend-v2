package com.htn.constant;

import lombok.Getter;

@Getter
public enum RoleConstant {
    ROLE_ADMIN("ADMIN"),
    ROLE_USER("USER"),
    ROLE_EDITOR("EDITOR"),
    ROLE_MODERATOR("MODERATOR");

    private final String code;
    RoleConstant(String code) {this.code = code;}
}