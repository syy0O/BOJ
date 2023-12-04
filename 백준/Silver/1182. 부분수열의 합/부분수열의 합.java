import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int result;
    public static int[] numbers;
    public static boolean[] used;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            used = new boolean[N];
            for (int j = 0; j < numbers.length; j ++) {
                used[j] = true;

            }
        }

        for (int i = 0; i < numbers.length; i++) {
            used = new boolean[N];
            used[i] = true;
            for (int m = 1; m <= N - i; m++) { // maxNumCnt
                backtrack(m, 1, numbers[i], S, i);
            }
        }

        System.out.println(result);
    }

    public static void backtrack(int numMaxCnt, int numCnt, int sum, int S, int beginIdx) {
        if (numMaxCnt == numCnt) {
            if (S == sum) {
                result++;
            }
            return;
        }

        for (int i = beginIdx; i < numbers.length; i++) {
            if (!used[i]) {
                used[i] = true;
                backtrack(numMaxCnt, numCnt + 1, sum + numbers[i], S, i);
                used[i] = false;
            }
        }
    }
}