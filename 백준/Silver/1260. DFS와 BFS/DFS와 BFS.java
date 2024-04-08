import java.util.*;
import java.io.*;

public class Main {

    private static StringBuilder sb;
    private static boolean visited[];
    private static List<Integer>[] adj;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); // 정점 개수
        int m = Integer.parseInt(st.nextToken()); // 간선 개수
        int v = Integer.parseInt(st.nextToken()); // 탐색 시작할 정점 번호

        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            adj[p].add(q);
            adj[q].add(p);
        }

        for (int i = 1; i <= n; i++) { // 인접 리스트 정렬(번호가 작은 것부터 방문)
            Collections.sort(adj[i]);
        }

        // DFS
        visited = new boolean[n+1];
        dfs(v);
        sb.append("\n");

        // BFS
        visited = new boolean[n+1];
        bfs(v);

        System.out.println(sb);
    }

    public static void dfs(int v){
        visited[v] = true;
        sb.append(v + " ");

        for (int i = 0; i < adj[v].size(); i++) {
            if (!visited[adj[v].get(i)]) {
                dfs(adj[v].get(i));
            }
        }
    }


    public static void bfs(int v){

        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int now = queue.pollFirst();
            sb.append(now + " ");

            for (int i = 0; i < adj[now].size(); i++) {
                int next = adj[now].get(i);
                if (!visited[next]) {
                    visited[next] = true;
                    queue.addLast(next);
                }
            }
        }
    }
}
