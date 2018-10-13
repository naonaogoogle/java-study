package com.naonao.pattern.state.water;

/**
 * @Description:
 * @Author: HuangHaodong
 * @Date: 2018/10/13 20:46
 */
public class LiquidState extends AbstractWaterState {
    /**
     * 升温:影响状态变化的因素
     *
     * @param temperature
     */
    @Override
    protected void warming(int temperature) {
        super.context.setTemperature(super.context.getTemperature() + temperature);
        stateChange();
    }

    /**
     * 降温:影响状态变化的因素
     *
     * @param temperature
     */
    @Override
    protected void lowerTemperature(int temperature) {
        super.context.setTemperature(super.context.getTemperature() - temperature);
        stateChange();
    }
}
