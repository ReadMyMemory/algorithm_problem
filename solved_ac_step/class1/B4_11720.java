package solved_ac_step.class1;

import java.io.*;

public class B4_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int Num = Integer.parseInt(br.readLine());
        //공백이 없다. StringTokenizer만 쓰기엔 부적합
        //기존에는 charAt을 썼었는데 이번엔 getBytes를 한 번 써볼 것이다.
        int sum = 0;
        byte[] value = br.readLine().getBytes();
        for(int i = 0; i < Num; i++) {
            sum += value[i] - '0';
        }

        bw.write(sum+"");
        bw.flush();
        br.close();
        bw.close();
    }
}
