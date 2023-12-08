package com.springboot.springbootlogindemo.controller;

import com.springboot.springbootlogindemo.domain.Balance;
import com.springboot.springbootlogindemo.service.BalanceService;
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
        double money = balanceService.checkService(cardId);
        if(money!=-1.0){
            return Result.success(money,"余额如下:");
        }else{
            return Result.error("007","余额查询失败");
        }
    }


}
