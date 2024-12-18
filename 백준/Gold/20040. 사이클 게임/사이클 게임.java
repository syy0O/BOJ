import java.util.*;
import java.io.*;

public class Main {

    private static int[] parents;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parents = new int[N];
        for (int i=0;i<N;i++) {
            parents[i] = i;
        }

        int answer = 0;
        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            if (findParent(num1) == findParent(num2)) {
                answer = i+1;
                break;
            }

            union(num1, num2);
        }

        System.out.println(answer);

    }


    public static int findParent(int x) {
        if (x == parents[x]) return x;
        return parents[x] = findParent(parents[x]);
    }

    public static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parents[b] = a;
        else parents[a] = b;
    }
}