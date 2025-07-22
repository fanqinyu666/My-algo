package 代码随想录.数组;

public class 搜索二维矩阵 {

    public boolean searchMatrix(int[][] matrix, int target) {
        Integer x = null;
        for (int i=0;i<matrix.length;i++){
            if(target>=matrix[i][0]&&target<=matrix[i][matrix[0].length-1]){
                x=i;
                break;
            }
        }
        if(x==null) {
            return false;
        }

        int left=0,right=matrix[0].length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(matrix[x][mid]>target){
                right=mid-1;
            }
            if(matrix[x][mid]<target){
                left=mid+1;
            }
            if(matrix[x][mid]==target){
                return true;
            }
        }
        return false;
    }
}
