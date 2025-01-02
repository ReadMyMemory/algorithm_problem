package solved.bronze.B4;
import java.io.*;

public class B4_31821 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int[] menu = new int[N+1];
        for(int i = 1; i <= N; i++)
            menu[i] = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++)
            sum += menu[Integer.parseInt(br.readLine())];
        System.out.println(sum);
    }
}
