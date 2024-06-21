package solved.bronze.B4;
import java.io.*;

public class B4_14470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        if(A < 0)
            System.out.println(-A * C + D + B * E);
        else
            System.out.println( (B - A) * E);
    }
}
