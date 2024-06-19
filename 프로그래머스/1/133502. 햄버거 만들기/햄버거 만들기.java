import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();

       
        for (int i=0;i<ingredient.length;i++) {
            stack.add(ingredient[i]);
            if (stack.peek() != 1 || stack.size() < 4) {
                continue;
            }
            
            int currSize = stack.size();
            if (stack.get(currSize-1) == 1 && stack.get(currSize-2) == 3 && stack.get(currSize-3) == 2 && stack.get(currSize-4) == 1){                  
                answer++;
                stack.pop();
                stack.pop();
                stack.pop();
                stack.pop();
            }
        }

        return answer;
        
    }
}