import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] energy = new int[N + 1][2]; // 최소 3개 보장
        dp = new int[N + 1][2];
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            energy[i + 1][0] = Integer.parseInt(st.nextToken());
            energy[i + 1][1] = Integer.parseInt(st.nextToken());
        }

        int k = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            Arrays.fill(dp[i], 100000);
        }


        dp[1][0] = dp[1][1] = 0;

        if (N > 1) {
            dp[2][0] = energy[1][0];
        }

        if (N > 2) {
            dp[3][0] = Math.min(dp[2][0] + energy[2][0], energy[1][1]);
        }

        for (int i = 4; i <= N; i++) {
            dp[i][0] = Math.min(dp[i - 1][0] + energy[i - 1][0], dp[i - 2][0] + energy[i - 2][1]);
            dp[i][1] = Math.min(dp[i-3][0] + k, Math.min(dp[i-1][1] + energy[i-1][0], dp[i-2][1] + energy[i-2][1]));
        }

        int ans = Math.min(dp[N][0], dp[N][1]);

        System.out.println(ans);
    }
}
