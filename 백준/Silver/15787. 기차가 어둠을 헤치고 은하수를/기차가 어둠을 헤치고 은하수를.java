import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    private static int[][] trains;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        trains = new int[N + 1][21];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int trainNum = Integer.parseInt(st.nextToken());

            int seatNum;
            switch(cmd) {
                case 1:
                    seatNum = Integer.parseInt(st.nextToken());
                    board(trainNum, seatNum);
                    break;
                case 2:
                    seatNum = Integer.parseInt(st.nextToken());
                    getOff(trainNum, seatNum);
                    break;
                case 3:
                    moveBack(trainNum);
                    break;
                case 4:
                    moveForward(trainNum);
                    break;
            }
        }

        int result = findCrossAbleTrains(N);
        bw.write(result+"");
        bw.flush();


        br.close();
        bw.close();
    }



    public static void board(int trainNum, int seatNum){
        if (trains[trainNum][seatNum] == 0) {
            trains[trainNum][seatNum] = 1;
        }
    }

    public static void getOff(int trainNum, int seatNum){
        if (trains[trainNum][seatNum] == 1) {
            trains[trainNum][seatNum] = 0;
        }
    }

    public static void moveBack(int trainNum) {
        for (int i = 20; i >= 1; i--) {
            trains[trainNum][i] = trains[trainNum][i - 1];
        }
    }

    public static void moveForward(int trainNum){
        for (int i = 1; i <= 19; i++) {
            trains[trainNum][i] = trains[trainNum][i + 1];
        }
        trains[trainNum][20] = 0;
    }

    public static int findCrossAbleTrains(int n){

        HashSet<String> ableTrains = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int s = 1; s <= 20; s++) {
                if (trains[i][s] == 1) {
                    sb.append('1');
                }
                else {
                    sb.append('0');
                }
            }

            if (!ableTrains.contains(sb.toString())) {
                //System.out.println("정답: "+sb.toString());
                ableTrains.add(sb.toString());
            }
        }

        return ableTrains.size();
    }
}