// 완전 탐색 - 백트래킹(재귀를 이용한)

import java.util.*;

class Solution {

    private int[][] fatigue = {{1,1,1},{5,1,1},{25,5,1}};
    private final int DIA = 0,IRON = 1, STONE = 2;
    private int answer = Integer.MAX_VALUE;
    
    private HashMap<String, Integer> types;
  
    public int solution(int[] picks, String[] minerals) {
        types = new HashMap<>();
        types.put("diamond", DIA);
        types.put("iron", IRON);
        types.put("stone", STONE);
        
        findMinFatigue(0,0,picks,minerals);
       
        return answer;
    }
    
    
    public void findMinFatigue(int sum, int idx, int[] picks, String[] minerals){
        if (idx >= minerals.length || !isPossible(picks)) {
            answer = Math.min(answer, sum);
            return;
        }
        
        for (int i=0;i<3;i++) {
            if (picks[i] != 0) {
                int end = idx + 5 < minerals.length ? idx + 5 : minerals.length;
                
                for (int j=idx;j<end;j++){
                    sum += fatigue[i][types.get(minerals[j])];
                }
                picks[i]--;
                
                findMinFatigue(sum, end, picks, minerals);
                
                for (int j=idx;j<end;j++){
                    sum -= fatigue[i][types.get(minerals[j])];
                }
                picks[i]++;
            }
        }
    }
    
    public boolean isPossible(int[] picks) {
        return picks[DIA] > 0 || picks[IRON] > 0 || picks[STONE] > 0;
    }
}