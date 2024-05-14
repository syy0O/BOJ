class Solution {
    public long solution(int n) {
        long answer;
        int[] dp = new int[2001];
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i=3;i<=n;i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % 1_234_567;
        }
        
        answer = dp[n];
        
        return answer;
    }
}