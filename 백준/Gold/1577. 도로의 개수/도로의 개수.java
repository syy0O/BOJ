import java.io.*;
import java.util.*;

public class Main {
    private static int[][] constructionAria;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        constructionAria = new int[K][4];
        for (int k=0;k<K;k++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());

            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            constructionAria[k] = new int[]{r1, c1, r2, c2};
        }

        long[][] dp = new long[N + 1][M + 1];
        for (int i=1;i<=N;i++) {
            if (!isPossible(i-1, 0, i, 0)) {
               break;
            }

            dp[i][0] = 1;
        }

        for (int i=1;i<=M;i++) {
            if (!isPossible(0, i - 1, 0, i)) {
                break;
            }
            dp[0][i] = 1;
        }

        for (int i=1;i<=N;i++) {
            for (int j=1;j<=M;j++) {
                if (isPossible(i,j,i,j-1)) {
                    dp[i][j] += dp[i][j-1];
                }
                if (isPossible(i,j,i-1,j)) {
                    dp[i][j] += dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N][M]);

    }

    public static boolean isPossible(int r1, int c1, int r2, int c2) {

        for (int[] curr : constructionAria) {

            if (r1==curr[0] && c1 == curr[1] && r2 == curr[2] && c2 == curr[3]) {
                return false;
            }

            if (r2==curr[0] && c2 == curr[1] && r1 == curr[2] && c1 == curr[3]) {
                return false;
            }
        }

        return true;
    }
}
