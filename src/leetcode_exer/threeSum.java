import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//just make a comment for this file
public class threeSum {
    public static void main(String[] args) {
        int[] inputNum = {-1,0,1,2,-1,-4};

        System.out.println(three_Sum(inputNum));
    }
    public static List<List<Integer>> three_Sum(int[] nums) {
        int size=nums.length;
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<size;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue; //do next loop since the next item is same as previous one
            }
            for(int j=i+1;j<size;j++){
                //second loop
                if(j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                int third = size-1;
                while(j<third && nums[i]+nums[j]+nums[third]>0){
                    third--;
                }
                if(j==third){
                    break;
                }
                if(nums[i]+nums[j]+nums[third]==0){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[third]);
                    answer.add(list);
                }
            }
        }
        return answer;
    }
}
