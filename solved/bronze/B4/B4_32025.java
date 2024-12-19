package solved.bronze.B4;
import java.io.*;

public class B4_32025 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int H = Integer.parseInt(br.readLine());
        int W = Integer.parseInt(br.readLine());
        System.out.println(Math.min(H * 100, W * 100) / 2);
    }
}
