package com.springboot.springbootlogindemo.repository;

import com.springboot.springbootlogindemo.domain.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceDao extends JpaRepository<Balance, String> {
    Balance findByCardId(String cardId);
}
