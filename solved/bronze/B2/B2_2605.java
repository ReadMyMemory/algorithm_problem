package solved.bronze.B2;
import java.io.*;
import java.util.StringTokenizer;

public class B2_2605 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] line = new int[N];
        br.close();

        for(int i = 0; i < N; i++)
            line[i] = i+1;
        for(int i = 0; i < N; i++) {
            int repeat = Integer.parseInt(st.nextToken());
            int stan = i;
            while(repeat --> 0) {
                int temp = line[stan];
                line[stan] = line[stan - 1];
                line[stan - 1] = temp;
                stan--;
            }
        }

        for(int a : line)
            bw.write(a+" ");
        bw.flush();
        bw.close();
    }
}
