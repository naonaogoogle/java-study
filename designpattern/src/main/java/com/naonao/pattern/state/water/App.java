package com.naonao.pattern.state.water;

/**
 * @Description:
 * @Author: HuangHaodong
 * @Date: 2018/10/13 20:56
 */
public class App {

    public static void main(String[] args) {

        Water water = new Water();
        water.setAbstractWaterState(new LiquidState());
        water.warming(80);
        water.lowerTemperaturn(200);
        water.warming(100);
    }
}
