package leetcode_exer.代码随想录.array;

import java.util.Arrays;

/**
 * @author kevinyi
 * @date 2023-05-02 15:15
 * @NAME: SortedSquare
 * @PROJECT_NAME: Leetcode
 * level: EASY
 *
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * 示例 1： 输入：nums = [-4,-1,0,3,10] 输出：[0,1,9,16,100] 解释：平方后，数组变为 [16,1,0,9,100]，排序后，数组变为 [0,1,9,16,100]
 *
 * 示例 2： 输入：nums = [-7,-3,2,3,11] 输出：[4,9,9,49,121]
 *
 * #思路
 */
public class SortedSquare {
    public static int[] sortedSquares(int[] nums) {
        /**
         暴力法：很简单，直接每个数字平方，然后排序
         排序可以自己写一个for loop来排，也可以就是用工具类
         int size = nums.length;
         int[] result = new int[size];

         for(int i=0;i<size;i++){
         result[i] = nums[i]*nums[i];
         }
         Arrays.sort(result);
         return result;
         */

        //双指针：平方后最大的数字只可能在一头一尾，不可能是中间的，因为是非递减顺序的排序数组
        //left,right平方后比较大小，大的赋值给新数组的最左边index
        //从右向左填入新的值

        int size = nums.length;
        int left = 0;
        int right = size-1;
        int[] result = new int[size];
        int index = size-1;

        while(left<=right){
            if(nums[left]*nums[left]<nums[right]*nums[right]){
                result[index] = nums[right]*nums[right];
                index--;
                right--;
            }else{
                result[index] = nums[left]*nums[left];
                index--;
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        int[] result = SortedSquare.sortedSquares(nums);
        System.out.println(Arrays.toString(result));
    }
}
