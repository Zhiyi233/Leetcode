package leetcode_exer.代码随想录.螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kevinyi
 * @date 2023-05-11 15:28
 * @NAME: Question54
 * @PROJECT_NAME: Leetcode
 */
public class Question54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        //类似p59的螺旋矩阵2
        int mCol = matrix[0].length;
        int nRow = matrix.length;
        int i,j;
        int startX = 0;
        int startY = 0;
        int loop = Math.min(mCol,nRow)/2;
        int mid = Math.min(mCol,nRow)/2;
        int offset = 1;
        ArrayList<Integer> res = new ArrayList<>();

        while(loop>0){
            //上方从左到右
            for(j = startX;j<mCol-offset;j++){
                res.add(matrix[startX][j]);
            }

            //右侧从上到下
            for(i=startY;i<nRow-offset;i++){
                res.add(matrix[i][j]);
            }

            //下方从右到左
            for(;j>startX;j--){
                res.add(matrix[i][j]);
            }

            //左侧从下到上
            for(;i>startY;i--){
                res.add(matrix[i][j]);
            }

            startX++;
            startY++;
            offset++;
            loop--;
        }

        /**
         如果min(rows, columns)为奇数，则矩阵最中间位置不只是[mid][mid],而是会留下来一个特殊的中间行或者中间列，具体是中间行还是中间列，要看rows和columns的大小，如果rows > columns,则是中间列，相反，则是中间行
         */

        if((Math.min(mCol,nRow)%2)==1 ){
            if(mCol>nRow){
                for( j = mid;j<mid+mCol-nRow+1;++j){
                    res.add(matrix[mid][j]);
                }
            }else{
                for( i = mid; i<mid+nRow-mCol+1;++i){
                    res.add(matrix[i][mid]);
                }
            }
        }
        return res;
    }
}
