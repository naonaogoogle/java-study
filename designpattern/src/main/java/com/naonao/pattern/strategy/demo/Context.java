package com.naonao.pattern.strategy.demo;

/**
 * @Description: 策略模式主要是用了委托代理的方式.
 * @Author: HuangHaodong
 * @Date: 2019-04-06 15:22
 */
public class Context {

    private Strategy strategy;

    public Context setStrategy(Strategy strategy) {
        this.strategy = strategy;
        return this;
    }

    void algorithm() {
        strategy.algorithm();
    }


    public static void main(String[] args) {
        Context context = new Context();
        context.setStrategy(new ConcreteStrategyA());
        context.algorithm();
    }
}
