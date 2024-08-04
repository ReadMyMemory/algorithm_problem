package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

public class B4_9295 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int temp = T;
        while(T --> 0) {
            st = new StringTokenizer(br.readLine());
            bw.write("Case "+ (temp-T) + ": " + (Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()))+"\n");
        }
        bw.flush();
        br.close();
        bw.close();

    }
}
