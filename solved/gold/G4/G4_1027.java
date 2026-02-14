package solved.gold.G4;
import java.io.*;
import java.util.*;

public class G4_1027 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        long[] h = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) h[i] = Long.parseLong(st.nextToken());

        int answer = 0;

        for (int i = 0; i < n; i++) {
            int cnt = 0;

            long bestNum = Long.MIN_VALUE;
            long bestDen = 1;
            for (int j = i + 1; j < n; j++) {
                long num = h[j] - h[i];
                long den = j - i;

                if (bestNum == Long.MIN_VALUE || num * bestDen > bestNum * den) {
                    cnt++;
                    bestNum = num;
                    bestDen = den;
                }
            }

            bestNum = Long.MIN_VALUE;
            bestDen = 1;
            for (int j = i - 1; j >= 0; j--) {
                long num = h[j] - h[i];
                long den = i - j;

                if (bestNum == Long.MIN_VALUE || num * bestDen > bestNum * den) {
                    cnt++;
                    bestNum = num;
                    bestDen = den;
                }
            }
            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
    }
}
