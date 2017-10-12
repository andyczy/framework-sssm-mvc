package org.chenzhengyou.com.ssm.common.utils.exceptionData;

/**
 * Created by czy on 2016/10/29.<br>
 * 异常信息
 */
public class CustomException extends Exception {
    //
    private String message;

    public CustomException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
