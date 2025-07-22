package 代码随想录.图论;

import java.util.LinkedList;
import java.util.Queue;

public class 腐烂的橘子 {

    public static int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<pair> queue = new LinkedList<>();
        int ans=0,refresh=0;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if(grid[i][j]==1)refresh++;
                if(grid[i][j]==2){
                    queue.add(new pair(i,j));
                }
            }
        }
        while (!queue.isEmpty()&&refresh>0){
            int size = queue.size();
            for (int i=0;i<size;i++) {
                pair poll = queue.poll();
                int curX = poll.getX();
                int curY = poll.getY();

                for (int j = 0; j < 4; j++) {
                    int nextX = curX + dir[j][0];
                    int nextY = curY + dir[j][1];
                    if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length) {
                        continue;
                    }
                    if(grid[nextX][nextY]==1) {
                        grid[nextX][nextY]=2;
                        queue.add(new pair(nextX, nextY));
                        refresh--;
                    }
                }
            }
            ans++;
        }
        if(refresh==0){
            return ans;
        }else {
            return -1;
        }
    }


}
