import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    private static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        distance = new int[100001];
        Arrays.fill(distance, -1);
        bfs(N, K);

        System.out.println(distance[K]);
    }


    private static void bfs(int N, int K) {

        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(N);
        distance[N] = 0;

        while (!queue.isEmpty()) {
            int now = queue.pollFirst();
            if (now == K) {
                break;
            }
            if (now-1 >= 0 && now-1 <= 100_000 && distance[now-1] == -1) {
                queue.addLast(now - 1);
                distance[now-1] = distance[now] + 1;
            }

            if (now + 1 >= 0 && now + 1 <= 100_000 && distance[now+1] == -1) {
                queue.addLast(now + 1);
                distance[now + 1] = distance[now] + 1;
            }

            if (now * 2 >= 0 && now * 2 <= 100_000 && distance[now*2] == -1) {
                queue.addLast(now * 2);
                distance[now*2] = distance[now] + 1;
            }

        }
    }
}
