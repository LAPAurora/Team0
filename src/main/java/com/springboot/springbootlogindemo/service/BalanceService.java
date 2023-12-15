package com.springboot.springbootlogindemo.service;

import com.springboot.springbootlogindemo.domain.Balance;
import java.util.List;



public interface BalanceService {
    /**
     * 登录业务逻辑
     * @param cardId 卡号
     * @return
     */
    Balance checkService (String cardId);

    /**
     * 查询银行卡
     * @param uid
     * @return
     */
    List<Balance> findcardsService(int uid);

    Balance bindService(Balance balance);




}
