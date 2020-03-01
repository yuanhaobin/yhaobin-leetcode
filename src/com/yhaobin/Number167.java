package com.yhaobin;

/**
 * 题：给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素
 *
 * 示例:
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * 解法：
 * 1.暴力法
 * 嵌套循环，依次找到和为target的两个位置，性能差，不推荐
 * 2.暴力法(优化)
 * 循环依次，将剩下元素利用二分法查找
 * 3.指针冲撞法
 * 定义头/尾指针，根据头尾数据的和与target的比较，对应调整，直到最后找到和为target的两个位置
 *
 * @author yhaobin
 * @data 1/3/2020 11:07
 */
public class Number167 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] rs = twoSum(nums, 9);
        for (int n : rs){
            System.out.println(n);
        }
    }

    private static int[] twoSum(int[] numbers, int target) {
        int first = 0;
        int second = numbers.length - 1;
        while (first < second) {
            int sum = numbers[first] + numbers[second];
            if (sum == target){
                return new int[]{++first, ++second};
            }
            if (sum > target){
                second--;
            }else{
                first++;
            }
        }
        return new int[2];
    }

}
