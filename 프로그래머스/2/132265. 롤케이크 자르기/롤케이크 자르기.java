import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        int[] typeCntFromBegin = new int[topping.length];
        int[] typeCntFromEnd = new int[topping.length];
        
        // 앞에서 부터 종류에 대한 누적합
        HashSet<Integer> types = new HashSet<>();
        int typeCnt = 0;
        for (int i=0;i<topping.length;i++) {
            if (types.contains(topping[i])) {
                typeCntFromBegin[i] = typeCntFromBegin[i-1];
                continue;
            }
            
            typeCnt++;
            types.add(topping[i]);
            typeCntFromBegin[i] = typeCnt;
        }
        
        // 뒤에서부터 종류에 대한 누적합
        types = new HashSet<>();
        typeCnt = 0;
        for (int i=topping.length-1;i>=0;i--) {
            if (types.contains(topping[i])) {
                typeCntFromEnd[i] = typeCntFromEnd[i+1];
                continue;
            }
            
            typeCnt++;
            types.add(topping[i]);
            typeCntFromEnd[i] = typeCnt;
        }
        
        
        
        for (int i=0;i<topping.length-1;i++) {
            if (typeCntFromBegin[i] == typeCntFromEnd[i+1]) {
                answer++;
            }
        }
        
        
        return answer;
    }
}