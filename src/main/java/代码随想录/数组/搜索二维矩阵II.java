package 代码随想录.数组;

public class 搜索二维矩阵II {

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i=0;i<matrix[0].length;i++){
            if(matrix[0][i]<=target&&target<=matrix[matrix.length-1][i]){
                for (int j=0;j<matrix.length;j++){
                    if(target==matrix[j][i]){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
