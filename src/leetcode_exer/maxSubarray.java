public class maxSubarray {
    public static void main(String[] args) {
        int[] inputNum = {-2,1,-3,4,-1,2,1,-5,4};
        int result = maximumSubArray(inputNum);
        System.out.println(result);
    }

    public static int maximumSubArray(int[] nums) {
        int sum=0;
        int max=nums[0];
        for(int i=0; i<nums.length;i++){
            //sum += nums[i]; //new sum of current subarray
            if(sum<0){
                sum=nums[i]; //let sum be the current value of nums
            }else{
                sum+=nums[i];
            }
            //max=Math.max(sum,max);
            if(max>sum){
                max=max;
            }else{
                max=sum;
            }
        }
        return max;
    }
}
