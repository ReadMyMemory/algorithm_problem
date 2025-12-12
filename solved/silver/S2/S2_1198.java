package solved.silver.S2;
import java.io.*;
import java.util.*;

public class S2_1198 {

    static class Point {
        long x, y;
        Point(long x, long y) { this.x = x; this.y = y; }
    }

    static long cross(Point a, Point b, Point c) {
        // (b-a) x (c-a)
        long x1 = b.x - a.x;
        long y1 = b.y - a.y;
        long x2 = c.x - a.x;
        long y2 = c.y - a.y;
        return x1 * y2 - y1 * x2;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        Point[] p = new Point[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            p[i] = new Point(x, y);
        }

        long maxArea2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    long area2 = Math.abs(cross(p[i], p[j], p[k]));
                    if (area2 > maxArea2) maxArea2 = area2;
                }
            }
        }

        double ans = maxArea2 / 2.0;
        System.out.printf("%.10f%n", ans);
    }
}
