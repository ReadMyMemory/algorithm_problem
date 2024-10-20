package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

public class B4_15726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double A = Double.parseDouble(st.nextToken());
        double B = Double.parseDouble(st.nextToken());
        double C = Double.parseDouble(st.nextToken());
        long max = (long) Math.max((A * B) / C, (A / B) * C);
        System.out.println(max);
    }
}
