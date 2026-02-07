package solved.bronze.B1;
import java.io.*;
import java.util.*;

public class B1_2309 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] h = new int[9];
        int total = 0;

        for (int i = 0; i < 9; i++) {
            h[i] = Integer.parseInt(br.readLine().trim());
            total += h[i];
        }

        int target = total - 100;
        int fakeA = -1, fakeB = -1;

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (h[i] + h[j] == target) {
                    fakeA = i;
                    fakeB = j;
                    break;
                }
            }
            if (fakeA != -1) break;
        }

        int[] ans = new int[7];
        int idx = 0;
        for (int i = 0; i < 9; i++) {
            if (i == fakeA || i == fakeB) continue;
            ans[idx++] = h[i];
        }

        Arrays.sort(ans);

        StringBuilder sb = new StringBuilder();
        for (int x : ans) sb.append(x).append('\n');
        System.out.print(sb);
    }
}
