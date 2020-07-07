package com.arnold.arnold;

/**
 * Copyright (C), 2016-2020, 江苏柠檬网络科技有限公司
 *
 * @FileName: SingleResponsibilityPrinciple
 * @Author: Arnold
 * @Date: 2020/7/7 16:17
 * @Description: 单一职责原则
 * @History:
 * @Version: 1.0.0
 * 定义：不要存在多于一个导致类变更的原因
 * 一个类一个接口、或者一个方法只负责一项职责
 * <p>
 * 优点：降低类的复杂度
 * 提高类的可读性
 * 提高系统的可维护性
 * 降低变更引起的风险
 */
public class SingleResponsibilityPrinciple {

    static class Course {
        /*一个方法负责两个职责*/
        public void study(String courseName) {
            if ("直播".equals(courseName)) {
                System.out.println("不能快进");
            } else {
                System.out.println("可以任意来回播放");
            }
        }
    }

    static class LiveCourse {
        public void study(String courseName) {
            System.out.println("不能快进");
        }
    }

    static class ReplayCourse {
        public void study(String courseName) {
            System.out.println("可以任意来回播放");
        }
    }

    /*展示的职责*/
    interface ICourseInfo {
        String getCourseName();

        byte[] getCourseVideo();
    }

    /*权限的职责*/
    interface ICourseManage {
        void stadyCourse();

        void refundCourse();
    }

    /*更清新*/
    static class CourseImpl implements ICourseInfo, ICourseManage {

        @Override
        public String getCourseName() {
            return null;
        }

        @Override
        public byte[] getCourseVideo() {
            return new byte[0];
        }

        @Override
        public void stadyCourse() {

        }

        @Override
        public void refundCourse() {

        }
    }


    /*单一修改某一个属性  实现单一职责原则*/
    void modifyUserInfo(String userName, String userAddress) {
        userName="Arnold";
        userAddress="CHANG";
    }

    void modifyUserName(String userName) {

    }
    void modifyUserAddress(String userAddress) {

    }

}
