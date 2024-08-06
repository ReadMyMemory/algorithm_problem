package solved.bronze.B5;
import java.io.*;
import java.util.StringTokenizer;

public class B5_15964 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long plus = A + B;
        long minus = A - B;
        System.out.println(plus * minus);
    }
}
