import java.io.*;
import java.util.*;

public class Main {
    private static class Sheep {
        int h, w;
        public Sheep(int h, int w) {
            this.h = h;
            this.w = w;
        }
    }

    private static Character[][] map;
    private static boolean[][] visited;

    private static final int[] dh = {1, -1, 0, 0};
    private static final int[] dw = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            map = new Character[H][W];
            visited = new boolean[H][W];
            for (int h = 0; h < H; h++) {
                String s = br.readLine();
                for (int w = 0; w < W; w++) {
                    map[h][w] = s.charAt(w);
                }
            }

            int cnt = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (map[i][j] == '#' && !visited[i][j]) {
                        cnt++;
                        findSheepGroup(H, W, i, j);
                    }
                }
            }

            bw.write(cnt + "\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }

    public static void findSheepGroup(int H, int W, int h, int w){

        visited[h][w] = true;
        Deque<Sheep> queue = new ArrayDeque<>();
        queue.addLast(new Sheep(h, w));

        while (!queue.isEmpty()) {
            Sheep now = queue.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nh = now.h + dh[i];
                int nw = now.w + dw[i];

                if (nh < 0 || nw < 0 || nh >= H || nw >= W) {
                    continue;
                }

                if (visited[nh][nw] || map[nh][nw] == '.') {
                    continue;
                }

                visited[nh][nw] = true;
                queue.addLast(new Sheep(nh, nw));
            }
        }
    }
}
