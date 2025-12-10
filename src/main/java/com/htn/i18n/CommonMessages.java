package com.htn.i18n;

public enum CommonMessages implements MessageKey {
    COMMON_SUCCESS("common.success"),
    COMMON_FAIL("common.fail"),
    COMMON_SAVED("common.saved"),
    COMMON_UPDATED("common.updated"),
    COMMON_DELETED("common.deleted"),
    COMMON_NOT_FOUND("common.data-not-found"),
    COMMON_NOT_FOUND_WITH("common.data-not-found-with"),
    COMMON_DATA_EXISTED("common.data-existed"),
    COMMON_DATA_EXISTED_WITH("common.data-existed-with"),
    COMMON_LENGTH_EXCEED_WITH("common.length-exceed-with");

    private final String key;
    CommonMessages(String key) {this.key = key;}

    @Override
    public String getKey(){
        return this.key;
    }
}
