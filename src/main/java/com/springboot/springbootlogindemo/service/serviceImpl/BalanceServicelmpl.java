package com.springboot.springbootlogindemo.service.serviceImpl;

import com.springboot.springbootlogindemo.domain.Balance;
import com.springboot.springbootlogindemo.repository.BalanceDao;
import com.springboot.springbootlogindemo.service.BalanceService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
@Service
public class BalanceServicelmpl implements BalanceService {
    @Resource
    private BalanceDao balanceDao;

    @Override
    public double checkService(String cardId){
    Balance CurrentBalance=balanceDao.findByCardId(cardId);
    if (CurrentBalance!=null)
    {
        return CurrentBalance.getBalance();

    }
    return -1.0;
    }

}
