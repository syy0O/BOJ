import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // A의 수
            int M = Integer.parseInt(st.nextToken()); // B의

            int[] A = new int[N];
            int[] B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(A);
            Arrays.sort(B);

            int cnt = 0;

            for (int i = 0; i < N; i++) {
                int curr = A[i];
                for (int j = 0; j < M; j++) {
                    if (curr <= B[j]) {
                        break;
                    }
                    cnt++;
                }
            }

            bw.write(cnt + "\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }
}
