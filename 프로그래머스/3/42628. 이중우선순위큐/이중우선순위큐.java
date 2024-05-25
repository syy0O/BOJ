import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        
        TreeSet<Integer> pq = new TreeSet<>();
        for (int i=0;i<operations.length;i++) {
            StringTokenizer st = new StringTokenizer(operations[i]);
            String cmd = st.nextToken();
            int value = Integer.parseInt(st.nextToken());
            
            if (cmd.equals("I")) { 
                pq.add(value);
                continue;
            }
            
            if (!pq.isEmpty()) {
               if (value == 1) {
                   pq.remove(pq.last());
               }
                else  {
                    pq.remove(pq.first());
                }
            }            
        }
        
        
        if (!pq.isEmpty()) {
            answer = new int[2];
            answer[0] = pq.last();
            answer[1] = pq.first();
        }
        
        return answer;
    }
}