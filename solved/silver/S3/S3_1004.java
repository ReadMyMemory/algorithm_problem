package solved.silver.S3;
import java.io.*;
import java.util.*;

public class S3_1004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            // 1. 출발점과 도착점
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // 2. 행성계의 개수
            int n = Integer.parseInt(br.readLine());
            int count = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                // 출발점과 도착점이 원의 내부/외부인지 판정
                boolean startIn = isInside(x1, y1, cx, cy, r);
                boolean endIn = isInside(x2, y2, cx, cy, r);
                // 둘 중 하나만 내부에 있으면 진입/이탈 카운트
                if (startIn != endIn) count++;
            }
            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    // 점 (x, y)가 원 (cx, cy, r) 안에 있는지
    private static boolean isInside(int x, int y, int cx, int cy, int r) {
        int dx = x - cx;
        int dy = y - cy;
        return dx * dx + dy * dy < r * r;
    }
}
