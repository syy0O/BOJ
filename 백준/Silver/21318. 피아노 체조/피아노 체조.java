import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // N개의 악보
        // 난이도 -> 1~ 10^9
        // 1 <= x <= y <= N

        // 정답 배열을 만들어놓고 -> 구하는 식
        // 누적합 or DP

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] difficulties = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            difficulties[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1];
            if (difficulties[i - 1] > difficulties[i]) {
                dp[i]++;
            }
        }

        int q = Integer.parseInt(br.readLine());
        for (int t = 0; t < q; t++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            bw.write((dp[end] - dp[start]) + "\n");
        }

        bw.flush();

        br.close();
        bw.close();

    }
}
