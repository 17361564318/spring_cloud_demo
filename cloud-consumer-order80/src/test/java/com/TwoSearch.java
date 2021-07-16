package com;

/**
 * 二分查找法
 *
 * @author fhn
 * @create 2021/7/5
 * @software idea
 */
public class TwoSearch {

    public static int binarySearch(int[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j-1]>array[j]) {
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }
        int lower = 0;
        int high = array.length - 1;
        int mid;
        while (lower < high) {
            mid = (lower + high) / 2;
            if (array[mid] == number) {
                return mid + 1;
            } else if (array[mid] > number) {
                high = mid - 1;
            } else {
                lower = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {10, 1, 5, 7, 3, 2, 4};
        System.out.println(binarySearch(array, 7));

    }
}
