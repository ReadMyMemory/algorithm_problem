package solved.gold.G4;
import java.io.*;
import java.util.*;

public class G4_2110 {
    static int N, C;
    static int[] x;

    static boolean canInstall(int dist) {
        int count = 1;
        int last = x[0];

        for (int i = 1; i < N; i++) {
            if (x[i] - last >= dist) {
                count++;
                last = x[i];
                if (count >= C) return true;
            }
        }
        return count >= C;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        x = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = Integer.parseInt(br.readLine().trim());
        }

        Arrays.sort(x);

        int lo = 1;
        int hi = x[N - 1] - x[0];
        int ans = 0;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (canInstall(mid)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
