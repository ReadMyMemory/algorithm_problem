package solved.silver.S5;
import java.io.*;
import java.util.*;

public class S5_33991 {
    static int dist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static int nextTrainTime(int walkTime, int interval) {
        return ((walkTime - 1) / interval + 1) * interval;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());

        int Q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());
            int t3 = Integer.parseInt(st.nextToken());

            int d1 = dist(x, y, x1, y1);
            int d2 = dist(x, y, x2, y2);
            int d3 = dist(x, y, x3, y3);

            int ans1 = nextTrainTime(d1, t1);
            int ans2 = nextTrainTime(d2, t2);
            int ans3 = nextTrainTime(d3, t3);

            int answer = Math.min(ans1, Math.min(ans2, ans3));
            sb.append(answer).append('\n');
        }
        System.out.print(sb);
    }
}