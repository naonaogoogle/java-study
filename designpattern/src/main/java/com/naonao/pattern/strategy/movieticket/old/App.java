package com.naonao.pattern.strategy.movieticket.old;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description:
 * @Author: HuangHaodong
 * @Date: 2018/10/14 12:55
 */
@Slf4j
public class App {

    public static void main(String[] args) {
        MovieTicket movieTicket = new MovieTicket();
        double originalPrice = 60.0;
        movieTicket.setPrice(originalPrice);
        log.info("原始价为:{}",originalPrice);
        log.info("--------------------------");
        movieTicket.setType("student");
        log.info("折后价格为:{}",movieTicket.calculate());
        log.info("--------------------------");
        movieTicket.setType("儿童票");
        log.info("折后价格为:{}",movieTicket.calculate());
        log.info("--------------------------");


    }
}
