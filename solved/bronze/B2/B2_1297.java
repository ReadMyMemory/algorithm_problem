package solved.bronze.B2;
import java.io.*;
import java.util.*;

public class B2_1297 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        double denom = Math.sqrt((double)H * H + (double)W * W);
        double k = D / denom;

        int realH = (int) Math.floor(H * k);
        int realW = (int) Math.floor(W * k);
        System.out.print(realH + " " + realW);
    }
}