package solved.silver.S4;
import java.io.*;
import java.util.*;

public class S4_2980 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int time = 0;
        int prev = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());

            // 이전 위치에서 신호등 위치까지 이동
            time += (D - prev);

            int cycle = R + G;
            int mod = time % cycle;

            // 빨간불이면 기다림
            if (mod < R) {
                time += (R - mod);
            }
            prev = D;
        }

        // 마지막 신호등에서 도로 끝까지 이동
        time += (L - prev);
        System.out.println(time);
    }
}