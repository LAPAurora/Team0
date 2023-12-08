package com.springboot.springbootlogindemo.service;

import com.springboot.springbootlogindemo.domain.Balance;



public interface BalanceService {
    /**
     * 登录业务逻辑
     * @param cardId 卡号
     * @return
     */
    Balance checkService (String cardId);

}
