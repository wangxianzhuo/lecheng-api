package com.github.wangxianzhuo.lecheng.api.wrapper;

/**
 * description: LechengApiWrapperException
 * date: 2021/4/18 11:28
 *
 * @author: shangjie
 * @version: 1.0
 */
public class LechengApiWrapperException extends Exception {
    public LechengApiWrapperException() {
    }

    public LechengApiWrapperException(String message) {
        super(message);
    }

    public LechengApiWrapperException(String message, Throwable cause) {
        super(message, cause);
    }
}
