import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    private static int[][][] tomatoes;
    private static int[][][] dist;

    private static Deque<Node> queue;

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    private static final int[] dz = {1, -1};

    private static class Node {
        int x, y,z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        tomatoes = new int[N][M][H];
        dist = new int[N][M][H]; // 0으로 초기화



        int remainTomatoes = 0;
        queue = new ArrayDeque<>();
        for (int z = 0; z < H; z++) {
            for (int x = 0; x < N; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y = 0; y < M; y++) {
                    tomatoes[x][y][z] = Integer.parseInt(st.nextToken());
                    if (tomatoes[x][y][z] == 0) {
                        dist[x][y][z] = -1;
                        remainTomatoes++;
                    }
                    if (tomatoes[x][y][z] == 1) {
                        queue.addLast(new Node(x, y, z));
                    }
                }
            }
        }


        if (remainTomatoes == 0) {
            System.out.println(0);
        }
        else {

            bfs(H, N, M);

            int ans = findMax(H, N, M);
            System.out.println(ans);
        }
    }

    private static void bfs(int h, int n, int m) {
        while (!queue.isEmpty()) {
           Node now = queue.pollFirst();

            for (int i = 0; i < 4; i++) { // 상 하 좌 우
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (dist[nx][ny][now.z] >= 0 || tomatoes[nx][ny][now.z] == -1) {
                    continue;
                }

                dist[nx][ny][now.z] = dist[now.x][now.y][now.z] + 1;
                queue.addLast(new Node(nx, ny, now.z));
            }

            for (int i = 0; i < 2; i++) {
                int nz = now.z + dz[i];

                if (nz < 0 || nz >= h) {
                    continue;
                }

                if (dist[now.x][now.y][nz] >= 0 || tomatoes[now.x][now.y][nz] == -1) {
                    continue;
                }

                dist[now.x][now.y][nz] = dist[now.x][now.y][now.z] + 1;
                queue.addLast(new Node(now.x, now.y, nz));
            }
        }
    }

    private static int findMax(int h, int n, int m){
        int max = Integer.MIN_VALUE;
        for (int z = 0; z < h; z++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (dist[i][j][z] == -1) {
                        return -1;
                    }

                    if (max < dist[i][j][z]) {
                        max = dist[i][j][z];
                    }
                }
            }
        }

        return max;
    }
}
