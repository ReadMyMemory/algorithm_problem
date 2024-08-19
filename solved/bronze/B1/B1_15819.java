package solved.bronze.B1;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1_15819 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int I = Integer.parseInt(st.nextToken());
        String[] arr = new String[N];

        for(int i = 0; i < N; i++)
            arr[i] = br.readLine();

        Arrays.sort(arr);
        System.out.println(arr[I-1]);
    }
}
