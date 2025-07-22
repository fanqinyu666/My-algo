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

    public static void main(String[] args) {
        矩阵置零 ss = new 矩阵置零();
        ss.setZeroes2(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}});
    }
    //第一行和第一列需要单独判断
    public void setZeroes2(int[][] matrix) {
        boolean isH=false;
        boolean isL=false;

        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]==0){
                isH=true;
                break;
            }
        }
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i]==0){
                isL=true;
                break;
            }
        }

        for (int i=1;i<matrix.length;i++){
            for (int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for (int i=1;i<matrix.length;i++){
            if(matrix[i][0]==0){
                for (int j=1;j<matrix[0].length;j++){
                    matrix[i][j]=0;
                }
            }
        }
        for (int i=1;i<matrix[0].length;i++){
            if(matrix[0][i]==0){
                for (int j=1;j<matrix.length;j++){
                    matrix[j][i]=0;
                }
            }
        }
        if(isH){
            for (int i=0;i<matrix.length;i++){
                matrix[i][0]=0;
            }
        }
        if(isL){
            for (int i=0;i<matrix[0].length;i++){
                matrix[0][i]=0;
            }
        }
    }
}
