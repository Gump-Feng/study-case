package com.tutu.reading.design_pattern.builder;

/**
 * @Description:
 * @Author: hxf
 * @CreateDate: 2020/12/18 16:02
 * @Version: 1.0
 */
public class BuilderTest {

    public static void main(String[] args) {
        Director director = new Director();
        Robot robot = director.createRobotByDirector(new DanceRobotBuilder());
        System.out.println(robot.getHead());
        System.out.println(robot.getBody());
        System.out.println(robot.getHand());
        System.out.println(robot.getFoot());
        System.out.println("机器人创建成功，恭喜！");
    }
}
