package solved;

import java.io.*;
import java.util.StringTokenizer;

public class B5_2420 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 범위가 -20억에 20억까지라 int를 쓰면 안될 거 같다. long을 써보자.
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long diff = A - B;
        if(diff < 0) // 절댓값이니까 음수면 양수로
            diff += -2 * diff;
        bw.write(diff+"");
        bw.flush();
        br.close();
        bw.close();
    }
}
