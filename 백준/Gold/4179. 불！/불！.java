import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    private static Character[][] maze;
    private static int[][] dist;

    private static boolean[][] visited;

    private static Deque<Node> queue;

    private static final int[] dr = {1, -1, 0, 0};
    private static final int[] dc = {0, 0, 1, -1};

    private static class Node {
        int r,c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        maze = new Character[R][C];
        dist = new int[R][C];
        visited = new boolean[R][C];
        queue = new ArrayDeque<>();
        Deque<Node> temp = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                maze[i][j] = s.charAt(j);
                if (maze[i][j] == 'J') {
                    queue.addLast(new Node(i, j));
                    visited[i][j] = true;
                }
                else if (maze[i][j] == 'F') {
                    temp.addLast(new Node(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!temp.isEmpty()) {
            queue.addFirst(temp.pollFirst());
        }

        findEscapeRoute(R,C);

        int ans = findMinEscapeTime(R,C);
        if (ans == Integer.MAX_VALUE){
            System.out.println("IMPOSSIBLE");
        }
        else {
            System.out.println(ans + 1);
        }
    }


    private static void findEscapeRoute(int R, int C){
        while(!queue.isEmpty()) {
            Node now = queue.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
                    continue;
                }

                if (visited[nr][nc] || maze[nr][nc] == '#') {
                    continue;
                }

                if (maze[now.r][now.c] == 'F') {
                    maze[nr][nc] = 'F';
                    visited[nr][nc] = true;
                    queue.addLast(new Node(nr, nc));
                }

                else if (maze[now.r][now.c] == 'J' && maze[nr][nc] != 'F') {
                        maze[nr][nc] = 'J';
                        visited[nr][nc] = true;
                        dist[nr][nc] = dist[now.r][now.c] + 1;
                        queue.addLast(new Node(nr, nc));
                }
            }
        }

    }

    private static int findMinEscapeTime(int R, int C) {

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < C; i++) {
            if (maze[0][i] == 'J' && min > dist[0][i]) {
                min = dist[0][i];
            }
            if (maze[R-1][i] == 'J' && min > dist[R-1][i]) {
                min = dist[R-1][i];
            }
        }


        for (int i = 0; i < R; i++) {
            if (maze[i][0] == 'J' && min > dist[i][0]) {
                min = dist[i][0];
            }
            if (maze[i][C-1] == 'J' && min > dist[i][C-1]) {
                min = dist[i][C-1];
            }
        }

        return min;
    }
}
