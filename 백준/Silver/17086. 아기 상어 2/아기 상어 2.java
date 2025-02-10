import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    private static int[][] map;
    private static int[][] dist;
    private static boolean[][] visited;
    private static Deque<Shark> sharks;

    private static class Shark {
        int r, c;
        public Shark(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        sharks = new ArrayDeque<>();
        map = new int[N][M];
        visited = new boolean[N][M];
        dist = new int[N][M];

        for (int r=0;r<N;r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0;c <M;c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == 1) {
                    sharks.add(new Shark(r, c));
                    visited[r][c] = true;
                }
            }
        }


        bfs(N,M);

        int answer = Integer.MIN_VALUE;
        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) {
                answer = Math.max(answer, dist[i][j]);
            }
        }

        System.out.println(answer);

    }

    public static void bfs(int N, int M) {

        int[] dr = {0, 0, -1, 1,1,1,-1,-1};
        int[] dc = {1, -1, 0, 0,1,-1,1,-1};

        while (!sharks.isEmpty()) {

            Shark curr = sharks.pollFirst();
            for (int i=0;i<8;i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M){
                    continue;
                }

                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    dist[nr][nc] = dist[curr.r][curr.c] + 1;
                    sharks.addLast(new Shark(nr, nc));
                }
            }
        }
    }
}
