import java.util.*;

class Solution {
    private final int MAX = 1_000;
    
    public long solution(int[] weights) {
        long answer = 0;
        
        Map<Long, Long> weightCnt = new TreeMap<>();        
        for (int i=0;i<weights.length;i++) {
            long cnt = weightCnt.getOrDefault((long)weights[i], 0L) + 1;
            weightCnt.put((long)weights[i], cnt);
        }
        
        for (long key : weightCnt.keySet()) {
            long cnt = weightCnt.get(key);
            if (cnt > 1) {
                answer += cnt * (cnt-1) / 2;
            }
            
            if (weightCnt.containsKey((long)(3*key/2.0))) {
                answer += cnt * weightCnt.get((long)(3*key/2.0));
            }
            
            if (weightCnt.containsKey((long)(4*key/2.0))) {
                answer += cnt * weightCnt.get((long)(4*key/2.0));
            }
            
            if (weightCnt.containsKey((long)(4*key/3.0))) {
                answer += cnt * weightCnt.get((long)(4*key/3.0));
            }

        }
        
        return answer;
    }
}