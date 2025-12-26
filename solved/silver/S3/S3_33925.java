package solved.silver.S3;
import java.io.*;
import java.util.*;

public class S3_33925 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int J = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();

        int low = 0, high = 0, top = 0;

        for (int i = 0; i < N; i++) {
            char x = a.charAt(i), y = b.charAt(i), z = c.charAt(i);

            // 시작(0) / 끝(N-1)은 장애물 없음이 보장
            if (x == '.' && y == '.' && z == '^') low++;          // 낮은: ..^
            else if (x == '.' && y == '^' && z == '^') high++;    // 높은: .^^
            else if (x == 'v' && y == 'v' && z == '.') top++;     // 상단: vv.
        }

        int useLow = Math.min(low, J);
        low -= useLow;
        J -= useLow;

        int useHigh = Math.min(high, J / 2);
        high -= useHigh;
        J -= useHigh * 2;

        int useTop = Math.min(top, S);
        top -= useTop;

        int hits = low + high + top;
        int finalH = H - hits * K;

        System.out.println(finalH > 0 ? finalH : -1);
    }
}
