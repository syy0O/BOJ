import java.util.*;

class Solution {
    private static class Node implements Comparable<Node> {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    private static List<Node>[] graph;
    private static int[] distances;
    private final static int INF = Integer.MAX_VALUE;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        graph = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0;i< road.length;i++) {
            graph[road[i][0]].add(new Node(road[i][1], road[i][2]));
            graph[road[i][1]].add(new Node(road[i][0], road[i][2]));
        }


        dijkstra(N, 1);
        
        for (int i = 1; i <= N; i++) {
            if (distances[i] <= K) {
                answer++;
            }
        }


        return answer;
    }

    public static void dijkstra(int n, int start) {

        boolean[] visited = new boolean[n + 1];

        distances = new int[n + 1];
        Arrays.fill(distances,INF);
        distances[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            int nowVertex = pq.poll().index;

            if (visited[nowVertex]) {
                continue;
            }

            visited[nowVertex] = true;

            for (Node next : graph[nowVertex]) {
                if(distances[next.index] > distances[nowVertex] + next.cost) {
                    distances[next.index] = distances[nowVertex] + next.cost;
                    pq.add(new Node(next.index, distances[next.index]));
                }
            }
        }
    }
}