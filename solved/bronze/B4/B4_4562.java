package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

public class B4_4562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); //data sets
        while(n --> 0) {
            st = new StringTokenizer(br.readLine());
            if(Integer.parseInt(st.nextToken()) < Integer.parseInt(st.nextToken())) // 먹을 수 있는 뇌의 수 >= 좀비가 살기 위해 먹어야 하는 뇌의 수 여야 좀비는 살 수 있다.
                bw.write("NO BRAINS\n");
            else
                bw.write("MMM BRAINS\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
