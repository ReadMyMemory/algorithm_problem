package solved.silver.S1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] arr = new long[n]; // 생각보다 값이 커지더라. int론 택도 없다.

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st2.nextToken());

        while(m > 0) {
            Arrays.sort(arr);
            long value = arr[0] + arr[1];
            arr[0] = value;
            arr[1] = value;
            m--;
        }

        long sum = 0;

        for(int i = 0; i < n; i++)
            sum += arr[i];

        bw.write(sum+"");
        bw.flush();
        br.close();
        bw.close();
    }
}
