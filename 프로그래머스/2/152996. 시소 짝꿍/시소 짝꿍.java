import java.util.*;

class Solution {
    private final int MAX = 1_000;
    
    public long solution(int[] weights) {
        long answer = 0;
        
        Map<Double, Integer> weightCnt = new TreeMap<>();        
        for (int i=0;i<weights.length;i++) {
            int cnt = weightCnt.getOrDefault((double)weights[i], 0) + 1;
            weightCnt.put((double)weights[i], cnt);
        }
        
        for (double key : weightCnt.keySet()) {
            long cnt = weightCnt.get(key);
            if (cnt > 1) {
                answer += cnt * (cnt-1) / 2;
            }
            
            if (weightCnt.containsKey(3*key/2)) {
                answer += cnt * weightCnt.get(3*key/2);
            }
            
            if (weightCnt.containsKey(4*key/2)) {
                answer += cnt * weightCnt.get(4*key/2);
            }
            
            if (weightCnt.containsKey(4*key/3)) {
                answer += cnt * weightCnt.get(4*key/3);
            }

        }
        
        return answer;
    }
}