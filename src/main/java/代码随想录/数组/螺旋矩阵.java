package 代码随想录.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 螺旋矩阵 {
  /*  public static void main(String[] args) {
        int[][] a = {{1, 2, 3,4}, { 5, 6,7,8}, { 9,10,11,12}};//返回值和一维的数组长度有关
        螺旋矩阵 s=new 螺旋矩阵();
        System.out.println(1/2);
    }*/

    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int startX = 0, startY = 0;
        // 每一圈的起始点
        int offset = 1;
        //偏移量
        int i, j; // j 代表列, i 代表行;

        int sum = Math.min(matrix.length, matrix[0].length) / 2;//循环次数
        List<Integer> a = new ArrayList<>();
        int c = 0;
        int num=sum;
        if(sum==0){
            if(matrix.length==matrix[0].length){
                a.add(matrix[0][0]);
            }
            else if (matrix.length<matrix[0].length){//行大于列
                for (int s=0;s<matrix[0].length;s++) {
                    a.add(matrix[0][s]);
                }
            }
            else {
                for (int s=0;s<matrix.length;s++) {
                    a.add(matrix[s][0]);
                }
            }
        }


        while (sum > 0) {
            for (i = startX; i < matrix[0].length - offset; i++) {
                a.add(matrix[startX][i]);
                c++;
            }
            for (j = startY; j < matrix.length - offset; j++) {
                a.add(matrix[j][matrix[0].length - offset]);
                c++;
            }
            for (; i>startX; i--) {
                a.add(matrix[matrix.length - offset][i]);
                c++;
            }
            for (;j> startY; j--) {
                a.add(matrix[j][i]);
                c++;
            }
            startX++;
            startY++;
            offset++;
            sum--;
        }

        if (num % 2 == 1) {
            if(matrix.length==matrix[0].length){
                a.add(matrix[num][num]);
            }
            else if (matrix.length<matrix[0].length){//行大于列
                for (int s=num;s<matrix[0].length-num;s++) {
                    a.add(matrix[num][s]);

                }
            }
            else {
                for (int s=num;s<matrix.length-num;s++) {
                    a.add(matrix[s][num]);
                }
            }
        }
        return a;
    }

    public int[] spiralArray(int[][] array) {
        if (array.length == 0) return new int[0];
        int l = 0, r = array[0].length - 1, t = 0, b = array.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            for (int i = l; i <= r; i++) res[x++] = array[t][i]; // left to right
            if (++t > b) break;
            for (int i = t; i <= b; i++) res[x++] = array[i][r]; // top to bottom
            if (l > --r) break;
            for (int i = r; i >= l; i--) res[x++] = array[b][i]; // right to left
            if (t > --b) break;
            for (int i = b; i >= t; i--) res[x++] = array[i][l]; // bottom to top
            if (++l > r) break;
        }
        return res;
    }


    public List<Integer> spiralOrder2(int[][] matrix) {
        int length = matrix.length;
        int[][] a = matrix;
        int startX = 0, startY = 0;  // 每一圈的起始点
        int offset = 1;//偏移量
        int count = 1;  // 矩阵中需要填写的数字
        int loop = 1; // 记录当前的圈数
        int i, j; // j 代表列, i 代表行;

        while (loop <= matrix.length) {
            // 顶部
            // 左闭右开，所以判断循环结束时， j 不能等于 n - offset
            for (j = startY; j < matrix.length - offset; j++) {
                a[startX][j] = count++;
            }


            // 右列
            // 左闭右开，所以判断循环结束时， i 不能等于 n - offset
            for (i = startX; i < matrix.length - offset; i++) {
                a[i][j] = count++;
            }

            // 底部
            // 左闭右开，所以判断循环结束时， j != startY
            for (; j > startY; j--) {
                a[i][j] = count++;
            }

            // 左列
            // 左闭右开，所以判断循环结束时， i != startX
            for (; i > startX; i--) {
                a[i][j] = count++;
            }
            startX++;
            startY++;
            offset++;
            loop++;
        }

        if (matrix.length % 2 == 1) { // n 为奇数时，单独处理矩阵中心的值
            a[startX][startY] = count;
        }
        return null;
    }


    public static void main(String[] args) {
        螺旋矩阵 螺旋矩阵 = new 螺旋矩阵();
        螺旋矩阵.generateMatrix(3);


    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int count=1;
        int yuan = n / 2;

        int hang=0;
        int lie=0;
        int sum=n;
        while (0<yuan){

            for (;lie<sum-1;lie++){
                res[hang][lie]=count;
                count++;
            }
            for (;hang<sum-1;hang++){
                res[hang][lie]=count;
                count++;
            }
            for (;lie>n-sum;lie--){
                res[hang][lie]=count;
                count++;
            }
            for (;hang>n-sum;hang--){
                res[hang][lie]=count;
                count++;
            }
            lie++;
            hang++;
            sum--;
            yuan--;
        }
        if(1==n%2){
            res[n/2][n/2]=n*n;
        }
        return res;
    }

}
