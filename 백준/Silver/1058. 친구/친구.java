import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] friendCnt = new int[n];
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == 'Y') {
                    adj[i].add(j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            visited[i] = true;

            List<Integer> now = adj[i];
            for (int j = 0; j < now.size(); j++) {
                if (!visited[now.get(j)]) {
                    visited[now.get(j)] = true;
                    friendCnt[i]++;

                    for (int r = 0; r < adj[now.get(j)].size(); r++) {
                        int curr = adj[now.get(j)].get(r);
                        if (!visited[curr] && !now.contains(curr)) {
                            friendCnt[i]++;
                            visited[curr] = true;
                        }
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (friendCnt[i] > max) {
                max = friendCnt[i];
            }
        }

        System.out.println(max);

    }
}
