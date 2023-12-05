package class1.step3;

import java.io.*;
import java.util.StringTokenizer;

public class B5_11022 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testNum = Integer.parseInt(br.readLine());
        int index = 1;

        while(testNum > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int Sum = A + B;
            bw.write("Case #" + index + ": "+ A + " + " + B + " = " + Sum+"\n");
            index++;
            testNum--;
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
