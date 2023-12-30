import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder source = new StringBuilder(br.readLine());
        StringBuilder target = new StringBuilder(br.readLine());

        while (source.length() < target.length()) {
            if (target.charAt(target.length() - 1) == 'A') {
                target.deleteCharAt(target.length() - 1);
            }
            else if (target.charAt(target.length() - 1) == 'B') {
                target.deleteCharAt(target.length() - 1);
                target.reverse();
            }
        }

        int ans = target.toString().equals(source.toString()) ? 1 : 0;
        System.out.println(ans);

    }
}
