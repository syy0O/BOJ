import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main { // 풀이 보고 풀었음

    private static String ans;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        findMinGoodSeq("");

        bw.write(ans);
        bw.flush();

        br.close();
        bw.close();
    }

    public static void findMinGoodSeq(String curr) {
        if (curr.length() == N) {
            ans = curr;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (!checkDuplicateSection(curr + i)) {
                findMinGoodSeq(curr + i);
                if (ans != null) {
                    return;
                }
            }
        }
    }

    public static boolean checkDuplicateSection(String s){
        int maxLen = s.length() / 2;
        for (int i = 1; i <= maxLen; i++) {
            if (s.substring(s.length()-i).equals(s.substring(s.length()-2*i, s.length()-i))){
                return true;
            }
        }
        return false;
    }
}
