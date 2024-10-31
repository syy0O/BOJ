import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Integer> origin = new ArrayList<>();
        Set<Integer> numSet = new HashSet<>();
        List<Integer> temp = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
            int num = Integer.parseInt(st.nextToken());
            origin.add(num);
            numSet.add(num);
        }

        for (Integer val : numSet) {
            temp.add(val);
        }
        Collections.sort(temp);

        for (int i=0;i<N;i++) {
            int target = origin.get(i);

            int start = 0;
            int end = temp.size()-1;

            while (start < end) {
                int mid = (start+end) / 2;

                if (temp.get(mid) >= target) {
                    end = mid;
                }
                else {
                    start = mid+1;
                }
            }

            bw.write(start+" ");
        }
        bw.flush();

    }
}