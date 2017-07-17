-- 秒杀执行的存储过程
DELIMITER $$   -- 将换行符由;改为$$
-- 定义存储过程
CREATE PROCEDURE seckill.execute_seckill
  (IN v_seckill_id BIGINT,IN v_phone BIGINT,IN v_kill_time TIMESTAMP,OUT r_result INT)
    BEGIN
    DECLARE insert_count INT DEFAULT 0;
    START TRANSACTION;
    INSERT IGNORE INTO success_killed
      (seckill_id,user_phone,create_time)
      VALUES (v_seckill_id,v_phone,v_kill_time);
    SELECT row_count() INTO insert_count;
    IF (insert_count = 0) THEN
      ROLLBACK ;
      SET r_result = -1;
    ELSEIF(insert_count<0) THEN
      ROLLBACK ;
      SET r_result = -2;
    ELSE
      UPDATE seckill
        SET number = number - 1
      WHERE seckill_id = v_seckill_id
      AND end_time > v_kill_time
      AND start_time < v_kill_time
      AND number > 0;
      SELECT row_count() INTO insert_count;
      IF (insert_count = 0) THEN
        ROLLBACK ;
        SET r_result = -1;
      ELSEIF(insert_count<0) THEN
        ROLLBACK ;
        SET r_result = -2;
      ELSE
        COMMIT ;
        set r_result = 1;
      END IF ;
    END IF ;
  END;
$$
-- 存储过程定义结束



DELIMITER ;
SET @r_result = -3;
-- 执行存储过程
CALL execute_seckill(1001,18862141550,now(),@r_result);
-- 获取结果
SELECT @r_result;
