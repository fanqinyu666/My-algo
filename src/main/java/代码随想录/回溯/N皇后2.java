package 代码随想录.回溯;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//之前都是对一维数组进行回溯，现在是二维，我们还用一维的方式，
//递归为行，单层为列
public class N皇后2 {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        //N皇后，放皇后用Q标识，不放用.标识
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }

        backTrack(n,0, chessboard);
        return res;
    }

    public void backTrack(int n, int i, char[][] chessboard) {
        //注意，n-1才是数组的长度，n就该收获结构了
        if (i == n) {
            res.add(toList(chessboard));
            return;
        }
        for (int j = 0;j < n; ++j) {
            //判断合理性，如果合理就放皇后，下一层递归
            //这样都不需要判断一行了
            if (isValid (i, j, n, chessboard)) {
                chessboard[i][j] = 'Q';
                backTrack(n, i+1, chessboard);
                chessboard[i][j] = '.';
            }
        }

    }

    public boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 检查列
        for (int i=0; i<row; ++i) {
            // 相当于剪枝
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }
        // 检查45度对角线
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        // 检查135度对角线
        for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    //这个方法没啥，就是把二维数组变成字符串集合了
    public List<String> toList(char[][] chessboard) {
        List<String> list = new ArrayList<>();
        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }

}
