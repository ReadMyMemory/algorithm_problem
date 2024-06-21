package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

public class B4_10156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if(K * N >= M)
            System.out.println(K * N - M);
        else
            System.out.println(0);
    }
}
