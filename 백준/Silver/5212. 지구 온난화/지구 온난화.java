import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {1, -1, 0, 0};
    private static Character[][] map;
    private static int[][] adjoinSeaCnt;

    private static int R, C;

    private static int minRow =  11;
    private static int minColumn = 11;
    private static int maxRow = -1;
    private static int maxColumn= -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new Character[R][C];
        for (int r = 0; r < R; r++) {
            String s = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = s.charAt(c);
            }
        }

        adjoinSeaCnt = new int[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] == 'X') {
                    adjoinSeaCnt[r][c] = countSeaCnt(r, c);
                }
            }
        }
        changeLandToSea();

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if(map[r][c] == 'X') {
                    minRow = Math.min(r, minRow);
                    minColumn = Math.min(c, minColumn);

                    maxRow = Math.max(r, maxRow);
                    maxColumn = Math.max(c, maxColumn);
                }
            }
        }

        printMap();



    }

    public static void printMap(){
        for (int r = minRow; r <= maxRow; r++) {
            for (int c = minColumn; c <= maxColumn; c++) {
                System.out.print(map[r][c]);
            }
            System.out.println();
        }
    }
    public static void changeLandToSea(){

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] == 'X' && adjoinSeaCnt[r][c] >= 3) {
                    map[r][c] = '.';
                }
            }
        }
    }


    public static int countSeaCnt(int nowX, int nowY) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = nowX + dx[i];
            int ny = nowY + dy[i];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] == '.') {
                cnt++;

            }
        }
        return cnt;
    }
}
