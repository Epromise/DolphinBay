package com.arnold.dolphinbay;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2016-2020, 江苏柠檬网络科技有限公司
 *
 * @FileName: Dimitar
 * @Author: Arnold
 * @Date: 2020/7/7 17:02
 * @Description: 迪米特法则/最少知道原则
 * @History:
 * @Version: 1.0.0
 * 定义：一个对象应该对其他对象保持最少的了解。又叫最少知道原则
 * <p>
 * 尽量降低类与类之间的耦合
 * 优点：降低类之间的耦合
 * 强调之和朋友交流，不和陌生人说话
 * 朋友:出现在成员变量、方法的输入、输出参数中的类成为成员朋友类，而现在方法体内部的类不属于朋友类。
 */
public class Dimitar {

    /*课程*/
    static class Course {

    }

    /*员工*/
    static class Employee {
        void checkNumberOfCourses(List<Course> courseList) {
            System.out.println("=====" + courseList.size());
        }
        /*改造调用者TeamLeader不需要知道什么课程，只需知道多少数量*/
        void checkNumberOfCourses(){
            List<Course> courses = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                courses.add(new Course());
            }
            System.out.println("=====" + courses.size());
        }
    }

    /**/
    static class TeamLeader {
        /**/
        void commandCheckNumber(Employee employee) {
            List<Course> courses = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                courses.add(new Course());
            }
            employee.checkNumberOfCourses(courses);
        }
        /*更改Leader不需要了解课程，只需要知道结果*/
        void commandReviseCheckNumber(Employee employee) {
            employee.checkNumberOfCourses();
        }

    }
    /**/
    public static void main(String[] args) {
        TeamLeader teamLeader=new TeamLeader();
        Employee employee = new Employee();
        teamLeader.commandCheckNumber(employee);
    }
}
