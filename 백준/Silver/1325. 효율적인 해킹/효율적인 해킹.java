import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static ArrayList<Integer>[] computers;
    private static boolean[] visited;
    private static int[] results;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        results = new int[N + 1];
        computers = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            computers[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            computers[A].add(B);
        }


        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            bfs(i);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            if (results[i] > max) {
                max = results[i];
            }
        }


        for (int i = 1; i <= N; i++) {
            if (results[i] == max) {
                bw.write(i + " ");
            }
        }

        bw.flush();

        br.close();
        bw.close();
    }

    public static void bfs(int node) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(node);
        visited[node] = true;
        
        while(!queue.isEmpty()) {
            int curr = queue.pollFirst();
            for (Integer i : computers[curr]) {
                if (!visited[i]) {
                    visited[i] = true;
                    results[i]++;
                    queue.addFirst(i);
                }
            }
        }
    }
}
