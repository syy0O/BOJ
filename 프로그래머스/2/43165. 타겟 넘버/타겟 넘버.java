import java.util.*;

class Solution {
    
    private static int answer;
    private int[] copy;
    
    public int solution(int[] numbers, int target) {
        copy = numbers.clone();
        dfs(0,target,0);
        return answer;
    }
    
    public void dfs(int sum, int target, int idx) {
        if (idx == copy.length) {    
            if (sum == target) {
                answer++;
            }
            return;
        }
        
        dfs(sum + copy[idx], target, idx+1);
        dfs(sum + -1 * copy[idx], target, idx+1);
    }

}