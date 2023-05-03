package leetcode_exer.代码随想录.array;

import org.junit.Test;

/**
 * @author kevin
 * @create 2023-04-28-14:43
 * level: EASY
 */
public class SearchTarget {
    /**
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     *
     * 示例 1:
     *
     * 输入: nums = [-1,0,3,5,9,12], target = 9
     * 输出: 4
     * 解释: 9 出现在 nums 中并且下标为 4
     * 示例 2:
     *
     * 输入: nums = [-1,0,3,5,9,12], target = 2
     * 输出: -1
     * 解释: 2 不存在 nums 中因此返回 -1
     * 提示：
     *
     * 你可以假设 nums 中的所有元素是不重复的。
     * n 将在 [1, 10000]之间。
     * nums 的每个元素都将在 [-9999, 9999]之间
     */

    public int search(int[] nums,int target){
        int size = nums.length;
        int left = 0;
        int right = size-1;

        // while(left<=right){
        // int middle = left+(right-left)/2;
        //     if(nums[middle] > target){
        //         right = middle-1;
        //     }else if(nums[middle]<target){
        //         left = middle+1;
        //     }else{
        //         return middle;
        //     }
        // }
        // return -1;

        return binarySearch(nums,target,left,right);

    }
    public int binarySearch(int[] nums,int target,int left,int right){
        //递归方法找
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                return binarySearch(nums,target,mid+1,right);
            }else{
                return binarySearch(nums,target,left,mid-1);
            }
        }
        return -1;
    }

    @Test
    public void test(){
        int[] case1 = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(case1,target));
    }
}
