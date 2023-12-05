package class1.step3;

import java.io.*;

public class B5_10951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;


        while((str=br.readLine()) != null) {

            //https://st-lab.tistory.com/40를 참고한 코드.
            //반복문에서 StringTokenizer를 계속 돌리는 게 비효율적이라 판단하여 새로운 방법 제안
            int A = str.charAt(0) - '0';
            int B = str.charAt(2) - '0';
            int Sum = A + B;
            bw.write(Sum + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
