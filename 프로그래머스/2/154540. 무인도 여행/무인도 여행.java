// bfs 
import java.util.*;

class Solution {
    
    private static class Island {
        int x, y, day;
        public Island(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
    
    private static final int[] dx = {1,-1,0,0};
    private static final int[] dy = {0,0,-1,1};
    
    private static boolean[][] visited;
    
    private static int row, column;

    public int[] solution(String[] maps) {
       
        row = maps.length;
        column = maps[0].length();
        
        visited = new boolean[row][column];
        
        List<Integer> totalDays = new ArrayList<>();
        for (int i=0;i<row;i++) {
            for (int j=0;j<column;j++) {
                if (!visited[i][j] && maps[i].charAt(j) != 'X') {    
                    int total = findMaxDay(i,j,maps);
                    totalDays.add(total);
                }
            }
        }
        
        Collections.sort(totalDays);
        
        int[] answer = {-1};
        if (totalDays.size() != 0) {
            answer = new int[totalDays.size()];
            for (int i=0;i<answer.length;i++) {
                answer[i] = totalDays.get(i);
            }
        }
        
        return answer;
    }
    
    public static int findMaxDay(int x, int y, String[] maps) {
        
        Deque<Island> queue = new ArrayDeque<>();
        queue.add(new Island(x,y, Integer.parseInt(maps[x].charAt(y)+"")));
        visited[x][y] = true;
        
        int totalDay = 0;
        while (!queue.isEmpty()) {
            
            Island now = queue.pollFirst();
            totalDay += now.day;
            
            for (int i=0;i<4;i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= row || ny >= column) {
                    continue;
                }
                
                if (visited[nx][ny] || maps[nx].charAt(ny) == 'X') {
                    continue;
                }
                
                 visited[nx][ny] = true;
                 int nday = Integer.parseInt(maps[nx].charAt(ny)+"");
                 queue.addLast(new Island(nx,ny,nday));
            }
        }
        
        return totalDay;
    }
}