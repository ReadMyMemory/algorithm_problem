package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

public class B4_17356 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        double M = (double) (b - a) / 400;
        System.out.println(1 / (1 + Math.pow(10, M)));
    }
}
