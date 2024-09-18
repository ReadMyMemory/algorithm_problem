package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

public class B4_28097 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        sum += 8 * (N-1); // 공부시간 중간에 발생하는 휴식시간을 미리 계산.
        while(N --> 0)
            sum += Integer.parseInt(st.nextToken());
        bw.write(sum / 24 + " " + sum % 24);
        bw.flush();
        br.close();
        bw.close();
    }
}
