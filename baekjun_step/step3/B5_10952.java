package baekjun_step.step3;

import java.io.*;
import java.util.StringTokenizer;

public class B5_10952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if(A == 0 && B == 0) break;
            int Sum = A + B;
            bw.write(Sum + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
