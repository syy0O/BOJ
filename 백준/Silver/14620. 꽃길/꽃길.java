import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] map;

    private static int result = Integer.MAX_VALUE;

    private static int N;

    private static boolean[][] visited;

    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        findPlace(0,0);
        System.out.println(result);
    }

    public static void findPlace(int count, int priceSum){

        if (count == 3) {
            result = Math.min(result, priceSum);
            return;
        }

        for (int r = 1; r < N; r++) {
            for (int c = 1; c < N; c++) {
                if (!visited[r][c] && isPossible(r,c)) {
                    markVisited(r, c);
                    priceSum += getTotalPrice(r, c);

                    findPlace(count + 1, priceSum);
                    
                    priceSum -= getTotalPrice(r, c);
                    resetVisited(r, c);
                }
            }
        }

    }


    public static boolean isPossible(int x, int y) {

        for (int p = 0; p < 4; p++) {
            int nx = x + dx[p];
            int ny = y + dy[p];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) {
                return false;
            }
        }
        
        return true;
    }

    public static int getTotalPrice(int x, int y) {
        int price = map[x][y];
        for (int p = 0; p < 4; p++) {
            int nx = x + dx[p];
            int ny = y + dy[p];
            price += map[nx][ny];
        }
        return price;
    }

    public static void markVisited(int x, int y) {
        visited[x][y] = true;
        for (int p = 0; p < 4; p++) {
            int nx = x + dx[p];
            int ny = y + dy[p];
            visited[nx][ny] = true;
        }
    }

    public static void resetVisited(int x, int y) {
        visited[x][y] = false;
        for (int p = 0; p < 4; p++) {
            int nx = x + dx[p];
            int ny = y + dy[p];
            visited[nx][ny] = false;
        }
    }
}
