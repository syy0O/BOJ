import java.util.*;

class Solution {
    
    private boolean[] visited;
    private List<Integer>[] edges;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        edges = new ArrayList[n];
        for (int i=0;i<computers.length;i++) {
           edges[i] = new ArrayList<>();
        }
        
        for (int i=0;i<computers.length;i++) {
            for (int j=0;j<computers[0].length;j++) {
                if (i!=j && computers[i][j] == 1) {
                    edges[i].add(j);
                }
            }
        }
        
        
        visited = new boolean[n];
        for (int i=0;i<n;i++) {
            if (!visited[i]) {
                answer++;
                bfs(i);
            }   
        }
        
        return answer;
    } 
    
    public void bfs(int startNode) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(startNode);
        visited[startNode] = true;
        
        while (!queue.isEmpty()) {
            int now = queue.pollFirst();
            
            for (int node : edges[now]) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.addLast(node);
                }
            }  
        }
    }
}