import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static boolean[] used;
    private static String[] words;
    private static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        used = new boolean[26];

        words = new String[N]; // 2*15*50 -> 1500Byte
        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder(br.readLine());
            words[i] = sb.substring(4,sb.length() - 4);
        }

        if (K >= 5) {
            initUsed();
            findMaxReadableWord(5, K, 0);
        }

        bw.write(ans+"");
        bw.flush();

        br.close();
        bw.close();
    }

    public static void initUsed(){
        used['a'-'a'] = true;
        used['n'-'a'] = true;
        used['t'-'a'] = true;
        used['i'-'a'] = true;
        used['c'-'a'] = true;
    }

    public static void findMaxReadableWord(int cnt, int K, int startIdx){
        if (cnt == K) {
            int curr = 0;
            for (int i = 0; i < words.length; i++) {
                String s = words[i];
                boolean flag = true;

                for (int j = 0; j< s.length(); j++) {
                    if (!used[s.charAt(j)-'a']) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    curr++;
                }
            }

            ans = Math.max(ans, curr);
            return;
        }

        for (int i = startIdx; i < 26; i++) {
            if (!used[i]) {
                used[i] = true;
                findMaxReadableWord(cnt + 1, K, i + 1);
                used[i] = false;
            }
        }
    }
}
