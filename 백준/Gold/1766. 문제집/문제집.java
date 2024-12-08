import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] indegree = new int[N+1];
        List[] edges = new ArrayList[N+1];
        for (int i=0;i<=N;i++) {
            edges[i] = new ArrayList<>();
        }
        
        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int pre = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            
            indegree[next]++;
            edges[pre].add(next);
        }
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i=1;i<=N;i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            bw.write(curr+" ");
            
            List<Integer> edge = edges[curr];
            for (int i=0;i<edge.size();i++) {
                int val = edge.get(i);
                indegree[val]--;
                if (indegree[val] == 0) {
                    queue.add(val);
                }
            }
        }
        
        bw.flush();
        
        br.close();
        bw.close();
    }
}