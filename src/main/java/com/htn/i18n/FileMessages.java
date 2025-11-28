package com.htn.i18n;

public enum FileMessages implements MessageKey {
    FILE_DOWNLOAD_FAIL("file.download-fail"),;


    private final String key;
    FileMessages(String key) {this.key = key;}

    @Override
    public String getKey(){
        return this.key;
    }
}
