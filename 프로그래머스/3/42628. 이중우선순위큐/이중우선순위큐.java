import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        
        TreeMap<Integer, Integer> pq = new TreeMap<>();
        for (int i=0;i<operations.length;i++) {
            StringTokenizer st = new StringTokenizer(operations[i]);
            String cmd = st.nextToken();
            int value = Integer.parseInt(st.nextToken());
            
            if (cmd.equals("I")) { 
                pq.put(value, pq.getOrDefault(value,0)+1);
                continue;
            }
            
            if (!pq.isEmpty()) {
               if (value == 1 && pq.get(pq.lastKey()) == 1) {
                   pq.remove(pq.lastKey());
                   continue;
               }
               
                if (value == -1 && pq.get(pq.firstKey()) == 1) {
                    pq.remove(pq.firstKey());
                }
            }            
        }
        
        
        if (!pq.isEmpty()) {
            answer = new int[2];
            answer[0] = pq.lastKey();
            answer[1] = pq.firstKey();
        }
        
        return answer;
    }
}