package com.arnold.dolphinbay;

/**
 * Copyright (C), 2016-2020, 江苏柠檬网络科技有限公司
 *
 * @FileName: CloseAndOpen
 * @Author: Arnold
 * @Date: 2020/7/7 15:35
 * @Description: 开闭原则
 * @History:
 * @Version: 1.0.0
 * 定义:一个软件如实体类、模块和函数应该对扩展开放，对修改关闭。用抽象构建框架，用实现扩展细节
 * 优点:提高软件系统的可复用性及可维护性
 */
public final class CloseAndOpen {

    public interface ICourse {
        Integer getId();

        String getName();

        Double getPrice();
    }

    public static class JavaICourse implements ICourse {
        private Integer id;
        private String name;
        private Double price;

        public JavaICourse(Integer id, String name, Double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        @Override
        public Integer getId() {
            return id;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public Double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "JavaICourse{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

    public static class JavaDiscountICourse extends JavaICourse {
        public JavaDiscountICourse(Integer id, String name, Double price) {
            super(id, name, price);
        }
        /*
        打折逻辑,原价信息丢失
        @Override
        public Double getPrice() {
            return super.getPrice()*0.8;
        }*/

        /*新增打折获取方法*/
        public Double getDiscountPrice() {
            return super.getPrice() * 0.6;
        }

    }

    public static void main(String[] args) {
        ICourse iCourse = new JavaICourse(1, "JAVA", 100D);
        System.out.println(iCourse);
    }
}
