package 代码随想录.数组;

public class test {
    public static void main(String[] args){
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int tob=0,right=matrix[0].length-1;
        while (tob<matrix.length&&right>=0){
            if(target>matrix[tob][right]){
                tob++;
            }else if(target<matrix[tob][right]){
                right--;
            }else {
                return true;
            }
        }
        return false;
    }
}