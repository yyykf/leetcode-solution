package co.code4j.leetcode.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 01 - TwoSum
 *
 * @author YuKaiFan
 * @date 2021/12/13
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(version1(nums, target)));
        System.out.println(Arrays.toString(version2(nums, target)));
    }

    /**
     * Exhaustive
     *
     * @param nums   nums
     * @param target target
     * @return result
     */
    public static int[] version1(int[] nums, int target) {
        // Time complexity: O(n^2), Space complexity: O(1)
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

    /**
     * Using HashMap, space swap time
     *
     * @param nums   nums
     * @param target target
     * @return result
     */
    public static int[] version2(int[] nums, int target) {
        // Time complexity: O(n), Space complexity: O(n)
        Map<Integer, Integer> index = new HashMap<>(nums.length);
        // init HashMap, key:num -> value: index
        for (int i = 0; i < nums.length; i++) {
            index.put(nums[i], i);
        }
        // iterate Array, find other number whether exists in HashMap
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (index.containsKey(other) && index.get(other) != i) {
                return new int[]{i, index.get(other)};
            }
        }

        return new int[]{-1, -1};
    }
}
