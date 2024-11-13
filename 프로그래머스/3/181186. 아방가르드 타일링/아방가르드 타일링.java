import java.math.BigInteger;

class Solution {
    private final int MAX = 100_000;
    private final BigInteger MOD = BigInteger.valueOf(1_000_000_007);

    public int solution(int n) {
        BigInteger[] dp = new BigInteger[MAX + 1];
        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.ONE;
        dp[2] = BigInteger.valueOf(3);
        dp[3] = BigInteger.valueOf(10);
        dp[4] = BigInteger.valueOf(23);
        dp[5] = BigInteger.valueOf(62);

        for (int i = 6; i <= n; i++) {
            dp[i] = dp[i - 1]
                    .add(dp[i - 2].multiply(BigInteger.valueOf(2)))
                    .add(dp[i - 3].multiply(BigInteger.valueOf(6)))
                    .add(dp[i - 4])
                    .subtract(dp[i - 6])
                    .mod(MOD);
        }

        return dp[n].mod(MOD).intValue();
    }
}
