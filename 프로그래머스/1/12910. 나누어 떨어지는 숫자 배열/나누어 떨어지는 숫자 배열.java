import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        List<Integer> sortedArr = new ArrayList<>();
        for (int element : arr) {
            if (element % divisor == 0) {
                sortedArr.add(element);
            }
        }
          
        Collections.sort(sortedArr);
        
        int[] answer = {-1};
        
        if (sortedArr.size() != 0) {
            answer = new int[sortedArr.size()];
            for (int i=0;i<sortedArr.size();i++) {
                answer[i] = sortedArr.get(i);
            }
        }
       
        return answer;
    }
}