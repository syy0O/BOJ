import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static int ans;
    private static boolean[] players;
    private static int[][] positionAbilities;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int test = 0; test < T; test++) {
            ans = Integer.MIN_VALUE;
            positionAbilities = new int[12][12];
            players = new boolean[12];

            for (int i = 1; i <= 11; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= 11; j++) {
                    positionAbilities[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(1, 0);
            bw.write(ans + "\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }

    public static void dfs(int pos, int sum) {
        if (pos > 11) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 1; i <= 11; i++) {
            if (!players[i] && positionAbilities[i][pos] != 0) {
                players[i] = true;
                dfs(pos + 1, sum + positionAbilities[i][pos]);
                players[i] = false;
            }
        }
    }
}
