import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static int minValue = Integer.MAX_VALUE;
    public static int maxValue = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String number = br.readLine();

        splitNumber(number, 0);

        bw.write(minValue + " " + maxValue);
        bw.flush();
    }
    public static void splitNumber(String num, int cnt) {

        for (int s=0;s<num.length();s++){
            if (Integer.parseInt(num.charAt(s)+"") % 2 != 0) {
                cnt++;
            }
        }

        if (num.length() == 1) {
            minValue = Math.min(minValue, cnt);
            maxValue = Math.max(maxValue, cnt);
            return;
        }

        if (num.length() == 2) {
            int tens = Integer.parseInt(num) / 10;
            int units = Integer.parseInt(num) % 10;
            splitNumber(Integer.toString(tens + units), cnt);
        }

        if (num.length() >= 3){
            for (int i = 1; i < num.length() - 1; i++) {
                for (int j = i + 1; j < num.length(); j++) {
                    int first = Integer.parseInt(num.substring(0, i));
                    int second = Integer.parseInt(num.substring(i, j));
                    int third = Integer.parseInt(num.substring(j, num.length()));

                    String nextNum = Integer.toString(first + second + third);
                    splitNumber(nextNum, cnt);
                }
            }
        }

    }
}
