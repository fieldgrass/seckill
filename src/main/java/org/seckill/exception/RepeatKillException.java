package org.seckill.exception;

/**
 * 重复秒杀异常
 * Created by cms on 2017/7/15.
 */
public class RepeatKillException extends SeckillException{

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
