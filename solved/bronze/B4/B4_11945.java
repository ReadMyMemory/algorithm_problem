package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

public class B4_11945 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 좌우반전. 결국 뒤에서부터 읽어서 다시 기록하면 되는 간단한 문제였다.
        while(N --> 0) {
            String str = br.readLine();
            for(int i = M-1; i >= 0; i--)
                bw.write(String.valueOf(str.charAt(i) - '0'));
            bw.write("\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
