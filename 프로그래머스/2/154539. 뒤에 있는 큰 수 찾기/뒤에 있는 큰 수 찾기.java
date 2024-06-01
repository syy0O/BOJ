import java.util.*;

class Solution {
        
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=numbers.length-1;i>=0;i--) {
            
            while (!stack.isEmpty() && stack.peekLast() <= numbers[i]) {
                stack.pollLast();    
            }
            
            
            if (stack.isEmpty()) {
                answer[i] = -1;
                stack.addLast(numbers[i]);
                continue;
            }
 
            answer[i] = stack.peekLast();
            stack.addLast(numbers[i]);
        }
    
     
        return answer;
    }
}