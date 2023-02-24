package co.code4j.leetcode.cn;

/**
 * 209 - MinimumSizeSubarraySum
 * <p>
 *
 * @author YuKaiFan
 * @date 2023/2/23
 * @blog <a href="https://code4j.site">https://code4j.site</a>
 */
public class _209$MinimumSizeSubarraySum {

    public static void main(String[] args) {
        int[] nums = {4, 6, 2, 4, 9, 8, 7};
        int target = 12;
        _209$MinimumSizeSubarraySum solution = new _209$MinimumSizeSubarraySum();
        System.out.println(solution.minSubArrayLen(target, nums));
    }

    /** 暴力解法 */
    public int minSubArrayLen(int target, int[] nums) {
        Integer result = null;

        // 子数组累加和
        int sum;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;

            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    // 满足条件了，计算当前子数组长度
                    int subLength = j - i + 1;
                    if (result == null || subLength < result) {
                        result = subLength;
                    }
                    // 外层循环可以再一次了，当前外层循环的子数组不用再往后找了
                    break;
                }
            }
        }

        return result == null ? 0 : result;
    }
}