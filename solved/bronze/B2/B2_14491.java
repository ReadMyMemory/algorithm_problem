package solved.bronze.B2;
import java.io.*;

public class B2_14491 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T > 0) {
            sb.append(T % 9);
            T /= 9;
        }

        System.out.println(sb.reverse().toString());
    }
}
