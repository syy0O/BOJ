import java.io.*;
import java.util.*;

public class Main {

    private static final int SIZE = 3;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] costs = new int[N + 1][SIZE];
        int[][] dp = new int[N + 1][SIZE];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                costs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][0] = costs[1][0];
        dp[1][1] = costs[1][1];
        dp[1][2] = costs[1][2];

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < SIZE; j++) {
                dp[i][j] = Math.min(dp[i - 1][(j - 1 + SIZE) % SIZE], dp[i - 1][(j + 1) % SIZE]) + costs[i][j];
            }
        }

        System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));

    }
}
