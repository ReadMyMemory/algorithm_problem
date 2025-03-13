package solved.bronze.B4;
import java.io.*;
import java.util.*;

public class B4_30017 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int maxCheeseburgerSize = Math.min(A, B + 1) + Math.min(A, B + 1) - 1;

        System.out.println(maxCheeseburgerSize);
    }
}
