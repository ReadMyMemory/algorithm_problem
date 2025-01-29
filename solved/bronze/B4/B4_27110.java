package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

public class B4_27110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        while (st.hasMoreTokens())
            sum += Math.min(N, Integer.parseInt(st.nextToken()));
        System.out.println(sum);
    }
}
