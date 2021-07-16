package com;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author fhn
 * @create 2021/7/5
 * @software idea
 */
public class InsertSort {
    public static void sort(int[] array) {
        // 假设第一个位置是已经排好顺序的，从后一位向前遍历查询，
        for (int i = 1; i < array.length; i++) {
            // 拿到当前位置的前一位
            int index = i - 1;
            // 拿到当前位的数据作为需要插入的数据
            int insertValue = array[i];
            // 前面的数据比这个需要插入的数据大
            while (index >= 0 && array[index] > insertValue) {
                // 将大的数据移位到后面
                array[index + 1] = array[index];
                // index往前移动
                index--;
            }
//            插入的数据放入合适的位置
            array[index + 1] = insertValue;
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 41, 4, 5,};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
