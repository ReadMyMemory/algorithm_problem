package solved.bronze.B5;
import java.io.*;
import java.util.StringTokenizer;

public class B5_16430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        bw.write((B-A)+" "+B);
        bw.flush();
        br.close();
        bw.close();
    }
}
