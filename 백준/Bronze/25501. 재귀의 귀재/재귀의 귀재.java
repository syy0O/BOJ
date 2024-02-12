import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            String s = br.readLine();
            cnt = 0;
            int result = recursion(s, 0, s.length() - 1);
            bw.write(result+" "+cnt+"\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }

    public static int recursion(String s, int l, int r) {
        cnt++;
        if (l >= r) {
            return 1;
        }
        
        if (s.charAt(l) != s.charAt(r)) {
            return 0;
        }
        
        return recursion(s, l + 1, r - 1);
    }
}
