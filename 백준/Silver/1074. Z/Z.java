import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(findSequence(N, r, c));
    }

    public static int findSequence(int n, int r, int c){
        if (n == 0) {
            return 0;
        }

        int half = (int) Math.pow(2, n - 1);

        if (r < half && c < half) {
            return findSequence(n - 1, r, c);
        }

        else if (r < half && c >= half) {
            return half * half + findSequence(n - 1, r, c - half);
        }

        else if (r>= half && c < half) {
            return 2 * half * half + findSequence(n - 1, r - half, c);
        }

        else {
            return 3 * half * half + findSequence(n - 1, r - half, c - half);
        }
    }
}
