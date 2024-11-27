class Solution {
    public long solution(int[] sequence) {
       
        int n = sequence.length;
        
        long[][] dp = new long[500_000][2];
        dp[0][0] = sequence[0];
        dp[0][1] = -sequence[0];
        
        for(int i=1;i<n;i++) {

            if (i % 2 == 0) {
                dp[i][0] = Math.max(0, dp[i-1][0]) + sequence[i];   
                dp[i][1] = Math.max(0, dp[i-1][1]) - sequence[i];
            }
            else {
                dp[i][0] = Math.max(0, dp[i-1][0]) - sequence[i];
                dp[i][1] = Math.max(0, dp[i-1][1]) + sequence[i];
            }
        }
        
        
        long answer = -50_000_000_000L;
        for (int i=0;i<n;i++) {
            answer = Math.max(answer, Math.max(dp[i][0], dp[i][1]));
        }
        
        
        return answer;
    }
}