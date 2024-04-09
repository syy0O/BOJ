import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // x - 현재수 가  1) 이미 나온 수인지 2) 나오지 않았더라도 존재하기는 하는지!
        // 1)의 경우 나의 수 방문처리만 해주고 끝 -> 2)의 경우 cnt 증가

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] numbers = new int[n];
        int[] checkNumbers = new int[2000001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            checkNumbers[numbers[i]]++;
        }

        int x = Integer.parseInt(br.readLine());

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (x > numbers[i]) {
                checkNumbers[numbers[i]]--;
                if (checkNumbers[x-numbers[i]] != 0) {
                    checkNumbers[x-numbers[i]]--;
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}
