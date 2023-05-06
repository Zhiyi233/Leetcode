package leetcode_exer.代码随想录.滑动窗口;

import org.junit.Test;

/**
 * @author kevinyi
 * @date 2023-05-06 10:53
 * @NAME: MinSubArray
 * @PROJECT_NAME: Leetcode
 *
 * Level： MID
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0 。
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 *
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 *
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 */
public class MinSubArray {
    public int minSubArrayLen(int target, int[] nums) {
        //暴力法可以解出来，但是会超时了,是一个for循环滑动窗口的起始位置，一个for循环为滑动窗口的终止位置，用两个for循环 完成了一个不断搜索区间的过程。
        // int size = nums.length;
        // int result = Integer.MAX_VALUE;
        // int sum = 0;
        // int tempCount = 0;
        //     for(int i=0; i<size;i++){
        //         sum = nums[i];
        //         if(sum>=target){
        //             result = 1;
        //             break;
        //         }
        //         for(int j=i+1;j<size;j++){
        //             sum += nums[j];
        //             if(sum>=target){ //一旦发现子序列之和大于target终止循环
        //                 tempCount = j-i+1; //当前子序列长度
        //                 if(result<tempCount){ //比较
        //                    result = result;
        //                 }else{
        //                     result = tempCount;
        //                 }
        //                 break;
        //             }
        //         }
        //     }
        //     return result==Integer.MAX_VALUE?0:result;
        // }

        /**
         滑动窗口：
         一个for loop 两个指针，起始位置，结束位置
         通过动态的移动两个位置，如果sum>=target，移动起始位置，减去当前起始位置nums[first]的值，直到sum<target
         在此过程中同样更新子数组的最小长度。在每一轮迭代的最后，将 end右移.
         */

        int size = nums.length;
        int first = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        int sub;

        for(int last = 0;last<size;last++){
            sum += nums[last];
            while(sum>=target){
                sub = last-first+1;
                sum -= nums[first];
                first++;
                // result = result<sub ? result:sub;
                result = Math.min(result,sub);
            }
        }
        return result==Integer.MAX_VALUE? 0:result;
    }

    @Test
    public void test1(){
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        MinSubArray subArray = new MinSubArray();
        System.out.println(subArray.minSubArrayLen(target, nums));
    }
}
