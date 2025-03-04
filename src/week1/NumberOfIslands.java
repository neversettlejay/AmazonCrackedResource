package week1;

public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        int res = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]-'0' == 1){
//                   System.out.println(grid[i][j]-'0' + 'a'-'1');
                	res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }
    
    static void dfs(char[][] grid, int i, int j){
        if(i>=0 && j>=0 && i<grid.length && j<grid[0].length && grid[i][j]-'0'  == 1){
            grid[i][j] = '0';
            
            dfs(grid, i+1, j);
            dfs(grid, i-1, j);
            dfs(grid, i, j+1);
            dfs(grid, i, j-1);
        }
    }
    public static void main(String[] args) {
    	System.out.println(numIslands(new char[][] {  {'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}}));
	}
}
/*public static int numIslands(char[][] grid) {
        int count = 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    bfs(i, j, grid, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public static void bfs(int i, int j, char[][] grid, boolean[][] visited) {
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(Arrays.asList(i, j));
        visited[i][j] = true;
        
        while (!queue.isEmpty()) {
            List<Integer> cur = queue.poll();
            Integer cur_i = cur.get(0);
            Integer cur_j = cur.get(1);
            
            for (int[] dir : directions) {
                int new_i = cur_i + dir[0];
                int new_j = cur_j + dir[1];
                if (isValidNeighborIndex(new_i, new_j, grid, visited)) {
                    visited[new_i][new_j] = true;
                    queue.offer(Arrays.asList(new_i, new_j));
                }
            }
            
        }
    }

    public static boolean isValidNeighborIndex(int i, int j, char[][] grid, boolean[][] visited) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && !visited[i][j] && grid[i][j] != '0';
    }*/
