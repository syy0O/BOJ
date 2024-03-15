import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] timeWithPrice = new int[N+1][2];
        int[] dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            timeWithPrice[i][0] = Integer.parseInt(st.nextToken()); // 소요 기간
            timeWithPrice[i][1] = Integer.parseInt(st.nextToken()); // 금액
        }

        for (int i = 1; i <= N; i++) {
            int endDay = i + timeWithPrice[i][0];
            if (endDay > N + 1) {
                continue;
            }

            dp[i] = Math.max(dp[i], dp[i - 1]);
            dp[endDay] = Math.max(dp[endDay], dp[i] + timeWithPrice[i][1]);
        }


        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= N + 1; i++) {
            if (ans < dp[i]) {
                ans = dp[i];
            }
        }

        System.out.println(ans);
    }
}
