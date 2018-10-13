package com.naonao.pattern.state.water;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 水:相当于环境类(Context)
 * @Author: HuangHaodong
 * @Date: 2018/10/13 20:30
 */
@Slf4j
public class Water {

    private AbstractWaterState abstractWaterState;

    @Getter
    @Setter
    private int temperature = 50;


    void setAbstractWaterState(AbstractWaterState abstractWaterState) {
        this.abstractWaterState = abstractWaterState;
        // 将当前环境通知到对应状态类中
        this.abstractWaterState.setContext(this);
    }

    /**
     * 升温
     * @param temperature
     */
    void warming(int temperature) {
        log.info("温度升高{}度", temperature);
        this.abstractWaterState.warming(temperature);
        log.info("当前水的状态为:{},当前水的温度为:{}", this.abstractWaterState.getClass().getSimpleName(), getTemperature());
    }

    /**
     * 降温
     * @param temperature
     */
    void lowerTemperaturn(int temperature) {
        log.info("温度降低:{}度", temperature);
        this.abstractWaterState.warming(temperature);
        log.info("当前水的状态为:{},当前水的温度为:{}", this.abstractWaterState.getClass().getSimpleName(), getTemperature());
    }

}
