package solved.bronze.B3;
import java.io.*;
import java.util.StringTokenizer;

public class B3_28061 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] lemon_tree = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++)
            lemon_tree[i] = Integer.parseInt(st.nextToken());

        int max = -1;
        for(int i = 1; i <= N; i++)
            max = Math.max(max, lemon_tree[i] - (N + 1 - i));

        System.out.println(max);
    }
}
