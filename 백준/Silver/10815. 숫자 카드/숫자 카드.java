import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { // 숫자 카드 (Binary Search)

    public static int cards[];
    public static int binarySearch(int target){

        int low = 0;
        int high = cards.length-1;
        int mid;

        while(low<=high){
            mid = (low+high)/2;
            if (cards[mid] == target)
                return 1;
            else if (cards[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
        int N = Integer.parseInt(br.readLine());
        cards = new int[N];
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N;i++)
            cards[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine());
        int [] search = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M;i++)
            search[i] = Integer.parseInt(st.nextToken());


        for (int i=0 ; i<M; i++)
            System.out.print(binarySearch(search[i])+" ");

    }
}
