import java.util.*;
import java.io.*;

public class Main {
    private static int ans = 0;
    private static int N, S;
    private static int[] numbers;
    private static boolean[] isUsed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        isUsed = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        findSubtotal(0, 0);

        System.out.println(ans);

    }


    public static void findSubtotal(int sum, int idx){
        if (sum == S && idx != 0) {
            ans++;
        }

        if (idx == N) {
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                findSubtotal(sum + numbers[i], i + 1); 
                isUsed[i] = false;
            }
        }
    }
}