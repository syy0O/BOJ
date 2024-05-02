import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int answerIdx = 0;
        
        for (int i=0;i<commands.length;i++) {
            int startIdx = commands[i][0] - 1;
            int endIdx = commands[i][1] - 1;
            int k = commands[i][2] - 1;
            
            List<Integer> temp = new ArrayList<>();
            for (int j=startIdx;j<=endIdx;j++) {
                temp.add(array[j]);
            }
            
            Collections.sort(temp);
            answer[answerIdx++] = temp.get(k);
        }        
        
        
        
        return answer;
    }
}