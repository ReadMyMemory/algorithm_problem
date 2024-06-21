package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

public class B4_17388 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int min = Math.min(S, Math.min(K, H));
        int participation = S + K + H;
        if(participation < 100) {
            if (min == S)
                bw.write("Soongsil");
            else if (min == K)
                bw.write("Korea");
            else if (min == H)
                bw.write("Hanyang");
        } else {
            bw.write("OK");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
