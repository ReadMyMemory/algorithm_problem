package solved.bronze.B2;
import java.io.*;
import java.util.*;

public class B2_2750 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim());
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int x : arr) sb.append(x).append('\n');
        System.out.print(sb.toString());
    }
}
