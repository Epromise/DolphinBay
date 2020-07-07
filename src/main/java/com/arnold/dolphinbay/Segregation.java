package com.arnold.dolphinbay;

/**
 * Copyright (C), 2016-2020, 江苏柠檬网络科技有限公司
 *
 * @FileName: Segregation
 * @Author: Arnold
 * @Date: 2020/7/7 16:49
 * @Description: 接口隔离原则定义
 * @History:
 * @Version: 1.0.0
 * 定义:用多个专门的接口，而不是使用单一的总接口，客户端不应该依赖它不需要的接口
 * <p>
 * 注意: 一个类对应一个类的依赖应该建立在最小的接口上
 * 建立单一接口，不要建立庞大臃肿的解耦
 * 尽量细化接口，接口中的方法尽量少
 * 细离化 注意适度原则，一定要适度
 */
public class Segregation {

    /*实现接口隔离   吃，飞，游泳  不存在都会的动物*/
    interface IAnimals {
        void eat();

        void fly();

        void swim();
    }

    public class Bird implements IAnimals {

        @Override
        public void eat() {
            System.out.println("eat");
        }

        @Override
        public void fly() {
            /*鸵鸟不会飞*/
            System.out.println("fly");
        }

        @Override
        public void swim() {
            /*只能空置*/
        }
    }

    /*实现接口隔离*/
    interface IEatAnimals {
        void eat();
    }

    interface IFlyAnimals {
        void fly();
    }

    interface ISwimAnimals {
        void swim();
    }

    class Dog implements IEatAnimals,ISwimAnimals{

        @Override
        public void eat() {
            System.out.println("eat");
        }

        @Override
        public void swim() {
            System.out.println("swim");
        }
    }
}
