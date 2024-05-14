// 인접 리스트를 만든다,
// 다익스트라..? -> destination에서 source들 까지의 거리
// 거꾸로도 풀 수 있을듯..?

// bfs로 풀 수 있을 듯. (간선의 모든 비용이 같으므로)

import java.util.*;

class Solution {
    
    
    private static int[] dist;
    private static ArrayList<Integer>[] edges;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination)     {
        
        edges = new ArrayList[n+1];
        for (int i=0;i<=n;i++) {
            edges[i] = new ArrayList<>();
        }
        
        for (int i=0;i<roads.length;i++) {
            edges[roads[i][0]].add(roads[i][1]);
            edges[roads[i][1]].add(roads[i][0]);
        }
       
        bfs(n, destination);
        
        int[] answer = new int[sources.length];
        for (int i=0; i < sources.length; i++) {
            answer[i] = dist[sources[i]];
        }
       
        return answer;
    }
    
    public static void bfs(int n, int dest) {
        
        // 거리 초기화
        dist = new int[n+1];
        Arrays.fill(dist, -1);  
        dist[dest] = 0;
    
        // 방문 초기화
        boolean[] visited = new boolean[n+1];
        visited[dest] = true;  
        
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(dest);
        
        while(!queue.isEmpty()) {  
            int now = queue.pollFirst();
               
            for (int next : edges[now]) {
                if (!visited[next]){
                    visited[next] = true;
                    dist[next] = dist[now] + 1;
                    queue.addLast(next);
                }
            }
        }
    }
}