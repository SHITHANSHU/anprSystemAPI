package io.dropwizard.api;

public class tolldata {
    public String code;
    public String exception;

    public tolldata(String code, String exception) {
        this.code = code;
        this.exception = exception;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}
