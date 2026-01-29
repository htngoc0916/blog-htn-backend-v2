package com.htn.i18n;

public enum AuthMessages implements MessageKey {
    AUTH_LOGIN_SUCCESS("auth.login-success"),
    AUTH_LOGIN_FAIL("auth.login-fail"),
    AUTH_SIGNUP_SUCCESS("auth.signup-success"),
    AUTH_INVALID_CREDENTIALS("auth.invalid-credentials"),
    AUTH_ACCESS_DENIED("auth.access-denied"),
    AUTH_TOKEN_EXPIRED("auth.token-expired"),
    AUTH_REFRESH_TOKEN_SUCCESS("auth.refresh-token-success"),
    AUTH_VERIFY_CODE_INCORRECT("auth.verify-code-incorrect"),
    AUTH_LOGOUT_SUCCESS("auth.logout-success"),
    AUTH_LOGOUT_FAIL("auth.logout-fail");

    private final String key;
    AuthMessages(String key) {this.key = key;}

    @Override
    public String getKey(){
        return this.key;
    }
}
