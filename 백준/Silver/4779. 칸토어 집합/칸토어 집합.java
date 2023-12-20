import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while((input = br.readLine()) != null && !input.isEmpty()) {
            int N = Integer.parseInt(input);
            sb = new StringBuilder();
            int len =  (int) Math.pow(3, N);
            divideString(0, len - 1);
            System.out.println(sb.toString());
        }

    }


    public static void divideString(int start, int end) {
        if (start == end) {
            sb.append("-");
            return;
        }

        int len = end - start + 1;
        divideString(start, start + len / 3 - 1);

        for (int i = start + len / 3; i <= start + len / 3 * 2 - 1; i++) {
            sb.append(" ");
        }

        divideString(start + len / 3 * 2, end);

    }
}
