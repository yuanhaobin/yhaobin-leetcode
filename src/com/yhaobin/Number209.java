package com.yhaobin;

/**
 * 题：给定一个含有 n 个正整数的数组和一个正整数 s ，
 * 找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例:
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 *
 * @author yhaobin
 * @data 2/3/2020 09:16
 */
public class Number209 {

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3};
        System.out.println(minSubArrayLen2(7, nums));
    }

    /**
     * 暴力法
     *
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen1(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int slow = 0,  //慢指针
            fast = -1, //快指针
            sum = 0,   //累加和
            min = nums.length+1; //最小区间

        while (++fast < nums.length){
            sum += nums[fast];
            if (sum >= s){
                min = Math.min(min, fast-slow+1);

                while (slow < fast && sum >= s){
                    sum = sum - nums[slow++];
                    if (sum >= s) {
                        min = Math.min(min, fast - slow + 1);
                    }
                }
            }
        }
        return min == nums.length+1 ? 0 : min;
    }


    /**
     * 滑动窗口法
     * 定义快慢指针fast, slow, 慢指针追赶快指针，始终保持窗口和大于目标值
     *
     *
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen2(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int slow = 0,  //慢指针
            fast = -1, //快指针
            sum = 0,   //累加和
            min = nums.length+1; //最小区间

        while (slow < nums.length) {
            if (sum >= s){
                min = Math.min(min, fast-slow+1);
            }

            if (fast+1 < nums.length && sum < s){
                sum += nums[++fast];
            }else {
                sum -= nums[slow++];
            }
        }
        return min == nums.length+1 ? 0 : min;
    }

}
