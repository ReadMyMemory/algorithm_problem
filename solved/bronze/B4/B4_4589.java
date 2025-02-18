package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

public class B4_4589 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("Gnomes:\n");
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(N --> 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if ((a <= b && b <= c) || (a >= b && b >= c))
                bw.write("Ordered\n");
            else
                bw.write("Unordered\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
