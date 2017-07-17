package org.seckill.exception;

/**
 * 描述相关异常
 * Created by cms on 2017/7/15.
 */
public class SeckillException extends RuntimeException {

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
