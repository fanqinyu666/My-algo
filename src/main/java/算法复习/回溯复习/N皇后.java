package 算法复习.回溯复习;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N皇后 {
    //注意这次，我们的每个结果都是一个二维数组，所以我们的结果集其实是一个二维集合，也就是三维变量

    List<List<String>> res = new ArrayList<>();


    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }

        backTrack(n, 0, chessboard);
        return res;
    }

    public void backTrack(int n, int row, char[][] chessboard) {
        if (row == n) {
            res.add(Array2List(chessboard));
            return;
        }

        for (int col = 0;col < n; ++col) {
            //row是行，col是列，传入棋盘，再传入大小n（可以不传）
            if (isValid (row, col, n, chessboard)) {
                //如果合法，就传入Q，递归，回溯
                chessboard[row][col] = 'Q';
                backTrack(n, row+1, chessboard);
                chessboard[row][col] = '.';
            }
            //不合法也就过了
        }
    }

    public List Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();
        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    //检查一下是否出现Q，好像确实简单哦
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



}
