import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    private static int[][] canvas;
    private static boolean [][] visited;

    private static int n,m;

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    private static class Node {
        int x;
        int y;
        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        canvas = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                canvas[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int paintingCnt = 0;
        int maxArea = Integer.MIN_VALUE;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (!visited[x][y] && canvas[x][y] == 1) {
                    paintingCnt++;
                    int currArea = findPaintingArea(x, y);
                    maxArea = Math.max(maxArea, currArea);
                }
            }
        }

        if (paintingCnt == 0) {
            maxArea = 0;
        }
        
        bw.write(paintingCnt + "\n" + maxArea);
        bw.flush();

        br.close();
        bw.close();
    }


    private static int findPaintingArea(int x, int y) {
        Deque<Node> queue = new ArrayDeque<>();
        queue.addLast(new Node(x, y));
        visited[x][y] = true;

        int area = 0;
        while (!queue.isEmpty()) {
            Node now = queue.pollFirst();
            area++;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (visited[nx][ny] || canvas[nx][ny] == 0) {
                    continue;
                }

                visited[nx][ny] = true;
                queue.addLast(new Node(nx, ny));
            }
        }

        return area;
    }
}
