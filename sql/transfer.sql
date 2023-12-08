use testdb;
DELIMITER //
CREATE PROCEDURE transfer(
   IN from_account INT,
   IN to_account INT,
   IN amount DECIMAL(10, 2),
   OUT success BOOLEAN
)
BEGIN
   DECLARE from_balance DECIMAL(10, 2);

	DECLARE EXIT HANDLER FOR NOT FOUND
	BEGIN
		ROLLBACK;
		SET success = FALSE;
	END;

   DECLARE EXIT HANDLER FOR SQLEXCEPTION
   BEGIN
     ROLLBACK;
     SET success = FALSE;
   END;

   START TRANSACTION;
   
   -- 查询转出账户余额
   SELECT Balance INTO from_balance FROM account WHERE AccountID = from_account FOR UPDATE;
   
   -- 检查转出账户余额是否充足
   IF from_balance >= amount THEN
      
      -- 执行转账
      UPDATE account SET Balance = Balance - amount WHERE AccountID = from_account;
      UPDATE account SET Balance = Balance + amount WHERE AccountID = to_account;
      
      -- 记录转账
      INSERT INTO transfer(SenderAccountID,ReceiverAccountID,Amount,TransferDate) VALUES (from_account,to_account,amount,NOW());
      
      COMMIT;
      SET success = TRUE;
   ELSE
      ROLLBACK;
      SET success = FALSE;
   END IF;
END//
