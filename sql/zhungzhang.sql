CREATE FUNCTION transfer(
   from_account INT,
   to_account INT,
   amount DECIMAL(10, 2),
   transfer_time DATETIME
) RETURNS BOOLEAN
BEGIN
   DECLARE success BOOLEAN DEFAULT FALSE;
   DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET success = FALSE;
   
   START TRANSACTION -- 开始事务
   
   -- 查询账户余额
   SELECT balance INTO @from_balance FROM account WHERE account_id = from_account FOR UPDATE;
   SELECT balance INTO @to_balance FROM account WHERE account_id = to_account FOR UPDATE;
   
   -- 检查余额是否充足
   IF @from_balance >= amount THEN
      -- 执行转账操作
      UPDATE account SET balance = balance - amount WHERE account_id = from_account;
      UPDATE account SET balance = balance + amount WHERE account_id = to_account;
      
      -- 记录转账时间
      UPDATE account SET transfer_time = transfer_time WHERE account_id = from_account;
      UPDATE account SET transfer_time = transfer_time WHERE account_id = to_account;
      
      SET success = TRUE;
   ENDIF;
   
   COMMIT; -- 提交事务
   
   RETURN success;
END;
