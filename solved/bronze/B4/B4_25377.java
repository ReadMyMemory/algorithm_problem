package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

public class B4_25377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int min = -1;
        while(N --> 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a <= b) {
                if(min == -1)
                    min = b;
                else {
                    if (min > b)
                        min = b;
                }
            }
        }
        System.out.println(min);
    }
}
