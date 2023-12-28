import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

class Solution
{
    private static String ansFormat = "#%d %d";
	public static void main(String args[]) throws Exception
	{
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {

            int testNum = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            HashMap<Integer, Integer> hashMap = new HashMap<>();

            for (int i = 0; i < 1000; i++) {
                int curr = Integer.parseInt(st.nextToken());
                if (hashMap.containsKey(curr)) {
                    hashMap.put(curr, hashMap.get(curr) + 1);
                }
                else {
                    hashMap.put(curr, 1);
                }
            }

            int max = Integer.MIN_VALUE;
            for (Integer value : hashMap.values()) {
                if (value > max) {
                    max = value;
                }
            }

            int ans = Integer.MIN_VALUE;
            for (Integer key : hashMap.keySet()) {
                if (max == hashMap.get(key) && ans < key) {
                    ans = key;
                }
            }

            bw.write(String.format(ansFormat, testNum, ans)+"\n");
        }

        bw.flush();

        br.close();
        bw.close();
		
	}
}