package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

public class B4_25600 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int max = 0;
        while(T --> 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            if(a == d + g)
                max = Math.max(max, 2 * a *(d + g));
            else
                max = Math.max(max, a *(d + g));
        }

        System.out.println(max);
    }
}
