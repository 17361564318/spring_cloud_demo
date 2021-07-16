package com;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author fhn
 * @create 2021/7/5
 * @software idea
 */
public class Singleton {
    // volatile 关键字保证线程可见性以及防止指令重排
    private static volatile Singleton instance;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
    static class SingletonTest{
        public static void main(String[] args) {
            Singleton i1 = Singleton.getInstance();
            Singleton i2 = Singleton.getInstance();
            System.out.println(i1.hashCode());
        }
    }
}
