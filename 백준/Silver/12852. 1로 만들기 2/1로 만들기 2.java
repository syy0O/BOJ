import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1000_001];
        int[] pre = new int[1000_001];


        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            pre[i] = i - 1;

            if (i % 3 == 0) {
                if (dp[i] > dp[i / 3] + 1) {
                    dp[i] =  dp[i / 3] + 1;
                    pre[i] = i / 3;
                }
            }

            if (i % 2 == 0) {
                if (dp[i] > dp[i / 2] + 1) {
                    dp[i] = dp[i / 2] + 1;
                    pre[i] = i / 2;
                }

            }
        }

        bw.write(dp[N] + "\n");

        int startIdx = N;
        while(startIdx >= 1) {
            bw.write(startIdx+" ");
            startIdx = pre[startIdx];
        }

        bw.flush();

        br.close();
        bw.close();
    }
}
