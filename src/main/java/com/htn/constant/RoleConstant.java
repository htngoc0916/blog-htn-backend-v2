package com.htn.constant;

public enum RoleConstant {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    private final String value;
    RoleConstant(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}