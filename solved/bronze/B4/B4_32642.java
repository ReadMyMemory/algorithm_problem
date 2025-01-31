package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

public class B4_32642 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine(); // N이 필요없다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        long answer = 0;
        int now_bunno = 0;
        while(st.hasMoreTokens()) {
            if(Integer.parseInt(st.nextToken()) == 1)
                now_bunno++;
            else
                now_bunno--;
            answer += now_bunno;
        }
        System.out.println(answer);
    }
}
