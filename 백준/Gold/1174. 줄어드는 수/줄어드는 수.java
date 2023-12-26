import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    private static final int[] numbers = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    private static ArrayList<Long> descNumber;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        descNumber = new ArrayList<>();

        dfs(0, 0);
        Collections.sort(descNumber);

        try {
            System.out.println(descNumber.get(N - 1));
        }catch(Exception e) {
            System.out.println(-1);
        }
    }

    public static void dfs(long num, int idx) {

        if (!descNumber.contains(num)) {
            descNumber.add(num);
        }

        if (idx >= 10) {
            return;
        }

        dfs(num * 10 + numbers[idx], idx + 1);
        dfs(num, idx + 1);
    }
}
