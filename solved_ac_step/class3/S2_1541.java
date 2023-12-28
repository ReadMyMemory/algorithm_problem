package solved_ac_step.class3;
import java.io.*;
import java.util.StringTokenizer;

public class S2_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringTokenizer st2;
        int sum = Integer.MAX_VALUE;
         st = new StringTokenizer(br.readLine(), "-"); // -로 1차 쪼갬
        while(st.hasMoreTokens()) {
            int temp = 0;
            st2 = new StringTokenizer(st.nextToken(), "+");// 내부에서 +로 2차 쪼갬

            while(st2.hasMoreTokens()) {
                temp+=Integer.parseInt(st2.nextToken());
            }

            if(sum == Integer.MAX_VALUE) {
                sum = temp; // 이건 맨 처음 값인지를 판단하기 위함임.
            } else {
                sum -= temp;
            }
        }
        bw.write(Integer.toString(sum)); //Integer.toString()을 써도 되고, String.valueOf()를 써도 되고, 그냥 valueOf를 써도 되며, int값+""을 써도 된다.
        bw.flush();
        br.close();
        bw.close();

    }
}
