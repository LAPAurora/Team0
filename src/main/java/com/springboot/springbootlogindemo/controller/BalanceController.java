package com.springboot.springbootlogindemo.controller;

import com.springboot.springbootlogindemo.domain.Balance;
import com.springboot.springbootlogindemo.repository.BalanceDao;
import com.springboot.springbootlogindemo.service.BalanceService;
import com.springboot.springbootlogindemo.service.UserService;
import org.springframework.web.bind.annotation.*;
import com.springboot.springbootlogindemo.utils.Result;

import javax.annotation.Resource;

@RestController
@RequestMapping("/balance")
public class BalanceController {
    @Resource
    private BalanceService balanceService;

    @PostMapping("/check")
    public Result<Double> checkController(@RequestParam String cardId){
        boolean result=true;
        try {
            Balance balance = balanceService.checkService(cardId);
        }
        catch(Exception ex)
        {
            result = false;
         }
         {

             {
                Balance balance = balanceService.checkService(cardId);
                if (balance != null){
                double money = balance.getBalance();
                return Result.success(money, "余额如下:");}
                else return Result.error("100", "查询失败");
            }
        }
    }
    @PostMapping("/bind")
    public Result<Balance> bindController(@RequestParam String cardId,@RequestParam String uid,@RequestParam String balance){
        boolean result = true;
        Balance newBalance=new Balance();
        newBalance.setUid(Long.parseLong(uid));
        newBalance.setCardId(cardId);
        newBalance.setBalance(Double.parseDouble(balance));
        //try
        //{
        Balance resultBalance = balanceService.bindService(newBalance);
        //}
        //catch(Exception ex)
       // {
        //    result = false;
       // }
       return Result.success(resultBalance,"success");



    }


}
