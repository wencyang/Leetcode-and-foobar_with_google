//given a int[][] grid, where 0 = PEOPLE, 1 = ZOMBIE, 2 = WALL, ZOMBIE can turn nearest PROLE to ZOMBIE one day,
//but cannot pass through WALL, return the days needed to turn all PEOPLE into ZOMBIE, return -1 if impossible
class Coordinate{
    int x,y;
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Solution {
    /**
     * @param grid  a 2D integer grid
     * @return an integer
     */
    int PEOPLE = 0;
    int ZOMBIE = 1;
    int WALL = 2;
    int[] directionX = {1,0,-1,0};
    int[] directionY = {0,1,0,-1};
    
    public int zombie(int[][] grid) {
        
        
        
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        //initilize
        Queue<Coordinate> queue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if(grid[i][j] == ZOMBIE){
                    queue.offer(new Coordinate(i,j));
                }
            }
        }
        if (isAllZombies(grid)){
            return 0;
        }
        //bfs
        int days = -1;
        while (!queue.isEmpty()){
            days++;
            int size = queue.size();
            for (int i = 0; i < size; i++){
                Coordinate zombie = queue.poll();
                for (int direction = 0; direction < 4; direction++){
                    Coordinate neighbor = new Coordinate(
                                                         zombie.x + directionX[direction],
                                                         zombie.y + directionY[direction]);
                    if (inBound(grid,neighbor)){
                        if (grid[neighbor.x][neighbor.y] == PEOPLE){
                            queue.offer(neighbor);
                            grid[neighbor.x][neighbor.y] = ZOMBIE;
                        }
                    }
                }
            }
        }
        //
        if (isAllZombies(grid)){
            return days;
        }
        return -1;
    }
    //
    private boolean inBound(int[][] grid, Coordinate neighbor){
        int n = grid.length;
        int m = grid[0].length;
        if (neighbor.x >= 0 && neighbor.x < n && neighbor.y >= 0 && neighbor.y < m){
            return true;
        }
        return false;
    }
    //
    private boolean isAllZombies(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (grid[i][j] == PEOPLE){
                    return false;
                }
            }
        }
        return true;
    }
}
