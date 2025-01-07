package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

public class B4_19698 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        System.out.println(Math.min(N, (W / L) * (H / L)));
    }
}
