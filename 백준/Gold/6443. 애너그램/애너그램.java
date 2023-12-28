import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeSet;

public class Main {

    private static int[] usedCnts;
    private static TreeSet<String> anagram;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int t = 0; t < N; t++) {

            usedCnts = new int[26];
            String word = br.readLine();
            for (int i = 0; i < word.length(); i++) {
                usedCnts[word.charAt(i) - 'a']++;
            }

            anagram = new TreeSet<>();
            dfs(word.length(), "");

            for (String s : anagram) {
                bw.write(s + "\n");
            }
        }

        bw.flush();

        br.close();
        bw.close();
    }


    private static void dfs(int len, String s) {
        if (len == s.length()) {
            anagram.add(s);
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (usedCnts[i] != 0) {
                usedCnts[i]--;
                char ch = (char) ('a' + i);
                dfs(len, s + ch);
                usedCnts[i]++;
            }
        }
    }
}
