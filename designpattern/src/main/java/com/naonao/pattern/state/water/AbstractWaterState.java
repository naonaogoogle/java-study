package com.naonao.pattern.state.water;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 抽象状态类
 *
 * @Author: HuangHaodong
 * @Date: 2018/10/13 20:35
 */
@Slf4j
public abstract class AbstractWaterState {

    @Setter
    protected Water context;


    /**
     * 升温:影响状态变化的因素
     *
     * @param temperature
     */
    protected abstract void warming(int temperature);


    /**
     * 降温:影响状态变化的因素
     *
     * @param temperature
     */
    protected abstract void lowerTemperature(int temperature);

    /**
     * 状态切换
     */
    public void stateChange() {
        int temperature = context.getTemperature();
        log.info("stateChange is start temperature:{}",temperature);
        if (temperature < 0) {
            context.setAbstractWaterState(new SolidState());
            log.info("水变成固态");
        }else if (temperature > 0 && temperature < 100) {
            context.setAbstractWaterState(new LiquidState());
            log.info("水变成液态");
        } else if (temperature > 100 ) {
            context.setAbstractWaterState(new GaseousState());
            log.info("水变成气态");
        }

    }






}
