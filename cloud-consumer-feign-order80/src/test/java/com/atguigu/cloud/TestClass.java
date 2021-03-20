package com.atguigu.cloud;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;


/**
 * @author fhn
 * @create 2021/2/24
 */
@Slf4j
public class TestClass {

    private static Object obj1;
    private static Object obj2;

    @Before
    public void before() {
        obj1 = new Object();
        obj2 = new Object();
    }

    @Test
    public void test() throws Exception {

        FutureTask<Object> task = new FutureTask<>(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return 1;
            }
        });
        Thread t1 = new Thread(task);

        t1.start();
        System.out.println(task.get());


    }

    public static int getInt() {
        int a = 10;
        try {
            System.out.println(a / 0);
            a = 20;
        } catch (ArithmeticException e) {
            a = 30;
            return a;
            /*
             * return a 在程序执行到这一步的时候，这里不是return a 而是 return 30；这个返回路径就形成了
             * 但是呢，它发现后面还有finally，所以继续执行finally的内容，a=40
             * 再次回到以前的路径,继续走return 30，形成返回路径之后，这里的a就不是a变量了，而是常量30
             */
        } finally {
            a = 40;
        }
        return a;
    }

    @Test
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new RuntimeException("没有这样两个数");
    }


}




