package com.springboot.springbootlogindemo.repository;

import com.springboot.springbootlogindemo.domain.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BalanceDao extends JpaRepository<Balance, String> {
    /**
     * 根据卡号查询卡内余额
     * @param cardId
     * @return
     */
    Balance findByCardId(String cardId);

    /**
     * 根据uid查询绑定的银行卡
     * @param uid
     * @return
     */
    List<Balance> findByUid(int uid);

    /**
     * 绑定银行卡
     * @param balance
     * @return
     */
    Balance save(Balance balance);



}
