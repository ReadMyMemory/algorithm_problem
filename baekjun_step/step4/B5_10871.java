package baekjun_step.step4;

import java.io.*;
import java.util.StringTokenizer;

public class B5_10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringTokenizer st2;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st2 = new StringTokenizer(br.readLine());
        int I;
        for(int i = 0; i < N; i++) {
            if((I = Integer.parseInt(st2.nextToken())) < X)
                bw.write(I + " ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
