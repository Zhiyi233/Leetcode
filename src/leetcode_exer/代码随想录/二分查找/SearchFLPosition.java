package leetcode_exer.代码随想录.二分查找;


import org.junit.Test;

import java.util.Arrays;

/**
 * level: EASY
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：你可以设计并实现时间复杂度为 $O(\log n)$ 的算法解决此问题吗？
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 */
public class SearchFLPosition {
    /*
        方法一：二分法找到第一个target出现的位置，再用二分法找到第二个target的位置
        记得向上取整找last的时候
     */
    public int[] searchRange(int[] nums, int target) {
        int size = nums.length;
        if(size==0){
            return new int[]{-1,-1};
        }

        int firstPosition = findFirstPosition(nums,target);
        if(firstPosition==-1){
            return new int[]{-1,-1};
        }
        int lastPosition = findLastPosition(nums,target);
        return new int[]{firstPosition,lastPosition};
    }

    public int findFirstPosition(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;

        while(left<right){
            int mid = left+(right-left)/2;
            // int mid = (left+right)>>>1;

            if(nums[mid] > target){
                //说明mid右边的都大于target，第一个target不可能在mid右边
                //继续从[left,mid-1]开始查找
                right = mid-1;
            }else if(nums[mid] == target){
                //target可能在mid右边或是mid就是第一个target
                right = mid;
            }else{
                //nums[mid]<target,target第一个只会出现在mid右边
                left = mid+1;
            }
        }

        if(nums[left]==target){
            return left;
        }
        return -1;
    }
    public int findLastPosition(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = left+(right-left+1)/2;
            // int mid = (left+right+1)>>>1;

            if(nums[mid] > target){
                //说明mid右边的都大于target，第一个target不可能在mid右边
                //继续从[left,mid-1]开始查找
                right = mid-1;
            }else if(nums[mid] == target){
                //[mid,righgt]找最后一个target
                left = mid;
            }else{
                //nums[mid]<target,target第一个只会出现在mid右边
                left = mid+1;
            }
        }
        return left;
    }

    @Test
    public void testFist(){
        int[] case1={5,7,7,8,8,10};
        int target = 8;

        int firstPosition = findFirstPosition(case1, target);
        int lastPosition = findLastPosition(case1, target);
        System.out.println(firstPosition+"   "+lastPosition);

        int[] ints = searchRange(case1, target);
        System.out.println(Arrays.toString(ints));
    }

    /**
     *
     * 双指针分别找target在数组中的位置
     * class Solution {
     *     public int[] searchRange(int[] nums, int target) {
     *         int left=0,right=nums.length-1;
     *         int[] position=new int[]{-1,-1};
     *         int index=0;
     *         boolean find1=false,find2=false;
     *         while(!find1&&left<nums.length){
     *             if(nums[left]!=target){
     *                 left++;
     *             }else{
     *                 position[0]=left;
     *                 find1=true;
     *             }
     *         }
     *         while(!find2&&right>=0){
     *             if(nums[right]!=target){
     *                 right--;
     *             }else{
     *                 position[1]=right;
     *                 find2=true;
     *             }
     *         }
     *         return position;
     *     }
     * }
     */
}
