package com.yhaobin.util;

/**
 * @author yhaobin
 * @data 1/3/2020 10:53
 */
public class SwapUtil {

    public static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
