package com.naonao.pattern.state.account;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 正常状态:具体状态类
 * @Author: HuangHaodong
 * @Date: 2018/10/14 00:16
 */
@Slf4j
class NormalState extends AccountState {

    NormalState(Account account) {
        this.account = account;
    }

    public NormalState(AccountState accountState) {
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
        log.info("正常状态,无需支付利息!");
    }

    /**
     *
     */
    @Override
    void stateCheck() {
        if (account.getBalance() > -2000 && account.getBalance() <= 0) {
            account.setAccountState(new OverdraftState(this));
        } else if (account.getBalance() == -2000) {
            account.setAccountState(new RestrictedState(this));
        } else if (account.getBalance() < -2000) {
            log.info("操作受限");
        }
    }
}
