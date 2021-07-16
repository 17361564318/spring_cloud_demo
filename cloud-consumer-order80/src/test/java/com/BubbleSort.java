package com;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author fhn
 * @create 2021/7/5
 * @software idea
 */
public class BubbleSort {
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) { //进行第一层遍历
            for (int j = 1; j < array.length - i; j++) { // 进行第二层遍历
                if (array[j - 1] > array[j]) { //如果前面的数大于后面的数  就进行交换
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 4, 5, 1, 7, 8};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
