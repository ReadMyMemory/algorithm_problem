package solved_ac_step.class3;
import java.io.*;
import java.util.StringTokenizer;

public class S4_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int amount = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        int i = N-1;
        while(amount > 0) {
            while(amount < arr[i])
                i--;
            amount -= arr[i];
            count++;
        }
        bw.write(count+"");
        bw.flush();
        br.close();
        bw.close();

    }
}
