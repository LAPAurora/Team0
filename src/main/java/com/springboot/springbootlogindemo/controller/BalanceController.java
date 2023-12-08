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
    public Result<Balance> checkController(@RequestParam String cardId){
        Balance balance = balanceService.checkService(cardId);
        double money = balance.getBalance();
        return Result.success(balance,"余额如下:");
    }


}
