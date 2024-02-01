import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    private static int N,H,D;
    private static Character[][] map;
    private static int[][] enable;

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    private static int ans = Integer.MAX_VALUE;

    private static class Node {
        int x, y;
        int health, durability, dist;
        public Node (int x, int y,int health, int durabillity, int dist){
            this.x = x;
            this.y = y;
            this.health = health;
            this.durability = durabillity;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new Character[N][N];
        enable = new int[N][N];

        int startX = 0;
        int startY = 0;

        for (int r = 0; r < N; r++) {
            String s = br.readLine();
            for (int c = 0; c < N; c++) {
                map[r][c] = s.charAt(c);
                if (map[r][c] == 'S') {
                    startX = r;
                    startY= c;
                }
            }
        }

        bfs(startX, startY);
        System.out.println(ans+"");

    }

    public static void bfs(int x, int y){
        Deque<Node> queue = new ArrayDeque<>();
        queue.addLast(new Node(x, y, H,  0,0));
        enable[x][y] = H;

        while (!queue.isEmpty()) {
            Node now = queue.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N ) { // 범위를 넘어감
                    continue;
                }


                int durability = now.durability;
                int health = now.health;
                int dist = now.dist;

                if (map[nx][ny] == 'U') {
                    durability = D;
                }

                if (map[nx][ny] != 'E' && map[nx][ny] != 'S') {
                    if (durability != 0) {
                        durability--;
                    }
                    else {
                        health--;
                    }
                }

                if (health == 0) {
                    continue;
                }

                if (map[nx][ny] == 'E') {
                    ans = Math.min(ans, now.dist + 1);
                    return;
                }

                if (enable[nx][ny] < health + durability) {
                    enable[nx][ny] = health + durability;
                    queue.addLast(new Node(nx, ny, health, durability, dist + 1));
                }

            }
        }

        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }
    }
}
