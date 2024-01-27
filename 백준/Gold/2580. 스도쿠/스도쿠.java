import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static final int N = 9;
    private static int[][] sudoku;
    private static int[][] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sudoku = new int[N][N];
        ans = new int[N][N];

        int blankCnt = 0;
        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                sudoku[r][c] = Integer.parseInt(st.nextToken()+"");
                if (sudoku[r][c] == 0){
                    blankCnt++;
                }
            }
        }


        fillSudoku(0, blankCnt);

        printSudoku();

        br.close();
    }

    private static boolean isEnd;
    public static void fillSudoku(int idx, int blankCnt){

        if (idx == N * N) {
            isEnd = true;
            return;
        }

        int row = idx / N;
        int col = idx % N;

        if (sudoku[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                sudoku[row][col] = i;
                if (!isPossible(idx)) {
                    sudoku[row][col] = 0;
                    continue;
                }
                fillSudoku(idx + 1, blankCnt - 1);
                if (isEnd) {
                    return;
                }
                sudoku[row][col] = 0;
            }
        }
        else {
            fillSudoku(idx + 1, blankCnt);
        }
    }


    public static void startIdx(int idx) {
        int startRow = idx / 27 * 3;
        int startCol = idx % 9 / 3 * 3;

        System.out.println("startRow = " + startRow + " startCol = " + startCol);
    }

    public static boolean isPossible(int idx){
        int row = idx / N;
        int col = idx % N;

        for (int c = 0; c < N; c++) { // 가로 체크
            if (col != c && sudoku[row][c] == sudoku[row][col]) {
                return false;
            }
        }

        for (int r = 0; r < N; r++) { // 세로 체크
            if (row != r && sudoku[r][col] == sudoku[row][col]) {
                return false;
            }
        }

        int startRow = idx / 27 * 3;
        int startCol = idx % 9 / 3 * 3;

        for (int r = startRow; r < startRow + 3; r++) {
            for (int c = startCol; c < startCol + 3; c++) {
                if (r != row && c != col && sudoku[r][c] == sudoku[row][col]) {
                    return false;
                }
            }
        }

        return true;
    }


    public static void printSudoku() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                bw.write(sudoku[r][c]+" ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}

