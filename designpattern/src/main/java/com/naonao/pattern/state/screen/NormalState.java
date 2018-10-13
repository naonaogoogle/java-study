package com.naonao.pattern.state.screen;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description:
 * @Author: HuangHaodong
 * @Date: 2018/10/14 01:41
 */
@Slf4j
public class NormalState extends State {

    @Override
    void display() {
        log.info("正常大小!");
    }
}
