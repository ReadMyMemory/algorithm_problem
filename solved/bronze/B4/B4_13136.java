package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

public class B4_13136 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long RN = (int)Math.ceil((double) R / N);
        long CN = (int)Math.ceil((double) C / N);
        System.out.println(RN * CN);
    }
}
