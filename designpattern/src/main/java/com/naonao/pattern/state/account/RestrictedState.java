package com.naonao.pattern.state.account;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description:
 * @Author: HuangHaodong
 * @Date: 2018/10/14 00:41
 */
@Slf4j
public class RestrictedState extends AccountState {

    public RestrictedState(AccountState accountState) {
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
        log.info("账号受限,取款失败");
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
        } else if (account.getBalance() > -2000) {
            account.setAccountState(new OverdraftState(this));
        }
    }
}
