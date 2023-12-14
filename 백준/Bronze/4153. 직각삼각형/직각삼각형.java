import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s;
        while (!(s = br.readLine()).equals("0 0 0")) {
            StringTokenizer st = new StringTokenizer(s);
            ArrayList<Integer> sides = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                sides.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(sides, Collections.reverseOrder());

            if (Math.pow(sides.get(0), 2) == Math.pow(sides.get(1), 2) + Math.pow(sides.get(2), 2)) {
                bw.write("right\n");
            }
            else {
                bw.write("wrong\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
