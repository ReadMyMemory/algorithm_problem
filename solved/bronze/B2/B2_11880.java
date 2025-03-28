package solved.bronze.B2;
import java.io.*;

public class B2_11880 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            // 가능한 최단 거리 중 최소값을 선택
            long minDistSquared = Math.min(
                    (long) (a + b) * (a + b) + (long) c * c,
                    Math.min(
                            (long) (b + c) * (b + c) + (long) a * a,
                            (long) (c + a) * (c + a) + (long) b * b
                    )
            );

            bw.write(minDistSquared + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
