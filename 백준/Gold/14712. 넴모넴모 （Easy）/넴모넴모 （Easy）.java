import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int ans = 0;
    private static boolean[][] visited;
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1][M + 1];
        backtrack(0);

        System.out.println(ans);
    }

    public static void backtrack(int cnt) {
       if (cnt == N * M) {
           ans++; // 2x2 겹치는 것 없이 잘 왔다
           return;
       }

        int x = cnt / M + 1;
        int y = cnt % M + 1;

        if (isSquared(x, y)) {
            backtrack(cnt + 1); // 둘 수 없는 곳
        }
        else {
            backtrack(cnt + 1); // 둘 수 있지만, 두지 않음

            visited[x][y] = true;
            backtrack(cnt + 1); // 둠
            visited[x][y] = false;
        }
    }

    public static boolean isSquared(int x, int y) {
        if (visited[x][y - 1] && visited[x - 1][y - 1] && visited[x - 1][y]) {
            return true;
        }
        return false;
    }

 }
