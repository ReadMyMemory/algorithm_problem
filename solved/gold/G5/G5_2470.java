package solved.gold.G5;
import java.io.*;
import java.util.*;

public class G5_2470 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        long[] a = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a[i] = Long.parseLong(st.nextToken());

        Arrays.sort(a);

        int l = 0, r = n - 1;
        long bestAbs = Long.MAX_VALUE;
        long ans1 = a[l], ans2 = a[r];

        while (l < r) {
            long sum = a[l] + a[r];
            long abs = sum >= 0 ? sum : -sum;

            if (abs < bestAbs) {
                bestAbs = abs;
                ans1 = a[l];
                ans2 = a[r];
                if (bestAbs == 0) break;
            }

            if (sum < 0) l++;
            else r--;
        }
        if (ans1 <= ans2)
            System.out.println(ans1 + " " + ans2);
        else
            System.out.println(ans2 + " " + ans1);
    }
}
