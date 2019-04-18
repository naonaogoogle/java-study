package com.naonao.pattern.state.account;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 银行账户:环境类
 * @Author: HuangHaodong
 * @Date: 2018/10/13 22:50
 */
@Slf4j
class Account {

    /**
     * 维持一个对抽象状态对象的引用
     */
    @Setter
    private AccountState accountState;

    /**
     * 开户名
     */

    private String owner;

    /**
     * 账户余额
     */
    @Getter @Setter
    private double balance = 0;

    Account(String owner, double balance) {
        this.accountState = new NormalState(this);
        this.owner = owner;
        this.balance = balance;
        log.info("{}开户,初始金额为{}",this.owner,balance);
        log.info("------------------------------------");
    }

    void deposit(double amount) {
        log.info("{}存款{}",this.owner,amount);
        accountState.deposit(amount);
        log.info("现在账户的余额为:{}",this.balance);
        log.info("现在账户的状态为:{}",this.accountState.getClass().getSimpleName());
        log.info("------------------------------------");
    }

    void withdraw(double amount) {
        log.info("{}取款{}",this.owner,amount);
        accountState.withdraw(amount);
        log.info("现在余额为{}",this.balance);
        log.info("现在账户的状态为{}",this.accountState.getClass().getSimpleName());
        log.info("------------------------------------");
    }

    void computeInterest() {
        accountState.computeInterest();
    }
}
