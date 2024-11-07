package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

public class B4_25628 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int A_count = A / 2; // int라서 .5가 버려짐
        System.out.println(Math.min(A_count, B));
    }
}
