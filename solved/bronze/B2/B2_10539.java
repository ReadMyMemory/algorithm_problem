package solved.bronze.B2;
import java.io.*;

public class B2_10539 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String[] bStr = br.readLine().split(" ");
        long prevSum = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            long Bi = Long.parseLong(bStr[i - 1]);
            long sum = Bi * i;
            long Ai = sum - prevSum;
            sb.append(Ai);
            if (i < N) sb.append(' ');
            prevSum = sum;
        }
        System.out.println(sb.toString());
    }
}
