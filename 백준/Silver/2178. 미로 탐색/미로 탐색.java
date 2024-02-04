import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static int N,M;
    public static int map[][];
    public static final int[] dx = {0,0,1,-1};
    public static final int[] dy = {1,-1,0,0};



    private static class Node {
        int r,c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        //TODO: 출발 위치 (0,0) -> 도착위치(N-1,M-1)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int r=0;r<N;r++){
            String s = br.readLine();
            for (int c=0;c<M;c++){
                map[r][c] = Integer.parseInt(Character.toString(s.charAt(c)));
            }
        }

        ArrayDeque<Node> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        int[][] dist = new int[N][M];

        queue.addLast(new Node(0, 0));
        visited[0][0] = true;
        dist[0][0] = 1;

        while(!queue.isEmpty()){
            Node now = queue.pollFirst();
            for (int i=0;i<4;i++){
                int nr = now.r + dx[i];
                int nc = now.c + dy[i];

                if (nr <0||nc<0||nr>=N||nc>=M)
                    continue;
                if (map[nr][nc] == 0)
                    continue;
                if (!visited[nr][nc]){
                    visited[nr][nc] = true;
                    queue.addLast(new Node(nr,nc));
                    dist[nr][nc] = dist[now.r][now.c] + 1;
                }
            }
        }

        System.out.println(dist[N-1][M-1]);
    }
}
