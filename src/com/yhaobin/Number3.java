package com.yhaobin;

/**
 * 题：给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3
 *
 * @author yhaobin
 * @data 4/3/2020 09:45
 */
public class Number3 {


    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * 滑动窗口法
     *
     * 定义fast，slow两个指针，指针之间的字符永远保持不重复的字符
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)){
            return 0;
        }

        // " " 特殊情况，该长度为1
        if (s.trim().length() == 0){
            return 1;
        }

        int maxLength = 0; //最大长度
        int slow = 0, fast = 0; //快慢指针, [slow, fast]
        int[] duplicateChar = new int[256]; //记录每个ASCII码出现的频率

        while (slow <= fast && fast < s.length()){
            char next = s.charAt(fast);
            int num = duplicateChar[next];
            if (num != 0){
                duplicateChar[s.charAt(slow++)] = 0;
            }else {
                duplicateChar[next] = 1;
                maxLength = Math.max(maxLength, fast++-slow+1);
            }
        }

        return maxLength;
    }
}
