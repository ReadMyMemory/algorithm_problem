package solved.gold.G1;
import java.io.*;
import java.util.*;

public class G1_4373 {

    static int lowerBound(long[] arr, int targetSum) {
        int lo = 0, hi = arr.length; // [lo, hi)
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            int sum = (int) (arr[mid] >> 32);
            if (sum >= targetSum) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    static int upperBound(long[] arr, int targetSum) {
        int lo = 0, hi = arr.length; // [lo, hi)
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            int sum = (int) (arr[mid] >> 32);
            if (sum > targetSum) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        while (true) {
            String line = br.readLine();
            if (line == null) break;
            line = line.trim();
            if (line.isEmpty()) continue;

            int n = Integer.parseInt(line);
            if (n == 0) break;

            int[] s = new int[n];
            for (int i = 0; i < n; i++) {
                s[i] = Integer.parseInt(br.readLine().trim());
            }
            Arrays.sort(s);

            int m = n * (n - 1) / 2;
            long[] pairs = new long[m];
            int idx = 0;

            // (a,b) pair sums: pack into long
            // high 32 bits: sum (signed), low 16 bits: i, low 16 bits: j
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int sum = s[i] + s[j];
                    long packed = (((long) sum) << 32) | (((long) i) << 16) | (long) j;
                    pairs[idx++] = packed;
                }
            }

            Arrays.sort(pairs);

            boolean found = false;
            int answer = 0;

            // try d from largest to smallest
            for (int dIdx = n - 1; dIdx >= 0 && !found; dIdx--) {
                int dVal = s[dIdx];

                // choose c (any index except dIdx)
                for (int cIdx = 0; cIdx < n && !found; cIdx++) {
                    if (cIdx == dIdx) continue;
                    int target = dVal - s[cIdx];

                    int l = lowerBound(pairs, target);
                    int r = upperBound(pairs, target);
                    if (l == r) continue; // no such sum

                    // scan all pairs with sum == target, check distinct indices
                    for (int p = l; p < r; p++) {
                        long packed = pairs[p];
                        int aIdx = (int) ((packed >> 16) & 0xFFFF);
                        int bIdx = (int) (packed & 0xFFFF);

                        if (aIdx != cIdx && bIdx != cIdx && aIdx != dIdx && bIdx != dIdx) {
                            answer = dVal;
                            found = true;
                            break;
                        }
                    }
                }
            }

            if (found) out.append(answer).append('\n');
            else out.append("no solution\n");
        }

        System.out.print(out.toString());
    }
}
