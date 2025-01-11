package solved.bronze.B3;
import java.io.*;
import java.util.StringTokenizer;

/*
(21 / 70) - (21 / 80)
0.3 - 0.2625 = 0.0375
0.0375 * 3600 = 135 = 2분 15초
 */

public class B3_9493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb;
        while(true) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if(M == 0 && A == 0 && B == 0)
                break;
            float diffA = (float) M / A;
            float diffB = (float) M / B;
            int time = Math.round(Math.abs(diffA - diffB) * 3600);
            int h = time / 3600;
            time %= 3600;
            String m = "";
            if((time / 60) < 10) {
                sb = new StringBuilder();
                sb.append(0).append((time / 60));
                m = sb.toString();
            } else {
                m = String.valueOf(time / 60);
            }
            String s = "";
            time %= 60;
            if(time < 10) {
                sb = new StringBuilder();
                sb.append(0).append(time);
                s = sb.toString();
            } else {
                s = String.valueOf(time);
            }
            bw.write(h + ":" + m + ":" + s + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
