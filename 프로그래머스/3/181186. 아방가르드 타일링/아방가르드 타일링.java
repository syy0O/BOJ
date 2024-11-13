// dp[x] - dp[x-3] = dp[x-1] + dp[x-2] * 2 + dp[x-3] * 5 + dp[x-4] - dp[x-6]
// dp[x] = dp[x-1] + dp[x-2] * 2 + dp[x-3] * 6 + dp[x-4] - dp[x-6]

class Solution {
    private final int MAX = 100_000;
    private final int MOD = 1_000_000_007;
    
    public int solution(int n) {
        
        long[] dp = new long[MAX+1];
        dp[0] = 1;
        dp[1] = 1; 
        dp[2] = 3;
        dp[3] = 10;
        dp[4] = 23;
        dp[5] = 62;
        
        for(int i = 6; i <= n; i++){
           dp[i] = (dp[i-1] + (dp[i-2] * 2) % MOD + (dp[i-3] * 6) % MOD + dp[i-4] % MOD - dp[i-6] % MOD + MOD) % MOD;
        }
        
        return (int)(dp[n] % MOD);
    }
}