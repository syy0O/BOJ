import org.w3c.dom.Node;
import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static int[] rx = {0, 0, 1, -1};
    public static int[] ry = {1, -1, 0, 0};
    
    public static int[][] map;
    public static int[][] visited; // 방문처리
    public static ArrayDeque<Point> queue; //bfs 돌리기 위한 (방문할 정점을 담아둠)
    public static ArrayList<Integer> counter = new ArrayList<>(); // 단지별 집 수
    public static int count = 0;
    private static int N;

    private static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new int[N][N];
        /* Section1. map 채우기 */
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j)-'0';
            }
        }
        
        for (int r=0; r<N;r++){
            for (int c=0;c<N;c++){
                if (map[r][c] == 1 && visited[r][c] == 0){
                    count = 0;
                    bfs(new Point(r,c));
                    counter.add(count);
                }
            }
        }
        
        /*Section3. 결과 출력 */
        Collections.sort(counter);
        bw.write(counter.size() + "\n");
        for(int i=0;i<counter.size();i++)
            bw.write(counter.get(i)+"\n");

        bw.flush();

    }

    public static void bfs(Point p){

        queue = new ArrayDeque<>();
        queue.addLast(p); // 시작 좌표
        visited[p.x][p.y] = 1;
        count++;

        while (!queue.isEmpty()) {
            Point now = queue.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + rx[i];
                int ny = now.y + ry[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < N){
                    if (map[nx][ny] == 1 && visited[nx][ny] == 0) { // 집이고 방문을 안한 상태일 때
                        visited[nx][ny] = 1;
                        queue.addLast(new Point(nx, ny));
                        count++;
                    }
                }
            }
        }
    }
}

//https://incomeplus.tistory.com/408