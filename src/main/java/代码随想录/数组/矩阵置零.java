package 代码随想录.数组;

public class 矩阵置零 {

    public void setZeroes(int[][] matrix) {

        int[] L = new int[matrix.length];
        int[] H = new int[matrix[0].length];
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (matrix[i][j]==0) {
                    L[i]=1;
                    H[j]=1;
                }
            }
        }

        for (int i=0;i<matrix.length;i++) {
            if (L[i]==1) {
                for (int j=0;j<matrix[0].length;j++){
                    matrix[i][j]=0;
                }
            }
        }

        for (int i=0;i<matrix[0].length;i++){
            if (H[i]==1) {
                for (int j=0;j<matrix.length;j++){
                    matrix[j][i]=0;
                }
            }
        }
    }
}
