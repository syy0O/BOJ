import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int answer = Integer.MAX_VALUE;
    public static boolean visited[];
    public static int[][] w;

    public static int originStart;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        w = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            originStart = i;
            visited[i] = true;
            backtrack(N, 1, 0, i);
            visited[i] = false;
        }


        System.out.println(answer);

    }

    public static void backtrack(int N, int visitedCnt, int costSum, int from){
        if (visitedCnt == N) {
            if (w[from][originStart] != 0) {
                answer = Math.min(answer, costSum + w[from][originStart]);
            }
            return;
        }

        for (int i = 0; i < N ; i++) {
            if (!visited[i] && w[from][i] != 0 && from != i) {
                visited[i] = true;
                backtrack(N, visitedCnt + 1, costSum + w[from][i], i);
                visited[i] = false;
            }
        }

    }
}
