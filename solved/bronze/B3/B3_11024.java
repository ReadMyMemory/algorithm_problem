package solved.bronze.B3;
import java.io.*;
import java.util.StringTokenizer;

public class B3_11024 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while(T --> 0) {
            st = new StringTokenizer(br.readLine());
            long temp = 0L;
            while(st.hasMoreTokens())
                temp += Integer.parseInt(st.nextToken());
            bw.write(temp+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
