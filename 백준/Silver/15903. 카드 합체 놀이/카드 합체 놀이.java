import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {  
            pq.add(Long.parseLong(st.nextToken()));
        }
        
        
        for (int i=0;i<m;i++) {
            long sum = pq.poll() + pq.poll();
            pq.add(sum);
            pq.add(sum);
        }
        
        long answer = 0;
        while(!pq.isEmpty()) {
            answer += pq.poll();
        }
        
        System.out.println(answer);
    }
}