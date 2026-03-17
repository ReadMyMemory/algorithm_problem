package solved.bronze.B1;
import java.io.*;

public class B1_10989 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] count = new int[10001];

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            count[num]++;
        }

        for (int i = 1; i <= 10000; i++) {
            while (count[i]-- > 0) {
                bw.write(i + "\n");
            }
        }
        bw.flush();
    }
}
