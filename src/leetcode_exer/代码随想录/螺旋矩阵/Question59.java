package leetcode_exer.代码随想录.螺旋矩阵;

/**
 * @author kevinyi
 * @date 2023-05-11 15:28
 * @NAME: Question59
 * @PROJECT_NAME: Leetcode
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 */
public class Question59 {
    public int[][] generateMatrix(int n) {
        int startX = 0;
        int startY = 0;
        int[][] result = new int[n][n];
        int loop = 0;
        int offset = 1;
        int count = 1;  //初始值
        int i,j;

        while (loop < n/2){
            //上方从左到右
            for(j = startX; j<n-offset;j++){
                result[startX][j] = count;
                count++;
            }

            //右侧从上到下
            for(i = startX; i<n-offset;i++){
                result[i][j] = count;
                count++;
            }

            //下方从右到左
            for(;j>startY;j--){
                result[i][j] = count;
                count++;
            }

            //左侧从下到上
            for(;i>startX;i--){
                result[i][j] = count;
                count++;
            }
            //X，Y都要更新初始位置，偏移量加一
            //因为我们已经完成了一圈的赋值，需要对里面新的一圈格子进行赋值
            startX++;
            startY++;
            offset++;
            loop++;
        }
        if(n%2==1){
            //n is odd number
            result[startX][startY] = count;
        }
        System.out.print(count);
        return result;
    }
}
