package com.arnold.dolphinbay;

/**
 * Copyright (C), 2016-2020, 江苏柠檬网络科技有限公司
 *
 * @FileName: DependencyInversion
 * @Author: Arnold
 * @Date: 2020/7/7 15:56
 * @Description: 依赖倒置原则定义
 * @History:
 * @Version: 1.0.0
 * 定义：高层模块不应该依赖底层模块，二者都应该依赖其抽象
 * 抽象不应该依赖细节，细节应该依赖抽象
 * 针对接口编程，不要针对实现编程
 * 优点：可以减少类之间的耦合性，提高系统稳定性，提高代码可读性和可维护性，可减低修改程序所造成的风险
 */
public class DependencyInversion {

    public interface ICourse {
        void study();
    }

    public static class Tom {
        public Tom() {
        }

        /*V 1.0 版本*/
        public void studyJavaCourse() {
            System.out.println("study Java course");
        }

        public void studyPythonCourse() {
            System.out.println("study Python course");
        }

        public void studyAICourse() {
            System.out.println("study AI course");
        }

        /*V 2.0 版本*/
        public void study(ICourse iCourse) {
            iCourse.study();
        }

        /*V 3.0 版本*/
        ICourse iCourse;

        public Tom(ICourse iCourse) {
            this.iCourse = iCourse;
        }

        public void study() {
            iCourse.study();
        }
        /*V 4.0 版本 如 Tom 是一个单例模式 可以使用set方法注入*/

        public void setCourse(ICourse iCourse) {
            this.iCourse = iCourse;
        }
    }

    public static class JavaCourse implements ICourse {

        @Override
        public void study() {
            System.out.println("study Java course");
        }
    }

    public static void main(String[] args) {
        Tom tom = new Tom();

        tom.studyJavaCourse();
        tom.studyPythonCourse();
        tom.studyAICourse();

        /*注入的方式实现依赖倒置*/
        tom.study(new JavaCourse());
        /*构造方法方式实现依赖倒置*/
        new Tom(new JavaCourse()).study();
        /*set方法注入实现依赖倒置*/
        tom.setCourse(new JavaCourse());
        tom.study();
    }
}
