package com.yhaobin.sort;

import com.yhaobin.util.SwapUtil;

/**
 * 三路快排
 *
 * 题：给定数组，该数组只包含0，1，2三中类型的元素，且每种类型元素个数存在多个
 * 现要求按照0，1，2的顺序将所有元素排好序
 *
 * 示例：
 * 给定数组muns [0,2,1,0,0,2,2,1,0]
 * 排序后muns [0,0,0,0,1,1,2,2,2]
 *
 * @author yhaobin
 * @data 1/3/2020 10:41
 */
public class ThreeWayQuickSort {


    public static void main(String[] args) {
        int[] nums = new int[]{0,2,1    ,0,0,2,2,1,0};
        threeWayQuickSort(nums);
        for (int n : nums){
            System.out.println(n);
        }
    }

    /**
     * 三路快排典型的思路就是定义三个区间的边界位置，然后迭代数组的过程中，根据每个迭代的值和对应区间
     * 的元素进行交换
     *
     * @param nums
     */
    private static void threeWayQuickSort(int[] nums){
        int zero = -1;          //定义0区的边界，[0, zero]
        int two = nums.length;  //定义2区的边界，[two, nums.length-1]

        for (int i=0;i<two;){
            switch (nums[i]){
                case 0:
                    SwapUtil.swap(nums, ++zero, i++);
                    break;
                case 1:
                    i++;
                    break;
                case 2:
                    SwapUtil.swap(nums, --two, i);
                    break;
            }
        }
    }


}
