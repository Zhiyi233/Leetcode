package leetcode_exer.代码随想录.array;

/**
 * @author kevinyi
 * @date 2023-05-03 21:55
 * @NAME: MinSubArraylen
 * @PROJECT_NAME: Leetcode
 * Level: MID
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 *
 * 示例：
 *
 * 输入：s = 7, nums = [2,3,1,2,4,3] 输出：2 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 提示：
 *
 * 1 <= target <= 10^9
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 */
public class MinSubArraylen {
    public int minSubArrayLen(int target, int[] nums) {
        int size = nums.length;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int tempCount = 0;

        /**
         * 暴力法可以解出来，但是会超时了
         *              for(int i=0; i<size;i++){
         *                  sum = nums[i];
         *                  if(sum>=target){
         *                      result = 1;
         *                      break;
         *                  }
         *                  for(int j=i+1;j<size;j++){
         *                      sum += nums[j];
         *                      if(sum>=target){
         *                          tempCount = j-i+1;
         *                          if(result<tempCount){
         *                             result = result;
         *                          }else{
         *                              result = tempCount;
         *                          }
         *                          break;
         *                      }
         *                  }
         *              }
         *              return result==Integer.MAX_VALUE?0:result;
         *          }
         */

        return  0;
    }
}
