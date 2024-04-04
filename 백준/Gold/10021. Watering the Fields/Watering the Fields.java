import java.awt.Point;
import java.util.*;
import java.io.*;

public class Main {
    private static class Edge implements Comparable<Edge> {
        int start, end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return cost - e.cost;
        }
    }

    private static Point[] points;
    private static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        parents = new int[N];
        points = new Point[N];

        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y);
        }

        Queue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int cost = (int)(Math.pow(points[i].x - points[j].x, 2) + Math.pow(points[i].y - points[j].y, 2));
                pq.add(new Edge(i, j, cost));
            }
        }

        int cnt = 0;
        int sum = 0;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (edge.cost < C) {
                continue;
            }

            int start = edge.start;
            int end = edge.end;

            if (!isSameParent(start, end)) {
                sum += edge.cost;
                union(start, end);
                cnt++;
            }

            if (cnt == N - 1) {
                break;
            }
        }

        if (cnt != N - 1) {
           sum = -1;
        }

        System.out.println(sum);
    }

    public static boolean isSameParent(int start, int end) {
        int startParent = find(start);
        int endParent = find(end);

        return (startParent == endParent);
    }

    public static int find(int idx) {
        if (idx == parents[idx]) {
            return idx;
        }
        return parents[idx] = find(parents[idx]);
    }

    public static void union(int start, int end) {
        start = find(start);
        end = find(end);

        if (start != end) {
            parents[end] = start;
        }
    }

}

