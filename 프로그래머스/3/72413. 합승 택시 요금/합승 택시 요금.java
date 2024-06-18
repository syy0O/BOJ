import java.util.*;

class Solution {
    
    private class Node implements Comparable<Node>{
        int num;
        int cost;
        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node n) {
            return cost - n.cost;
        }
    }
    
   
    private List<Node>[] edges;   
    private final int INF = Integer.MAX_VALUE;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
     
        edges = new ArrayList[n+1];
        for (int i=1;i<=n;i++) {
            edges[i] = new ArrayList<>();    
        }
        
        
        for (int i=0;i<fares.length;i++) {
            edges[fares[i][0]].add(new Node(fares[i][1], fares[i][2]));
            edges[fares[i][1]].add(new Node(fares[i][0], fares[i][2]));
        }
       

        int[] startA = dijkstra(a,n);
        int[] startB = dijkstra(b,n);
        int[] startS = dijkstra(s,n);
      
        int[] totalDistances = new int[n+1];
        
        answer = Integer.MAX_VALUE;
        for (int i=1;i<=n;i++) {
            totalDistances[i] = startA[i] + startB[i] + startS[i];
            if (answer > totalDistances[i]) {
                answer = totalDistances[i];
            }
        }
          
        return answer;
    }
    
    
    public int[] dijkstra(int start, int n){
          
        int minDistance = 0;
        
        int[] distances = new int[n+1];
        Arrays.fill(distances, INF);
        
        distances[start] = 0;
        boolean[] visited = new boolean[n+1];   
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));
        
        while (!pq.isEmpty()) {
            
            Node currNode = pq.poll();
            
            if (visited[currNode.num]) {
                continue;
            }
            
            visited[currNode.num] = true;
        
            
            for (Node vertex : edges[currNode.num]) {
                if (distances[vertex.num] > distances[currNode.num] + vertex.cost) {
                    distances[vertex.num] = distances[currNode.num] + vertex.cost;
                    pq.add(new Node(vertex.num, distances[vertex.num]));
                }
            }
        }
        
        return distances;
        
    }
}