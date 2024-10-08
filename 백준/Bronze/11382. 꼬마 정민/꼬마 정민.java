import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long sum = 0;
        while(st.hasMoreTokens()){
            long operand = Long.parseLong(st.nextToken());
            sum += operand;
        }
        
        bw.write(sum+"");
        bw.flush();
        
        br.close();
        bw.close();
    }
}
