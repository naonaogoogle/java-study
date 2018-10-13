package com.naonao.pattern.state.screen;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description:
 * @Author: HuangHaodong
 * @Date: 2018/10/14 01:42
 */
@Slf4j
public class LargestState extends State {

    @Override
    void display() {
        log.info("四倍大小!");

    }
}
