import java.util.*;
import java.io.*;

public class Main {
    
    private static List<Integer>[] edges;
    private static int[][] dp;
    private static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        dp = new int[N+1][2];
        visited = new boolean[N+1];
        
        edges = new ArrayList[N+1];
        for (int i=1;i<=N;i++) {
            edges[i] = new ArrayList<>();
        }
        
        for (int i=0;i<N-1;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            
            edges[p1].add(p2);
            edges[p2].add(p1);
        }
        
        dfs(1);
        
        int answer = Math.min(dp[1][0],dp[1][1]);
        System.out.println(answer);
       
    }
    
    public static void dfs(int n) {
        visited[n] = true;
        dp[n][0] = 0;
        dp[n][1] = 1;
        
        for (int friend : edges[n]) {
            if (visited[friend]) {
                continue;
            }
            
            dfs(friend);
            dp[n][0] += dp[friend][1];
            dp[n][1] += Math.min(dp[friend][0], dp[friend][1]);
        }
    }
}