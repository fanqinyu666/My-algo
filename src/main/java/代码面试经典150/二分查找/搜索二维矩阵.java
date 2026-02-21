package 代码面试经典150.二分查找;

public class 搜索二维矩阵 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int hang=matrix.length-1,lie=matrix[0].length-1;
        int top=0,left=0;
        int mid=0;
        while (top<=hang){
            mid=top+(hang-top)/2;
            if(matrix[mid][lie]>=target&&matrix[mid][0]<=target){
                break;
            }else if(matrix[mid][lie]<target){
                top=mid+1;
            }else {
                hang=mid-1;
            }
        }
        if (top > hang) return false;
        int mis=0;
        while (left<=lie){
            mis=left+(lie-left)/2;
            if(matrix[mid][mis]>target){
                lie=mis-1;
            }else if(matrix[mid][mis]<target){
                left=mis+1;
            }else {
                return true;
            }
        }
        return false;
    }

}
