public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        //     int left = 0;
        //     int size = nums.length;

        //     //双指针 i 表示当前的右指针，left左指针
        //     for(int i=0;i<size;i++){
        //         if(nums[i] != val){
        //             nums[left] = nums[i];
        //             left++;
        //         }
        //     }
        //     return left;
        // }

        //method 2 首尾双指针
        int left =0;
        int right = nums.length-1;

        while(left<=right){
            if(nums[left] == val){
                nums[left] = nums[right];
                right--;
            }else{
                left++;
            }
        }
        return left;
    }
}
