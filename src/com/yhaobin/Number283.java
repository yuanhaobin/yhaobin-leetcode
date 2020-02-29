package com.yhaobin;

/**
 * 题：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 说明:
 * 1.必须在原数组上操作，不能拷贝额外的数组。
 * 2.尽量减少操作次数。
 *
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * @author yhaobin
 * @data 29/2/2020 10:49
 */
public class Number283 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
//        moveZeroes1(nums);
        moveZeroes2(nums);
        for (int object: nums){
            System.out.println(object);
        }
    }


    /**
     * 双指针法
     * 定义i，j两个指针，j指针负责读取数据，i指针覆盖数据
     * @param nums
     */
    private static void moveZeroes1(int[] nums) {
        int i = 0;
        for (int j=0;j<nums.length;j++ ){
            if (nums[j] != 0)
                nums[i++] = nums[j];
        }

        for (;i<nums.length;i++){
            nums[i] = 0;
        }
    }


    /**
     * 双指针法优化
     *
     * 定义i，j两个指针，j指针负责读取数据，读到非o元素，则交换i，j两位置的元素
     *
     * @param nums
     */
    private static void moveZeroes2(int[] nums) {
        int i = 0;
        for (int j=0;j<nums.length;j++ ){
            if (nums[j] != 0)
                swap(nums, i++, j);
        }
    }

    private static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
