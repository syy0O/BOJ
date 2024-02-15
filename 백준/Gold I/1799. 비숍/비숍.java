import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    private static final int BLACK = 0;
    private static final int WHITE = 1;

    private static int N;
    private static int[][] map;
    private static boolean[][] isVisited;
    private static boolean[][] isBlacked;

    private static int[] result;

    static int[] dx = {-1, -1};
    static int[] dy = {1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        isVisited = new boolean[N][N];
        isBlacked = new boolean[N][N];

        result = new int[2];

        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());

                isBlacked[r][c] = (r % 2 != 0 && c % 2 != 0) || (r % 2 == 0 && c % 2 == 0);
            }
        }

        findBishopPos(0, true, 0);
        findBishopPos(0, false, 0);

        System.out.println(result[BLACK] + result[WHITE]);
    }

    public static void findBishopPos(int idx, boolean isSearchBlack, int cnt){

        for (int i = idx; i < N * N; i++) {

            int row = i / N;
            int col = i % N;

            if(isBlacked[row][col] != isSearchBlack || map[row][col] == 0 || !isPossiblePos(row,col)) {
                continue;
            }

            isVisited[row][col] = true;
            findBishopPos(i+1, isSearchBlack, cnt + 1);
            isVisited[row][col] = false;
        }

        int resultIdx = isSearchBlack ? BLACK : WHITE;
        result[resultIdx] = Math.max(result[resultIdx], cnt);

    }

    public static boolean isPossiblePos(int r, int c){
        for (int i = 0; i < 2; i++) {
            int nx = r;
            int ny = c;

            while(true){
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    break;
                }

                if (isVisited[nx][ny]) {
                    return false;
                }

                nx += dx[i];
                ny += dy[i];
            }
        }

        return true;
    }
}
