package solved.silver.S4;
import java.io.*;
import java.util.*;
public class S4_1059 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[L];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < L; i++) arr[i] = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine().trim());

        Arrays.sort(arr);

        // n이 S 안에 있으면 0
        for (int x : arr) {
            if (x == n) {
                System.out.println(0);
                return;
            }
        }

        int l = 0;      // n보다 작은 최대값 (없으면 0)
        int r = 1001;   // n보다 큰 최소값 (없으면 1001)

        for (int x : arr) {
            if (x < n) l = x;
            else if (x > n) { r = x; break; }
        }

        int answer = (n - l) * (r - n) - 1;
        System.out.println(answer);
    }
}
