package com.htn.i18n;

public enum UserMessages implements MessageKey {
    USER_NOT_FOUND("user.not-found"),
    USER_BLOCKED("user.blocked"),
    USER_EMAIL_NOT_VERIFIED("user.email-not-verified"),
    USER_EMAIL_EXISTS("user.email-exists"),
    USER_CREATE_SUCCESS("user.create-success"),
    USER_UPDATE_SUCCESS("user.update-success");

    private final String key;
    UserMessages(String key) {this.key = key;}

    @Override
    public String getKey(){
        return this.key;
    }
}
