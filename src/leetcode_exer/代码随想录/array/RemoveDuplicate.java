package leetcode_exer.代码随想录.array;

/**
 * @author kevinyi
 * @date 2023-05-02 11:47
 * @NAME: RemoveDuplicate
 * @PROJECT_NAME: Leetcode
 */
public class RemoveDuplicate {
    public int removeDuplicates(int[] nums) {
        //类似27题，同样使用快慢指针
        //升序数组：所以index 0 肯定是单独的不需要再管，所以起始位置由1开始，当fast的元素和前一位相同时说明是重复，
        // fast继续往后移知道找到不同的元素，然后将这个元素赋值给slow所在的位置
        int slow = 1;
        int size = nums.length;

        for(int fast = 1; fast<size;fast++){
            if(nums[fast] != nums[fast-1]){
                //当前的元素和上一个不同
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
