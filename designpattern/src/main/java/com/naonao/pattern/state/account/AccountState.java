package com.naonao.pattern.state.account;

/**
 * @Description: 抽象的状态类
 * @Author: HuangHaodong
 * @Date: 2018/10/13 22:53
 */
abstract class AccountState {

    Account account;

    /**
     *
     * @param amount
     */
    abstract void deposit(double amount);

    /**
     *
     * @param amount
     */
    abstract void withdraw(double amount);

    /**
     *
     */
    abstract void computeInterest();

    /**
     *
     */
    abstract void stateCheck();

}
