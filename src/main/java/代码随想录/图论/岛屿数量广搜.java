package 代码随想录.图论;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 岛屿数量广搜 {
    public static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    //下右上左逆时针遍历

    public static void bfs(int[][] grid, boolean[][] visited, int x, int y) {
        Queue<pair> queue = new LinkedList<pair>();

        queue.add(new pair(x, y));
        visited[x][y] = true;
        //这里就是深搜和广搜的区别，一个递归一个迭代
        while (!queue.isEmpty()) {
            //队列不空一直，空的时候，一个岛屿就遍历完了，一个岛屿所有部分肯定被遍历完
            int curX = queue.peek().getX();
            int curY = queue.poll().getY();

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dir[i][0];
                int nextY = curY + dir[i][1];
                if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length) {
                    continue;
                }
                if (!visited[nextX][nextY] && grid[nextX][nextY] == 1) {
                    //不递归，添加队列
                    queue.add(new pair(nextX, nextY));
                    visited[nextX][nextY] = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] grid = new int[m][n];
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    ans++;
                    bfs(grid, visited, i, j);
                }
            }
        }
        System.out.println(ans);
    }

}
