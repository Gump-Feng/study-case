package com.tutu.reading.design_pattern.builder;

/**
 * @Description:
 * @Author: hxf
 * @CreateDate: 2020/12/18 16:00
 * @Version: 1.0
 */
public class Director {

    public Robot createRobotByDirector(IBuildRobot ibr) {
        ibr.buildBody();
        ibr.buildFoot();
        ibr.buildHand();
        ibr.buildHead();
        return ibr.createRobot();
    }
}
