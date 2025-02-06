package solved.bronze.B3;
import java.io.*;
import java.util.StringTokenizer;

public class B3_10474 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            if(B == 0) // 분모는 0이 될 수 없으니까
                break;
            bw.write(A / B + " " + A % B + " / " + B + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
