package 代码随想录.图论;

public class 岛屿数量深搜 {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //没访问过+相邻的是陆地
                if (!visited[i][j] && grid[i][j] == '1') {
                    //陆地数量++
                    ans++;
                    //标记为访问过
                    visited[i][j] = true;
                    //进行深搜，把附近的都访问了，但是深搜过程不去ans++
                    dfs(visited, i, j, grid);
                }
            }
        }
        return ans;
    }
    public static int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static void dfs(boolean[][] visited, int x, int y, char[][] grid) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            if (nextY < 0 || nextX < 0 || nextX >= grid.length || nextY >= grid[0].length)
                continue;
            if (!visited[nextX][nextY] && grid[nextX][nextY] == '1') {
                //如果相邻的是陆地，并且没有访问过
                //先标记为访问过
                visited[nextX][nextY] = true;
                //在进行遍历
                dfs(visited, nextX, nextY, grid);
            }
        }
    }

/*
    public static void main(String[] args) {
        //前面完全就是存入值，属于ACM模式了，然后定义一个是否访问过的数组
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        boolean[][] visited = new boolean[m][n];

        //从这里开始才是核心代码
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //没访问过+相邻的是陆地
                if (!visited[i][j] && grid[i][j] == 1) {
                    //陆地数量++
                    ans++;
                    //标记为访问过
                    visited[i][j] = true;
                    //进行深搜，把附近的都访问了，但是深搜过程不去ans++
                    dfs(visited, i, j, grid);

                }
            }
        }
        System.out.println(ans);
    }*/


}
