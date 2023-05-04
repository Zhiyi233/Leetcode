package leetcode_exer.代码随想录.移除元素;

/**
 * @author kevinyi
 * @date 2023-05-02 11:47
 * @NAME: RemoveDuplicate
 * @PROJECT_NAME: Leetcode
 *
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 *
 * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
 *
 * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
 * 返回 k 。
 *
 * level: EASY
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
