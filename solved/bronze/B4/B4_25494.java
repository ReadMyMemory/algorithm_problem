package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

public class B4_25494 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while(T --> 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int count = 0;
            for(int i = 1; i <= a; i++) {
                for(int j = 1; j <= b; j++) {
                    for(int k = 1; k <= c; k++) {
                        if(i % j == j % k && j % k == k % i)
                            count++;
                    }
                }
            }
            bw.write(count+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
