package solved.bronze.B2;
import java.io.*;
import java.util.StringTokenizer;

public class B2_2399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long distance = 0L;
        int[] x = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++)
            x[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                distance += Math.abs(x[i] - x[j]);
            }
        }

        System.out.println(distance);
        br.close();
    }
}
