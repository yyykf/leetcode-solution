package co.code4j.leetcode.cn;

/**
 * 704 - BinarySearch
 * <p>
 * https://www.yuque.com/code4j/rly20s/wlt3v9?singleDoc# 《关于二分法的边界值确定》
 *
 * @author YuKaiFan
 * @date 2023/2/23
 * @blog <a href="https://code4j.site">https://code4j.site</a>
 */
public class _704_BinarySearch {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;

        _704_BinarySearch solution = new _704_BinarySearch();
        System.out.println(solution.leftClosedAndRightClosed(nums, target));
        System.out.println(solution.leftClosedAndRightOpened(nums, target));
    }

    /**
     * 左闭右闭区间
     *
     * @param nums   nums
     * @param target target
     * @return index
     */
    private int leftClosedAndRightClosed(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int mid;
        // 左右边界可以相等，因为还是有效的搜索区间
        while (left <= right) {
            mid = (left + right) / 2;

            if (nums[mid] > target) {
                // 在左区间，更新右边界，不需要包含中值，因为已经搜索过了
                right = mid - 1;
            } else if (nums[mid] < target) {
                // 在右区间，更新左边界，不需要包含中值，因为已经搜索过了
                left = mid + 1;
            } else {
                // got it
                return mid;
            }
        }

        return -1;
    }

    /**
     * 左闭右开区间
     *
     * @param nums   nums
     * @param target target
     * @return index
     */
    private int leftClosedAndRightOpened(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        int mid;
        // 左右边界不可以相等，因为右边界不是有效的搜索区间
        while (left < right) {
            mid = (left + right) / 2;

            if (nums[mid] > target) {
                // 在左区间，更新右边界，需要包含中值，因为中值是下一次循环的开区间端点
                right = mid;
            } else if (nums[mid] < target) {
                // 在右区间，更新左边界，不需要包含中值，因为已经搜索过了，闭区间端点应该为中值的后一个元素
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
