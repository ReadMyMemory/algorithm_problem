package solved.silver.S1;
import java.io.*;
import java.util.*;

public class S1_6487 {

    static class LineABC {
        long A, B, C;
        LineABC(long A, long B, long C) {
            this.A = A; this.B = B; this.C = C;
        }
    }

    static LineABC toABC(long x1, long y1, long x2, long y2) {
        long A = y2 - y1;
        long B = x1 - x2;
        long C = A * x1 + B * y1;
        return new LineABC(A, B, C);
    }

    static boolean onLine(LineABC L, long x, long y) {
        return L.A * x + L.B * y == L.C;
    }

    static double fixNegZero(double v) {
        if (Math.abs(v) < 0.0005) return 0.0; // 소수 둘째 자리 반올림 기준으로 -0.00 방지
        return v;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine().trim());

        for (int tc = 0; tc < N; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x1 = Long.parseLong(st.nextToken());
            long y1 = Long.parseLong(st.nextToken());
            long x2 = Long.parseLong(st.nextToken());
            long y2 = Long.parseLong(st.nextToken());
            long x3 = Long.parseLong(st.nextToken());
            long y3 = Long.parseLong(st.nextToken());
            long x4 = Long.parseLong(st.nextToken());
            long y4 = Long.parseLong(st.nextToken());

            LineABC L1 = toABC(x1, y1, x2, y2);
            LineABC L2 = toABC(x3, y3, x4, y4);

            long det = L1.A * L2.B - L2.A * L1.B;

            if (det != 0) {
                // 교점 1개
                long nx = L1.C * L2.B - L2.C * L1.B;
                long ny = L1.A * L2.C - L2.A * L1.C;

                double x = (double) nx / (double) det;
                double y = (double) ny / (double) det;

                x = fixNegZero(x);
                y = fixNegZero(y);

                sb.append(String.format(Locale.US, "POINT %.2f %.2f", x, y));
            } else {
                // 평행 또는 일치 L1 위에 L2의 한 점이 올라가면 같은 직선으로 판단함
                if (onLine(L1, x3, y3) && onLine(L1, x4, y4)) sb.append("LINE");
                else sb.append("NONE");
            }

            if (tc + 1 < N) sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}
