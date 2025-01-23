package solved.bronze.B3;
import java.io.*;
import java.util.StringTokenizer;


public class B3_2965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        System.out.println(Math.max(B-A-1, C-B-1));
    }
}
