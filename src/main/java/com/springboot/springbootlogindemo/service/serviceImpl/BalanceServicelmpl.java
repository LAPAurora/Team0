package com.springboot.springbootlogindemo.service.serviceImpl;
import java.util.List;
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
    public Balance checkService(String cardId){
    Balance CurrentBalance=balanceDao.findByCardId(cardId);
    if (CurrentBalance!=null)
    {
        return CurrentBalance;

    }
    return null;
    }
    @Override
    public Balance bindService(Balance balance){
        return balanceDao.save(balance);
    }
    @Override
    public List<Balance> findcardsService(int uid){
        return balanceDao.findByUid(uid);
    }

}
