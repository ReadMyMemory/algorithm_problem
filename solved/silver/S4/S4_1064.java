package solved.silver.S4;
import java.io.*;
import java.util.*;

public class S4_1064 {

    static class Point {
        long x, y;
        Point(long x, long y) { this.x = x; this.y = y; }
    }

    static long cross(Point a, Point b, Point c) {
        long abx = b.x - a.x;
        long aby = b.y - a.y;
        long acx = c.x - a.x;
        long acy = c.y - a.y;
        return abx * acy - aby * acx;
    }

    static double dist(Point p1, Point p2) {
        long dx = p1.x - p2.x;
        long dy = p1.y - p2.y;
        return Math.hypot(dx, dy);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long ax = Long.parseLong(st.nextToken());
        long ay = Long.parseLong(st.nextToken());
        long bx = Long.parseLong(st.nextToken());
        long by = Long.parseLong(st.nextToken());
        long cx = Long.parseLong(st.nextToken());
        long cy = Long.parseLong(st.nextToken());

        Point A = new Point(ax, ay);
        Point B = new Point(bx, by);
        Point C = new Point(cx, cy);

        // 세 점이 일직선이면 불가능
        if (cross(A, B, C) == 0) {
            System.out.println(-1);
            return;
        }

        double ab = dist(A, B);
        double ac = dist(A, C);
        double bc = dist(B, C);

        double p1 = 2.0 * (ab + ac);
        double p2 = 2.0 * (ab + bc);
        double p3 = 2.0 * (ac + bc);

        double maxP = Math.max(p1, Math.max(p2, p3));
        double minP = Math.min(p1, Math.min(p2, p3));

        double ans = maxP - minP;
        System.out.printf("%.10f%n", ans);
    }
}
