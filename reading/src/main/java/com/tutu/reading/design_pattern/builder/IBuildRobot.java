package com.tutu.reading.design_pattern.builder;

/**
 * @Description:
 * @Author: hxf
 * @CreateDate: 2020/12/18 15:58
 * @Version: 1.0
 */
public interface IBuildRobot {

    void buildHead();

    void buildBody();

    void buildHand();

    void buildFoot();

    Robot createRobot();
}
