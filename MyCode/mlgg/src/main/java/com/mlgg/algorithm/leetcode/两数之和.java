package com.mlgg.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhang.yifei4
 * @version 1.0
 * @ClassName 两数之和
 * <p>
 * @Date
 * @since v9.0
 */
public class 两数之和 {
    /**
     * 两层for循环遍历的时间复杂度是O(n2)，哈希查找的复杂度是O(1),所以使用hash容器map降低时间复杂度。
     *      map中以数值为key，角标为value存储，可以去重和判断。
     *
     *      时间复杂度O(n)
     *      空间复杂度O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ;i< nums.length ;i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No to sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {3,7,8,9,5,2};
        int target = 7;
        两数之和 两数之和 = new 两数之和();
        int[] ints = 两数之和.twoSum(nums, target);
        System.out.println("["+ints[0]+","+ints[1]+"]");
    }
}
