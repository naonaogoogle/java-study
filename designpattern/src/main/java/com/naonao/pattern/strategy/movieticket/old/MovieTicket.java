package com.naonao.pattern.strategy.movieticket.old;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description:
 * @Author: HuangHaodong
 * @Date: 2018/10/14 12:45
 */
@Slf4j
class MovieTicket {

    private static final String TICKET_TYPE_STUDENT = "student";
    private static final String TICKET_TYPE_CHILD = "儿童票";
    private static final String TICKET_TYPE_VIP = "VIP票";
    private static final int TICKET_PRICE = 10;

    /**
     * 电影票价格
     */
    @Setter @Getter
    private double price;

    /**
     * 电影票类型
     */
    @Setter @Getter
    private String type;

    double calculate() {
        if (this.type.equalsIgnoreCase(TICKET_TYPE_STUDENT)) {
            log.info("学生票");
            return this.price*0.8;
        } else if (this.type.equalsIgnoreCase(TICKET_TYPE_CHILD) && this.price > TICKET_PRICE) {
            log.info("儿童票");
            return this.price - TICKET_PRICE;
        } else if (this.type.equalsIgnoreCase(TICKET_TYPE_VIP)) {
            log.info("VIP票");
            log.info("增加积分");
            return this.price*0.5;
        } else {
            return this.price;
        }
    }
}

