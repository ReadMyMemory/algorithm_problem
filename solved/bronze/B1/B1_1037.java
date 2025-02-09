package solved.bronze.B1;
import java.io.*;
import java.util.StringTokenizer;

public class B1_1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = 1000000;
        int max = 1;
        while(N --> 0) {
            int temp = Integer.parseInt(st.nextToken());
            min = Math.min(temp, min);
            max = Math.max(temp, max);
        }
        System.out.println(max * min);
    }
}
