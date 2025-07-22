package 代码随想录.数组;

public class 旋转图像 {
    public void rotate(int[][] matrix) {
        int n = matrix.length / 2;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < matrix.length - i - 1; j++) {
                // 保存四个角的元素
                int first = matrix[i][j]; // 左上
                int second = matrix[j][matrix.length - 1 - i]; // 右上
                int third = matrix[matrix.length - 1 - i][matrix.length - 1 - j]; // 右下
                int fourth = matrix[matrix.length - 1 - j][i]; // 左下

                // 顺时针旋转
                matrix[i][j] = fourth; // 左下→左上
                matrix[j][matrix.length - 1 - i] = first; // 左上→右上
                matrix[matrix.length - 1 - i][matrix.length - 1 - j] = second; // 右上→右下
                matrix[matrix.length - 1 - j][i] = third; // 右下→左下
            }
        }
    }
}
