package solved.bronze.B5;
import java.io.*;

public class B5_27323 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(A * B));
        bw.flush();
        br.close();
        bw.close();
    }
}
