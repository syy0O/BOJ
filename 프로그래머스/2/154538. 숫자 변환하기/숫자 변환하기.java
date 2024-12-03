//bfs..? dp,,?
import java.util.*;

class Solution {
    private final int MAX = 1_000_000;
    public int solution(int x, int y, int n) {
       
        int[] dp = new int[MAX+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[x] = 0;
        
        
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(x);
        
        while(!queue.isEmpty()) {
            int now = queue.pollFirst();
            if (now + n <= MAX && dp[now+n] > dp[now] + 1) {
                dp[now+n] = dp[now]+1;
                queue.addLast(now+n);
            }
            
            if (now * 2 <= MAX && dp[now * 2] > dp[now] + 1) {
                dp[now*2] = dp[now]+1;
                queue.addLast(now*2);
            }
            
            if (now * 3 <= MAX && dp[now * 3] > dp[now] + 1) {
                dp[now*3] = dp[now]+1;
                queue.addLast(now*3);
            }
        }
        
        
        int answer = dp[y] == Integer.MAX_VALUE ? -1 : dp[y];
        
        return answer;
    }
}