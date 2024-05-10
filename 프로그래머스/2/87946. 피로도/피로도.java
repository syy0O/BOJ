import java.util.*;

class Solution {
    
    private static int answer = 0;
    private static boolean[] visited;
    private static int[][] copy;
    
    public int solution(int k, int[][] dungeons) {
        copy = dungeons;
        visited = new boolean[dungeons.length];
        
        findMaxDungeonCnt(k,0,0);
        
        return answer;
    }
    
    
    public static void findMaxDungeonCnt (int fatigue, int idx, int cnt) { 
        if (idx == copy.length) { 
            answer = Math.max(answer, cnt);
            return;
        }
        
        for (int i=0;i<copy.length;i++) {
            if (!visited[i] && fatigue >= copy[i][0]) {   
                visited[i] = true;
                findMaxDungeonCnt(fatigue-copy[i][1], idx+1, cnt+1);
                visited[i] = false;
            }
            
            findMaxDungeonCnt(fatigue, idx+1, cnt);
        }
    }
}