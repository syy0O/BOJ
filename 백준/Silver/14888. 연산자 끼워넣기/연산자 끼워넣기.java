import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] numbers;
    private static int[] operators;

    private static int minResult = Integer.MAX_VALUE;
    private static int maxResult = Integer.MIN_VALUE;

    private static final int OPERATORS = 4;

    private static final int PLUS = 0;
    private static final int MINUS = 1;
    private static final int MULTIPLE = 2;
    private static final int DIVIDE = 3;

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        numbers = new int[N];
        operators = new int[OPERATORS];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < OPERATORS; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(numbers[0], 1);

        System.out.println(maxResult);
        System.out.println(minResult);

    }

    public static void backtrack(int sum, int idx){

        if (idx == N) {
            minResult = Math.min(minResult, sum);
            maxResult = Math.max(maxResult, sum);
            return;
        }

        for (int i = 0; i < OPERATORS; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                switch (i) {
                    case PLUS: backtrack(sum + numbers[idx], idx + 1); break;
                    case MINUS: backtrack(sum - numbers[idx], idx + 1); break;
                    case MULTIPLE: backtrack(sum * numbers[idx], idx + 1); break;
                    case DIVIDE: backtrack(sum / numbers[idx], idx + 1); break;
                }

                operators[i]++;
            }
        }
    }
}
