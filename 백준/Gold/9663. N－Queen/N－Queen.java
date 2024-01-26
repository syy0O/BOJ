import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {
    private static int[] rows;
    private static int N;

    private static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        rows = new int[N];

        findQueensPos(0);

        bw.write(ans+"");
        bw.flush();

        br.close();
        bw.close();
    }


    private static void findQueensPos(int row){
        if (row == N) {
            ans++;
            return;
        }

        for (int c = 0; c < N; c++) {
            rows[row] = c;
            if (isPossiblePos(row)){
                findQueensPos(row + 1);
            }
        }
    }

    public static boolean isPossiblePos(int now){
        for (int i = 0; i < now; i++) {
            if (rows[i] == rows[now]) { // 열 중복 체크
                return false;
            }

            if (rows[i] + i == rows[now] + now || rows[i] - i == rows[now] - now) {
                return false;
            }
        }

        return true;
    }
}
