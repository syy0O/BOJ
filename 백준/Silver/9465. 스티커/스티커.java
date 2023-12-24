import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] dp = new int[2][N];
            int[][] stickers = new int[2][N];

            for (int r = 0; r < 2; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    stickers[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = stickers[0][0];
            dp[1][0] = stickers[1][0];

            if (N != 1) {
                dp[0][1] = dp[1][0] + stickers[0][1];
                dp[1][1] = dp[0][0] + stickers[1][1];

                for (int c = 2; c < N; c++) {
                    for (int r = 0; r < 2; r++) {
                        int preRow = (r + 1) % 2;
                        dp[r][c] = Math.max(dp[preRow][c - 2], dp[preRow][c - 1]) + stickers[r][c];
                    }
                }
            }

            int ans = Math.max(dp[0][N - 1], dp[1][N - 1]);
            bw.write(ans+"\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }
}
