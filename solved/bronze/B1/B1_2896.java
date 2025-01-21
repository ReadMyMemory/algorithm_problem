package solved.bronze.B1;
import java.io.*;
import java.util.StringTokenizer;

public class B1_2896 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int I = Integer.parseInt(st.nextToken());
        int J = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        float t = Math.min((float) A / I, Math.min((float) B / J, (float) C / K));
        System.out.println((A - I * t) + " " + (B - J * t) + " " + (C - K * t));
    }
}
