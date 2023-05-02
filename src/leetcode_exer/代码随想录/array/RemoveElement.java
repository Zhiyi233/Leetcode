package leetcode_exer.代码随想录.array;

/**
 * @author kevinyi
 * @date 2023-05-01 21:57
 * @NAME: RemoveElement
 * @PROJECT_NAME: Leetcode
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        /**
         如果是O(n^2)，就可以直接暴力法两次for loop
         */

        // int size = nums.length;
        // for(int i=0;i<size;i++){
        //   if(nums[i] == val){
        //     for(int j=i+1;j<size;j++){
        //       //需要把当前的i也就是i=j-1,替换为j
        //        nums[j-1] = nums[j];
        //     }
        //     i--;
        //     size--;
        //   }
        // }
        // return size;

        /**
         双指针：将数组分为两部分，前半部分是不含有val的，后半部分则都是val的，当left == val左右交换，然后right--；找倒数第二个
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
         */

        /**
         方法三：快慢指针，一个for循环做两个的事情
         fast，slow，如果fast等于val就
         */

        int size = nums.length;
        int slow = 0;

        for(int fast = 0;fast<size;fast++){
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        RemoveElement element = new RemoveElement();
        int i = element.removeElement(new int[]{1, 2, 3, 4, 5}, 3);
        System.out.println(i);
    }
}
