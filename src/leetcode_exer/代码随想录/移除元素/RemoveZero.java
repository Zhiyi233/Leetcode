package leetcode_exer.代码随想录.移除元素;

import java.util.Arrays;

/**
 * @author kevinyi
 * @date 2023-05-04 22:52
 * @NAME: RemoveZero
 * @PROJECT_NAME: Leetcode
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 示例 2:
 *
 * 输入: nums = [0]
 * 输出: [0]
 */
public class RemoveZero {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        RemoveZero.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void moveZeroes(int[] nums) {
        /**
         快慢指针：当元素不等于0时，就将当前元素的值赋值给前一个，等于0时记录一个count有多少个count就在最后有多少个0
         情况一：两次遍历
         */
        int slow = 0;
        int size=nums.length;

        // int count=0;
        // for(int fast=0;fast<size;fast++){
        //     if(nums[fast]!=0){
        //         nums[slow] = nums[fast];
        //         slow++;
        //     }else{
        //         count++;
        //     }
        // }

        // while(count>0){
        //     nums[size-count] = 0;
        //     count--;
        // }

        //====================================
        //情况2：在for中直接完成0的后移
        for(int fast=0;fast<size;fast++){
            if(nums[fast]!=0){
                //用一个局部变量来交换两个值，完成0的后移
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                slow++;
            }
        }

        //情况2优化版本：不需要temp交换，直接将原位置赋值为0就好，节省时间
        // for(int fast=0;fast<size;fast++){
        //     if(nums[fast]!=0){
        //         if(fast>slow){
        //             nums[slow] = nums[fast];
        //             nums[fast]=0;
        //         }
        //         slow++;
        //     }
        // }
    }
}
