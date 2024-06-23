import java.util.*;

class Solution {
    
    private class Node {
        int r;
        int c;
        
        public Node (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    private boolean[][] visited;
    private int[][] distance;
    
    public int solution(int[][] maps) {
        int answer = -1;
        
        int rows = maps.length;
        int columns = maps[0].length;
        
        bfs (rows,columns,maps);
        
    
        if (visited[rows-1][columns-1]) {
            answer = distance[rows-1][columns-1];
        }
        
        return answer;
    }
    
    
    public void bfs(int rows, int columns, int[][] maps) {
        
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        
        visited = new boolean[rows][columns];
        distance = new int[rows][columns];
        
        Deque<Node> queue = new ArrayDeque<>();
        queue.addLast(new Node(0,0));
        
        visited[0][0] = true;
        distance[0][0] = 1;
        
        while (!queue.isEmpty()) {
            Node now = queue.pollFirst();
            
            for (int i=0;i<4;i++) {
                
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                
                if (nr < 0 || nc < 0 || nr >= rows || nc >= columns) {
                    continue;
                }
                
                if (visited[nr][nc] || maps[nr][nc] == 0) {
                    continue;
                }
                
                visited[nr][nc] = true;
                distance[nr][nc] = distance[now.r][now.c] + 1;
                queue.addLast(new Node(nr,nc));
            }
        } 
  
    }
}