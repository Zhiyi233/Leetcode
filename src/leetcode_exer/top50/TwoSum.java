package top50;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author kevin
 * @create 2023-03-23-13:05
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // for(int i=0;i<nums.length-1;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         if(target == nums[i]+nums[j]){
        //             return new int[]{i,j};
        //         }
        //     }
        // }
        // return null;

        /**
         map实现：将数组的值和下标作为键值对（nums[i],i）存入hashmap中
         map是去重的，所以可以通过map判断是否存在与当前nums[i]和为target
         的数。 最后通过get方法获取下标，存入返回的数组中。
         */

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){

            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[2];
    }

    public static void main(String[] args) {
        TwoSum obj = new TwoSum();
        int[] result = obj.twoSum(new int[]{2,7,11,15},9);
        System.out.println(Arrays.toString(result));
    }
}
