package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

public class B4_15700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long n = Long.parseLong(st.nextToken());
        Long m = Long.parseLong(st.nextToken());
        if(n * m % 2 == 0)
            System.out.println(n * m / 2);
        else
            System.out.println((n * m - 1) / 2);
    }
}
