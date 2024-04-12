import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[n + 1][m + 1];

        dp[1][1] = dist[1];
        for (int t = 2; t <= n; t++) {
            dp[t][0] = dp[t-1][0];
            for (int j = 1; j <= m; j++) {
                dp[t][j] = dp[t - 1][j - 1] + dist[t];
            }

            for (int exh = 1; exh <= m && t > exh; exh++) {
                dp[t][0] = Math.max(dp[t][0], dp[t-exh][exh]);
            }
        }
        
        System.out.println(dp[n][0]);

    }

}
