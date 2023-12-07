import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static int[] numbers;
    private static ArrayList<Integer> operators;
    private static boolean[] used;

    private static int minResult = Integer.MAX_VALUE;
    private static int maxResult = Integer.MIN_VALUE;

    private static final int OPERATORS = 4;

    private static final int PLUS = 0;
    private static final int MINUS = 1;
    private static final int MULTIPLE = 2;
    private static final int DIVIDE = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        numbers = new int[N];
        operators = new ArrayList<>();
        used = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < OPERATORS; i++) {
            int operatorCnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < operatorCnt; j++) {
                operators.add(i);
            }
        }

        backtrack(N, numbers[0], 1);
        System.out.println(maxResult);
        System.out.println(minResult);

    }

    public static void backtrack(int N, int sum, int nextNumberIdx){

        if (nextNumberIdx == N) {
            minResult = Math.min(minResult, sum);
            maxResult = Math.max(maxResult, sum);
            return;
        }

        for (int i = 0; i < N - 1; i++) {
            if (!used[i]) {
                used[i] = true;
                int calculateResult = calculate(operators.get(i), numbers[nextNumberIdx], sum);
                backtrack(N, calculateResult, nextNumberIdx + 1);
                used[i] = false;
            }
        }
    }


    public static int calculate(int operator, int operand, int sum) {
        if (operator == PLUS) {
            return sum + operand;
        }

        else if (operator == MINUS) {
            return sum - operand;
        }

        else if (operator == MULTIPLE) {
            return sum * operand;
        }

        else {
            boolean flag = false;
            if (sum < 0) {
                sum *= -1;
                flag = true;
            }

            return flag ? (sum / operand) * -1 : sum / operand;
        }
    }
}
