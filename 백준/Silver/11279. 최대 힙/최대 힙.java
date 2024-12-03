import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i=0;i<N;i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                int ans = pq.isEmpty() ? 0 : pq.poll();
                bw.write(ans+"\n");
                continue;
            }
            pq.add(num);
        }
        
        bw.flush();
        
        br.close();
        bw.close();
        
    }
}