//bfs
import java.util.*;

class Solution {
    
    private static class Node {
        int r,c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    private int[][] dist;
    private boolean[][] visited;
    
    private final int[] dr = {1,-1,0,0};
    private final int[] dc = {0,0,1,-1};
    
    private int rows, columns;
    
    private String[] boards;
    
    public int solution(String[] board) {
        
        boards = board;
        
        rows = board.length;
        columns = board[0].length();
        
        dist = new int[rows][columns];
        visited = new boolean[rows][columns];
        
        for(int i=0;i<rows;i++) { // dist 초기화
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        Node start = null;
        Node goal = null;
        
        for (int i=0;i<rows;i++) {
            for (int j=0;j<columns;j++) {
                if (board[i].charAt(j) == 'R') {
                    start = new Node(i,j);
                }
                
                if (board[i].charAt(j) == 'G') {
                    goal = new Node(i,j);
                }
            }
        }
        
        Deque<Node> queue = new ArrayDeque<>();
        visited[start.r][start.c] = true;
        dist[start.r][start.c] = 0;
        queue.addLast(start);
        
        while(!queue.isEmpty()) {
            Node now = queue.pollFirst();
            if (now.r == goal.r && now.c == goal.c) {
                break;
            }
            
            for (int i=0;i<4;i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                
                Node pre = null;
                while(isInRange(nr,nc) && !isObstacle(nr,nc)) {   
                    pre = new Node(nr,nc);
                    
                    nr += dr[i];
                    nc += dc[i];
                }
                
                if (pre != null && dist[now.r][now.c] + 1 < dist[pre.r][pre.c]) {
                    dist[pre.r][pre.c] = dist[now.r][now.c] + 1;
                    queue.addLast(new Node(pre.r, pre.c));
                }
  
            }
            
        }
        
        
        int answer = dist[goal.r][goal.c] == Integer.MAX_VALUE ? -1 : dist[goal.r][goal.c];
        
        return answer;
    }
    
    public boolean isInRange(int row, int column){
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }
    
    public boolean isObstacle(int row, int column) {
        return boards[row].charAt(column) == 'D';
    }
}