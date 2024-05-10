import java.util.*;

class Solution {
    
    private static boolean[] used;
    private static int dungeonCnt = 0;
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        used = new boolean[dungeons.length];
        
        findMaxDungeon(k,0,0,dungeons);
        answer = dungeonCnt;
        return answer;
    }
    
    
    public static void findMaxDungeon (int fatigue, int cnt, int ans, int[][] dungeons) {
        
        if (cnt == dungeons.length) {
            dungeonCnt = Math.max(dungeonCnt, ans);
            return;
        }
        
        
        for (int i=0;i<dungeons.length;i++) {
            if (!used[i] && fatigue >= dungeons[i][0]) {   
                used[i] = true;
                findMaxDungeon(fatigue-dungeons[i][1], cnt+1, ans+1, dungeons);
                used[i] = false;
            }
            
            findMaxDungeon(fatigue, cnt+1, ans, dungeons);
        }
    }
}