import java.util.*;
import java.io.*;

public class Main {
    
    private static class Node {
        int r,c,k;
        int dist;
        
        public Node(int r, int c, int k, int dist) {
            this.r = r;
            this.c = c;
            this.k = k;
            this.dist = dist;
        }
    }
    
    public static int[][] map;
    public static int[][][] dist;
      
    private static int[] dr = {0,0,-1,1};
    private static int[] dc = {1,-1,0,0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        dist = new int[N][M][K+1];
        
        for (int i=0;i<N;i++) {
            String input = br.readLine();
            for (int j=0;j< M;j++) {
                map[i][j] = Integer.parseInt(input.charAt(j)+"");
            }
        }
        
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++) {
                for (int k=0;k<=K;k++) {
                    dist[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        
        int answer = move(N,M,K);
        System.out.println(answer);
    }
    
    public static int move(int N, int M, int K) {
        
        int answer = Integer.MAX_VALUE;
        
        Deque<Node> queue = new ArrayDeque<>();
        queue.addLast(new Node(0,0,K,1));
        dist[0][0][K] = 1;
        
        while(!queue.isEmpty()) {
            Node now = queue.pollFirst();
            if (now.r == N-1 && now.c == M-1) {
                answer = Math.min(answer, now.dist);
                continue;
            }
            
            for (int i=0;i<4;i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    continue;
                }
                
                if (map[nr][nc] != 1) {
                    if(dist[nr][nc][now.k] > now.dist + 1) {
                        dist[nr][nc][now.k] = now.dist + 1;
                        queue.addLast(new Node(nr,nc,now.k, dist[nr][nc][now.k])); 
                    } 
                    continue;
                }
                
                if (now.k > 0 && dist[nr][nc][now.k-1] > now.dist + 1) {
                    dist[nr][nc][now.k-1] = now.dist + 1;
                    queue.addLast(new Node(nr,nc,now.k-1, dist[nr][nc][now.k-1])); 
                }
            }  
        }
        
        return answer != Integer.MAX_VALUE ? answer : -1;
    }
    
    
}