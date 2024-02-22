import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Long> numbers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            numbers.add(Long.parseLong(br.readLine()));
        }

        Collections.sort(numbers); // O(NlogN)

        int max = Integer.MIN_VALUE;
        Long ans = 0L;

        HashMap<Long, Integer> numberCnt = new HashMap<>();
        for (int i = 0; i < N; i++) { // O(N)
            int cnt = numberCnt.getOrDefault(numbers.get(i), 0) + 1;
            if (cnt > max) {
                ans = numbers.get(i);
                max = cnt;
            }
            numberCnt.put(numbers.get(i), cnt);
        }

        System.out.println(ans);
    }
}
