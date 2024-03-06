package solved.bronze;
import java.io.*;
import java.util.StringTokenizer;

public class B4_5717 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            int sum = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
            if(sum == 0)
                break;
            bw.write(sum+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
