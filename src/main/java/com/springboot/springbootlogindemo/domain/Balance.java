package com.springboot.springbootlogindemo.domain;

import javax.persistence.*;

@Table(name = "balance")
@Entity
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String cardId;
    // cardID 卡号
    private String isReportLoss;
    // 是否挂失
    private double balance;
    //账户余额

    private long uid;
    //APP密码


    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getIsReportLoss() {
        return isReportLoss;
    }

    public void setIsReportLoss(String isReportLoss) {
        this.isReportLoss = isReportLoss;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }
}
