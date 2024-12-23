import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static class Node implements Comparable<Node>{
        int num, cnt;
        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node n) {
            if (cnt == n.cnt) {
                return num - n.num;
            }
            return cnt - n.cnt;
        }
    }
    private static int[][] map;
    private static int rowLen, colLen;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[101][101];

        for (int i=0;i<3;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<3;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rowLen = 3;
        colLen = 3;

        int ans = -1;
        int times = 0;

        while (times <= 100) {

            if (map[r-1][c-1] == k) {
                ans = times;
                break;
            }

            if (rowLen >= colLen) {
                calculateR();
            }
            else {
                calculateC();
            }

            times++;
        }

        System.out.println(ans);
    }

    private static void calculateR() {
        int[][] copy = new int[101][101];
        int col = 0;
        for(int i=0;i<rowLen;i++) {
            HashMap<Integer, Integer> hash = new HashMap<>();
            for(int j=0;j<colLen;j++) { // 수의 등장 횟수
                if(map[i][j] == 0) continue;
                if(hash.containsKey(map[i][j])) {
                    hash.put(map[i][j], hash.get(map[i][j])+1);
                } else {
                    hash.put(map[i][j], 1);
                }
            }

            ArrayList<Node> list = new ArrayList<>();
            for(Map.Entry<Integer, Integer> entry:hash.entrySet()) {
                list.add(new Node(entry.getKey(), entry.getValue()));
            }
            Collections.sort(list);

            col = Math.max(col, list.size()*2);

            for(int p=0;p<list.size();p++) {
                if(p >= 50) break;
                Node node = list.get(p);
                copy[i][2*p] = node.num;
                copy[i][2*p+1]= node.cnt;
            }
        }
        colLen = Math.min(99, col);
        map = copy;
    }

    private static void calculateC() {
        int[][] copy = new int[101][101];
        int row = 0;
        for(int j=0;j<colLen;j++) {
            HashMap<Integer, Integer> hash = new HashMap<>();
            for(int i=0;i<rowLen;i++) {
                if(map[i][j] == 0) continue;
                if(hash.containsKey(map[i][j])) {
                    hash.put(map[i][j], hash.get(map[i][j])+1);
                } else {
                    hash.put(map[i][j], 1);
                }
            }

            ArrayList<Node> list = new ArrayList<>();
            for(Map.Entry<Integer, Integer> entry:hash.entrySet()) {
                list.add(new Node(entry.getKey(), entry.getValue()));
            }
            Collections.sort(list);

            row = Math.max(row, list.size()*2);

            for(int p=0;p<list.size();p++) {
                if(p >= 50) break;
                Node node = list.get(p);
                copy[2*p][j] = node.num;
                copy[2*p+1][j]= node.cnt;
            }
        }
        rowLen = Math.min(99, row);
        map = copy;
    }
}
