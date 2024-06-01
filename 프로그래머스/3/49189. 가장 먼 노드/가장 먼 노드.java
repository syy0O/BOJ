import java.util.*;

class Solution {

    private static int[] dist;
    private static boolean[] visited;

    public int solution(int n, int[][] edge) {
       int answer = 0;
        List<Integer>[] edges = new ArrayList[n+1];
        for (int i=1;i<=n;i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i=0;i<edge.length;i++) {
            int v1 = edge[i][0];
            int v2 = edge[i][1];

            edges[v1].add(v2);
            edges[v2].add(v1);
        }

        dist = new int[n+1];
        dist[1] = 0;

        visited = new boolean[n+1];
        visited[1] = true;

        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(1);

        while(!queue.isEmpty()) {
            int now = queue.pollFirst();

            List<Integer> curr = edges[now];
            for (int vertex : curr) {
                if (!visited[vertex]){
                    visited[vertex] = true;
                    dist[vertex] = dist[now] + 1;
                    queue.addLast(vertex);
                }
            }

        }


        int max = 0;
        for (int i=2;i<=n;i++) {
            if (dist[i] > max) {
                max = dist[i];
            }
        }


        for (int i=2;i<=n;i++) {
            if (dist[i] == max) {
                answer++;
            }
        }

        return answer;
    }
}