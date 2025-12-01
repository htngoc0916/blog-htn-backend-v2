package com.htn.i18n;

public enum FileMessages implements MessageKey {
    FILE_DOWNLOAD_FAIL("file.download-fail"),
    FILE_UPLOAD_FAIL("file.upload-fail"),
    FILE_DELETE_FAIL("file.delete-fail"),
    FILE_NOT_FOUND("file.not-found"),
    FILE_DIRECTORY_CREATION_FAIL("file.directory-creation-fail");

    private final String key;
    FileMessages(String key) {this.key = key;}

    @Override
    public String getKey(){
        return this.key;
    }
}
