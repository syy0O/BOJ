import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> existNumber = new HashMap<>();
        int result = Integer.MIN_VALUE;

        int start = 0, end = 0;
        while (end < N) {
            int endNum = numbers[end];
            int cnt = existNumber.getOrDefault(endNum, 0);
            existNumber.put(endNum, ++cnt);

            if (cnt > K) {
                while(existNumber.get(endNum) > K) {
                    int startNum = numbers[start];
                    existNumber.put(startNum, existNumber.get(startNum) - 1);
                    start++;
                }
                end++;
                continue;
            }

            result = Math.max(result, end - start + 1);
            end++;
        }


        System.out.println(result);
    }
}
