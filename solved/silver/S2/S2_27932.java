package solved.silver.S2;
import java.io.*;
import java.util.*;

public class S2_27932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] h = new int[n];
        st = new StringTokenizer(br.readLine());
        int maxH = 0;
        for (int i = 0; i < n; i++) {
            h[i] = Integer.parseInt(st.nextToken());
            if (i > 0) {
                maxH = Math.max(maxH, Math.abs(h[i] - h[i - 1]));
            }
        }

        int left = 0;
        int right = maxH;
        int answer = maxH;

        while (left <= right) {
            int mid = (left + right) / 2;
            int tired = countTiredPeople(h, n, mid);
            if (tired <= k) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    // 현재 H로, 지치는 사람 수를 반환
    private static int countTiredPeople(int[] h, int n, int H) {
        boolean[] tired = new boolean[n];
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (Math.abs(h[i] - h[i + 1]) > H) {
                if (!tired[i]) {
                    tired[i] = true;
                    count++;
                }
                if (!tired[i + 1]) {
                    tired[i + 1] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
