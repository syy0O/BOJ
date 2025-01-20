import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        int[] lis = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        
        lis[0] = numbers[0];
        int length = 1;
        for (int i=1; i < N; i++) {
            int key = numbers[i];

            if (key > lis[length-1]) {
                length++;
                lis[length-1] = key;
            }
            else {
                int lo = 0;
                int hi = length;
                while (lo < hi) {
					int mid = (lo + hi) / 2;
					
					if(lis[mid] < key) {
						lo = mid + 1;
					}
					else {
						hi = mid;
					}
				}
                
                lis[lo] = key;
            }
        }
          
        System.out.println(length);
    }
}