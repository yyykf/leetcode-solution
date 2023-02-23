package co.code4j.leetcode.cn;

/**
 * 27 - RemoveElement
 * <p>
 *
 * @author YuKaiFan
 * @date 2023/2/23
 * @blog <a href="https://code4j.site">https://code4j.site</a>
 */
public class _027_RemoveElement {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int target = 2;

        _027_RemoveElement solution = new _027_RemoveElement();
        System.out.println(solution.removeElementByViolence(nums, target));
        System.out.println(solution.removeElementByDoublePointer(nums, target));
    }

    /**
     * 暴力解法
     *
     * @param nums   nums
     * @param target target
     * @return size
     */
    public int removeElementByViolence(int[] nums, int target) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] == target) {
                // 后面的元素往前面挪
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                // 个数-1
                size--;
                // 回到上一个位置，因为新挪过来的位置也有可能是目标值
                i--;
            }
        }

        return size;
    }
    /**
     * 双指针法
     *
     * @param nums   nums
     * @param target target
     * @return size
     */
    public int removeElementByDoublePointer(int[] nums, int target) {
       int idx = 0;

        for (int num : nums) {
            if (num != target) {
                // 如果当前元素不是目标值，那么就插入到当前索引位置，并将索引右移
                nums[idx++] = num;
            }
        }

        return idx;
    }
}
