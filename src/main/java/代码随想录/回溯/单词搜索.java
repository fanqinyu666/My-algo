package 代码随想录.回溯;
import java.util.LinkedList;

public class 单词搜索 {
    //这道题和图论的dfs最大的区别就在于，他需要回溯，这就是道图论+回溯的经典题目，但是我们需要知道为什么图论不需要回溯，而他需要
    boolean[][] visited;
    LinkedList<Character> path = new LinkedList<>();
    boolean res=false;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if(board[i][j]!=word.charAt(0))continue;
                visited[i][j]=true;
                path.add(board[i][j]);
                backtracking(board,word,i,j,1);
                visited[i][j]=false;
                path.removeLast();
                //这里相当于剪枝
                if(res) return true;

            }
        }
        return res;
    }
    private static final int[][] ints=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public void backtracking (char[][] board, String word,int i,int j,int index){
        //也是剪枝
        if(res) return;
        if(path.size()==word.length()){
            res=true;
            return;
        }
        for (int s=0;s<4;s++){
            int x=i+ints[s][0];
            int y=j+ints[s][1];
            if(x<0||y<0||x>=board.length||y>=board[0].length){
                continue;
            }
            if(!visited[x][y]&&word.charAt(index)==board[x][y]){
                path.add(board[x][y]);
                visited[x][y]=true;
                backtracking(board,word,x,y,index+1);
                visited[x][y]=false;
                path.removeLast();
            }
        }
    }
}
