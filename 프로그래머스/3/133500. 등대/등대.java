import java.util.*;

// 백준 2533

class Solution {
    
    private boolean[] visited;
    private List<Integer>[] edges;
    private int[][] dp;
    
    public int solution(int n, int[][] lighthouse) {
        int answer = 0;
        
        edges = new ArrayList[n+1];
        for (int i=1;i<=n;i++) {
            edges[i] = new ArrayList<>();
        }
        
        visited = new boolean[n+1];
        dp = new int[n+1][2];
        
        for(int i=0;i<n-1;i++) {
            int p = lighthouse[i][0];
            int v = lighthouse[i][1];
            
            edges[p].add(v);
            edges[v].add(p);
        }
        
    
        dfs(1);
        
        answer = Math.min(dp[1][0], dp[1][1]);
        
        return answer;
    }
    
    public void dfs(int idx){ 
        
        visited[idx] = true;
        
        dp[idx][0] = 0; // 현재 등대를 껐을 때, 켜진 등대 수의 최소 (나와 연결된 노드들은 다 켜줘야함)
        dp[idx][1] = 1; // 현재 등대를 켰을 때, 켜진 등대 수의 최소 (나와 연결된 노드들은 키든 말든 상관없음. 켰을 때와 껐을 때 중 더 작은것을 선택)
        
        // 방문한 노드에 인접한 노드 찾기
		for (int node : edges[idx]) {
			// 인접한 노드가 방문한 적이 없다면 DFS 수행
			if(visited[node]) {
				continue;
			}
            
            dfs(node);
            
            dp[idx][0] += dp[node][1];
            dp[idx][1] += Math.min(dp[node][0], dp[node][1]);
		}    
    }
}