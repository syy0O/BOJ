import java.util.*;

class Solution {
    
    private class Node {
        int r, c;
        int time;
        boolean hasLever;
        
        public Node(int r, int c, int time, boolean hasLever) {
            this.r = r;
            this.c = c;
            this.time = time;
            this.hasLever = hasLever;
        }
    }
    
    private boolean[][][] visited;
    
    private int ROWS, COLUMNS;
    private int startR, startC;
    private int endR, endC;

    public int solution(String[] maps) {
        
        ROWS = maps.length;
        COLUMNS = maps[0].length();
        
        visited = new boolean[ROWS][COLUMNS][2]; // 0 : 레버 찾기전, 1: 레버찾은 후
    
        
        for (int i=0;i<ROWS;i++) {
            for (int j=0;j<COLUMNS;j++) {
                if (maps[i].charAt(j) == 'S') {
                    startR = i;
                    startC = j;
                }
                
                if (maps[i].charAt(j) == 'E') {
                    endR = i;
                    endC = j;
                }
            }
        }
        
      
        int answer = findLever(maps);
        return answer;
    }
    
    
    public int findLever(String[] maps) { // 출발지점에서 Lever까지
        int times = -1;
        
        int[] dr = {0,0,-1,1};
        int[] dc = {1,-1,0,0};
    
        visited[startR][startC][0] = true;
        
        Deque<Node> queue = new ArrayDeque<>();
        queue.addLast(new Node(startR, startC, 0, false));
        
        while(!queue.isEmpty()) {
            Node now = queue.pollFirst();
            
            if (maps[now.r].charAt(now.c) == 'E' && visited[now.r][now.c][1]) {
                times = now.time;
                break;    
            } 
            
            
            int lever = now.hasLever ? 1 : 0;
            
            for (int i=0;i<4;i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                
                if (!isInRange(nr,nc)) {
                    continue;
                }
                
                if (visited[nr][nc][lever] || maps[nr].charAt(nc) == 'X') {
                     continue;
                }   
                 
                
                if (maps[nr].charAt(nc) == 'L') {
                    visited[nr][nc][0] = true;
                    visited[nr][nc][1] = true;
                    
                    queue.addLast(new Node(nr,nc,now.time + 1, true));    
                    continue;
                }
                
                
                visited[nr][nc][lever] = true;
                queue.addLast(new Node(nr,nc,now.time + 1, now.hasLever));         
            } 
        }
        
                
        return times;
    }
    
    
    public boolean isInRange(int r, int c) {
        if (r < 0 || c < 0 || r >= ROWS || c >= COLUMNS) {
            return false;
        }
        return true;
    }
    
}