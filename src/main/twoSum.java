import java.util.HashMap;

public class twoSum {
    public int[] twoSum(int[] nums, int target) {
        // int size = nums.length;
        // int result[] = new int[2];

        // //暴力算法
        // for(int i=0; i<size;i++){
        //     for(int j=i+1; j<size; j++){
        //         if(target == nums[i]+nums[j]){
        //             result[0]=i;
        //             result[1]=j;
        //         }
        //     }
        // }
        // return result;

        //hashmap method
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int result[] = new int[2];

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                //we find the key of another value
                result[0]=map.get(target-nums[i]);
                result[1]=i;
            }
            map.put(nums[i],i);
        }
        return result;
    }
}
