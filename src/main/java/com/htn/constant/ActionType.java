package com.htn.constant;

import lombok.Getter;

@Getter
public enum ActionType {
    CREATE("I"),
    UPDATE("U"),
    DELETE("D");
    private final String code;
    ActionType(String code) {this.code = code;}
}
