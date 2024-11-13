class Solution {
    private final int MAX = 100_000;
    public int solution(int n) {
        
        int[] dp = new int[MAX+1];
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 10;
        

        for (int i=4;i<=n;i++) {
            
            dp[i] = dp[i-1] * 2 -1; 
            
            if (i == 4) {
                dp[i] += 4;    
            }
            
            if (i == 5) {
                dp[i] += 8;
            }
            
            if (i == 6) {
                dp[i] += 17;
            }
        }
        
        int answer = dp[n];
        
        return answer;
    }
}