package com.naonao.pattern.state.account;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 透支状态
 * @Author: HuangHaodong
 * @Date: 2018/10/14 00:36
 */
@Slf4j
public class OverdraftState extends AccountState {

    public OverdraftState(AccountState accountState) {
        this.account = accountState.account;
    }

    /**
     * @param amount
     */
    @Override
    void deposit(double amount) {
        account.setBalance(account.getBalance() + amount);
        stateCheck();
    }

    /**
     * @param amount
     */
    @Override
    void withdraw(double amount) {
        account.setBalance(account.getBalance() - amount);
        stateCheck();
    }

    /**
     *
     */
    @Override
    void computeInterest() {
        log.info("计算利息");
    }

    /**
     *
     */
    @Override
    void stateCheck() {
        if (account.getBalance() > 0) {
            account.setAccountState(new NormalState(this));
        } else if (account.getBalance() == -2000) {
            account.setAccountState(new RestrictedState(this));
        } else if (account.getBalance() < -2000) {
            log.info("操作受限");
        }
    }
}
