package com.htn.i18n;

public enum AuthMessages implements MessageKey {
    AUTH_LOGIN_SUCCESS("auth.login-success"),
    AUTH_LOGIN_FAIL("auth.login-fail"),
    AUTH_INVALID_CREDENTIALS("auth.invalid-credentials"),
    AUTH_ACCESS_DENIED("auth.access-denied"),
    AUTH_TOKEN_EXPIRED("auth.token-expired");

    private final String key;
    AuthMessages(String key) {this.key = key;}

    @Override
    public String getKey(){
        return this.key;
    }
}
