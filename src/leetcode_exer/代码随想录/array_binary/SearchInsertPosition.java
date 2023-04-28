package leetcode_exer.代码随想录.array_binary;
/**
 * @author kevin
 * @create 2023-04-28-14:29
 */
public class SearchInsertPosition {

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * 你可以假设数组中无重复元素。
     *
     * 示例 1:
     *
     * 输入: [1,3,5,6], 5
     * 输出: 2
     * 示例 2:
     *
     * 输入: [1,3,5,6], 2
     * 输出: 1
     * 示例 3:
     *
     * 输入: [1,3,5,6], 7
     * 输出: 4
     * 示例 4:
     *
     * 输入: [1,3,5,6], 0
     * 输出: 0
     */

    public static int searchInsertMethod1(int[] nums, int target){
        /*
            方法一：二分法，一般应用于，有序，无重复的数组情况
            都可以想一想是否可以使用二分法

         */
        int left=0;
        int right = nums.length-1;

        while(left<=right){
            int mid = left+(right-left)/2; //防止溢出 等同于(left + right)/2
            if(nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]>target){
                right = mid-1;
            }else{
                return mid;
            }
        }
        return right+1;
    }

    public static int searchInsertMethod2(int[] nums, int target) {
        /*
            方法一：暴力法，for循环
         */
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>=target){
                //说明目标值应该插入i所在的位置或者就是i位置的那个值
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] case1 = {1,3,5,6};
        int target1 = 5;
        int[] case2 = {1,3,5,6};
        int target2 = 2;

        int result1 = SearchInsertPosition.searchInsertMethod1(case1, target1);
        int result2 = SearchInsertPosition.searchInsertMethod2(case2, target2);
        System.out.println("result1: "+result1);
        System.out.println("result2: "+result2);
    }
}
