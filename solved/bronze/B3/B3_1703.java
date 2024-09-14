package solved.bronze.B3;
import java.io.*;
import java.util.StringTokenizer;

public class B3_1703 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int branch = 1;

            if(N == 0)
                break;

            for(int i = 0; i < 2 * N; i++) {
                int M = Integer.parseInt(st.nextToken());
                if(i % 2 == 0)
                    branch *= M;
                else
                    branch -= M;
            }
            System.out.println(branch);
        }
    }
}
