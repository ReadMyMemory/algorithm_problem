package solved.bronze.B5;
import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class B5_13277 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger bg1 = new BigInteger(st.nextToken());
        BigInteger bg2 = new BigInteger(st.nextToken());
        bw.write(bg1.multiply(bg2).toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
