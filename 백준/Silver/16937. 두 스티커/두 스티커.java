import java.io.*;
import java.util.*;

public class Main {
    private static class Sticker {
        int r, c;
        public Sticker(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static List<Sticker> stickers;
    private static int result = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());
        stickers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (r <= H && c <= W || r <= W && c <= H) {
                stickers.add(new Sticker(r, c));
            }
        }

        if (stickers.size() < 2) {
            System.out.println(0);
            return;
        }

        pickSticker(0, 0, 0, W, H);
        System.out.println(result);
    }

    public static void pickSticker(int curr, int cnt, int sum, int w, int h){

        if (cnt == 2) { // 현재 개수가 2와 같으면 지금까지의 합과 비교 -> result 갱신
            result = Math.max(result, sum);
            return;
        }

        //현재 개수가 2보다 작으면, 스티커를 뽑을 수 있다.
        for (int i = curr; i < stickers.size(); i++) {
            Sticker sticker = stickers.get(i);
            int weight = sticker.r * sticker.c;

            if (sticker.r <= h && sticker.c <= w) { // 정방향
                pickSticker(i+1, cnt+1, sum+weight, w-sticker.c, h);
                pickSticker(i + 1, cnt + 1, sum + weight, w, h - sticker.r);
            }

            if (sticker.c <= h && sticker.r <=w) { // 회전한 방향
                pickSticker(i+1, cnt+1, sum+weight, w-sticker.r, h);
                pickSticker(i + 1, cnt + 1, sum + weight, w, h - sticker.c);
            }
        }
    }
}
