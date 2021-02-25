package com.tutu.reading.design_pattern.builder;

/**
 * @Description: 会跳机械舞的机器实现了IBuildRobot造机器人标准的接口
 * @Author: hxf
 * @CreateDate: 2020/12/18 15:59
 * @Version: 1.0
 */
public class DanceRobotBuilder implements IBuildRobot {

    Robot robot;

    public DanceRobotBuilder() {
        robot = new Robot();
    }

    @Override
    public void buildHead() {
        robot.setHead("写入机械舞程序");
    }

    @Override
    public void buildBody() {
        robot.setBody("钛合金身体");
    }

    @Override
    public void buildHand() {
        robot.setHand("钛合金手");
    }

    @Override
    public void buildFoot() {
        robot.setFoot("钛合金脚");
    }

    @Override
    public Robot createRobot() {
        return robot;
    }
}
