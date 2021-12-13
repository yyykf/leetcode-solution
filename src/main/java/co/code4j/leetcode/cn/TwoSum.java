package co.code4j.leetcode.cn;

import java.util.Arrays;

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
}
