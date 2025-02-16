package solved.bronze.B2;
import java.io.*;
public class B2_17946 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int N = Integer.parseInt(br.readLine());

            for (int i = 0; i < N; i++) {
                long K = Long.parseLong(br.readLine());
                long totalPieces = K + 1;
                long givenToYoonhee = (K * (K + 1)) / 2;
                long eatenByYechun = Math.max(1, totalPieces - givenToYoonhee);

                sb.append(eatenByYechun).append("\n");
            }
            System.out.print(sb);
        }
}
