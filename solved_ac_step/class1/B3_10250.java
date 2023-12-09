package solved_ac_step.class1;

import java.io.*;
import java.util.StringTokenizer;

public class B3_10250 {
    public static String CalculateACM (int a, int b, int c) {
        int index1 = 0; // 상세 호수를 결정하는 index
        int index2 = 0; // 층을 결정하는 index
        int number = c; // 계산에 사용하기 위해 입력받은 손님의 넘버를 잠시 저장
        while(number > 0) {
            index1++; // xx1호, xx2호의 1,2를 정하는 index다.
            number -= a; // 손님의 넘버에서 층만큼을 뺀다.
        }
        index2 = number + a; // 층을 결정하는 index;
        StringBuilder sb = new StringBuilder();
        sb.append(index2);
        if(index1 < 10) // 상세 호수는 99가 최대니까. 한자리수면 앞에 0을 붙여서 1203 이렇게 해주면 됨.
            sb.append(0);
        sb.append(index1);
        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TestNum = Integer.parseInt(br.readLine());
        for(int i = 0; i < TestNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                int H = Integer.parseInt(st.nextToken());
                int W = Integer.parseInt(st.nextToken());
                int N = Integer.parseInt(st.nextToken());
                String str = CalculateACM(H, W, N);
                bw.write(str+"\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
