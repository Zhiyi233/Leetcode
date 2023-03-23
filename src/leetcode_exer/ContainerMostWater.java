package leetcode_exer;

/**
 * @author kevin
 * @create 2023-03-23-11:05
 */
public class ContainerMostWater {
    public static void main(String[] args) {
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
        int maxValue = maxArea(arr);
        System.out.println(arr.toString());
        System.out.println(maxValue);
    }
    public static int maxArea(int[] height) {
        /**
         *  暴力算法要超时，虽然可以就是接出来最大的容量
         *  从最左边的板子开始依次求面积，每次更新最大值
         *  两次循环：第一次从0-n-2（倒数第二个板子）
         *           第二次从左边板子的右边第一个开始，直到最右边的板子n-1
         */

        // int size = height.length;
        // int max = 0;
        // int currArea = 0;

        // for(int i=0;i<size-1;i++){
        //     for(int j=i+1;j<size;j++){
        //         if(height[i]<=height[j]){
        //             currArea = height[i]*(j-i);
        //         }else{
        //             currArea = height[j]*(j-i);
        //         }
        //         if(currArea>max){
        //             max = currArea;
        //         }
        //     }
        // }
        // return max;

        /**
         * 双指针方法：从左右两侧开始，不论怎么样x轴上的宽度都会减少，容器的容量由板子的短板高度决定
         * 所以每次移动长板，短板的大小只会不变或者变小，因此宽减少了面积只会更小
         * 移动短板的话，新的板子可能会比之前的大，所以面积可能会大
         * 每次获得的面积和之前最大值比较
         * 当两个指针相遇时，循环结束。
         */
        int left=0;
        int right=height.length-1;
        int max=0;

        while(left<right){
            int curr;
            if(height[left]<=height[right]){
                curr=(right-left)*height[left];
                left++;
            }else{
                curr=(right-left)*height[right];
                right--;
            }
            if(curr>max){
                max=curr;
            }
        }
        return max;
    }
}
