public class Remove {

    public static void main(String[] args) {
        int[] inputNum = {1,1,2};

        System.out.println(new Remove().removeDuplicates(inputNum));
    }

    public int removeDuplicates(int[] nums) {
        int fast=1;
        int slow=1;
        int n = nums.length;

        if(n==0){
            return 0;
        }

        if(n!=0){
            while(fast<n){
                if(nums[fast]!=nums[fast-1]){
                    nums[slow]=nums[fast];
                    slow++;
                }
                fast++;
            }
        }
        return slow;
    }
}
