package com.htn.i18n;

public enum CommonMessages implements MessageKey {
    COMMON_SUCCESS("common.success"),
    COMMON_FAIL("common.fail"),
    COMMON_SAVED("common.saved"),
    COMMON_UPDATED("common.updated"),
    COMMON_DELETED("common.deleted"),
    COMMON_NOT_FOUND("common.not-found");

    private final String key;
    CommonMessages(String key) {this.key = key;}

    @Override
    public String getKey(){
        return this.key;
    }
}
