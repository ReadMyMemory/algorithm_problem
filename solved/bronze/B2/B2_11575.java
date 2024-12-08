package solved.bronze.B2;
import java.io.*;
import java.util.StringTokenizer;

/*
아스키코드 활용해서 가능
'A' 값에서 '0' 값을 빼면 17이,
'Z' 값에서 '0' 값을 빼면 42가 나옴.
이걸 활용
 */

public class B2_11575 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while(T --> 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            String s = br.readLine();
            for(int i = 0; i < s.length(); i++) {
                int value = (((a * (s.charAt(i) - '0' - 17) + b) % 26));
                bw.write(String.valueOf((char)((value) + 17 + '0')));
            }
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
