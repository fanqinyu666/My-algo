package 代码随想录.数组;
import java.util.ArrayList;
import java.util.List;
public class test {

    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (matrix.length == 0) return arrayList;

        int tl = 0, tr = matrix[0].length - 1;
        int top = 0, under = matrix.length - 1;

        while (tl <= tr && top <= under) {
            // 从左到右
            for (int i = tl; i <= tr; i++) {
                arrayList.add(matrix[top][i]);
            }
            // 从上到下
            for (int i = top + 1; i <= under; i++) {
                arrayList.add(matrix[i][tr]);
            }

            if (tl < tr && top < under) {
                // 从右到左
                for (int i = tr - 1; i >= tl; i--) {
                    arrayList.add(matrix[under][i]);
                }
                // 从下到上
                for (int i = under - 1; i > top; i--) {
                    arrayList.add(matrix[i][tl]);
                }
            }

            tl++;
            tr--;
            top++;
            under--;
        }
        return arrayList;
    }

}