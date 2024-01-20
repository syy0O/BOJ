import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static boolean visited[][];
    private static int[][] woodStrength;
    private static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        woodStrength = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                woodStrength[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeBoomarang(0, 0);

        bw.write(ans + "");
        bw.flush();

        br.close();
        bw.close();
    }

    public static void makeBoomarang(int idx, int sum){

        if (idx == N * M) {
            ans = Math.max(ans, sum);
            return;
        }

        int r = idx / M;
        int c = idx % M;

        if (!visited[r][c]) {

            if (r + 1 < N && c - 1 >= 0 && !visited[r][c - 1] && !visited[r + 1][c]) {
                visited[r][c] = true;
                visited[r][c - 1] = true;
                visited[r + 1][c] = true;

                int curr = woodStrength[r][c] * 2 + woodStrength[r][c - 1] + woodStrength[r + 1][c];
                makeBoomarang(idx + 1, sum + curr);

                visited[r][c] = false;
                visited[r][c - 1] = false;
                visited[r + 1][c] = false;
            }

            if (r - 1 >= 0 && c + 1 < M && !visited[r - 1][c] && !visited[r][c + 1]) {
                visited[r][c] = true;
                visited[r - 1][c] = true;
                visited[r][c + 1] = true;
                int curr = woodStrength[r][c] * 2 + woodStrength[r - 1][c] + woodStrength[r][c + 1];
                makeBoomarang(idx + 1, sum + curr);

                visited[r][c] = false;
                visited[r - 1][c] = false;
                visited[r][c + 1] = false;
            }

            if (r - 1 >= 0 && c - 1 >= 0 && !visited[r][c - 1] && !visited[r - 1][c]) {
                visited[r][c] = true;
                visited[r][c - 1] = true;
                visited[r - 1][c] = true;
                int curr = woodStrength[r][c] * 2 + woodStrength[r][c - 1] + woodStrength[r - 1][c];
                makeBoomarang(idx + 1, sum + curr);

                visited[r][c] = false;
                visited[r][c - 1] = false;
                visited[r - 1][c] = false;
            }

            if (r + 1 < N && c + 1 < M && !visited[r][c + 1] && !visited[r + 1][c]) {
                visited[r][c] = true;
                visited[r][c + 1] = true;
                visited[r + 1][c] = true;
                int curr = woodStrength[r][c] * 2 + woodStrength[r][c + 1] + woodStrength[r + 1][c];
                makeBoomarang(idx + 1, sum + curr);

                visited[r][c] = false;
                visited[r][c + 1] = false;
                visited[r + 1][c] = false;
            }
        }

        makeBoomarang(idx + 1, sum);
    }

}
