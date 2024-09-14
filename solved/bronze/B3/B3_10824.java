package solved.bronze.B3;
import java.io.*;
import java.util.StringTokenizer;

public class B3_10824 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb1.append(st.nextToken()).append(st.nextToken());
        sb2.append(st.nextToken()).append(st.nextToken());
        System.out.println(Long.parseLong(sb1.toString()) + Long.parseLong(sb2.toString()));
    }
}
