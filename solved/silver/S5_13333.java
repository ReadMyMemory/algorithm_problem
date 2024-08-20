package solved.silver;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S5_13333 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] index = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            index[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(index);
        int k = N;

        while(true) {
            int ind = 0;
            for(ind = 0; ind < N; ind++) {
                if(index[ind] >= k)
                    break;
            }
            if(ind <= k && N - ind >= k)
                break;
            k--;
        }

        System.out.println(k);

    }
}
