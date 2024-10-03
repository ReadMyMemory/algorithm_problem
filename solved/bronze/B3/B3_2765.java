package solved.bronze.B3;
import java.io.*;
import java.util.StringTokenizer;

public class B3_2765 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int index = 1;

        while(true) {
            //입력부
            st = new StringTokenizer(br.readLine());
            float radius = Float.parseFloat(st.nextToken()); // 단위 인치, 출력은 마일로 표시해야함.
            int rpm = Integer.parseInt(st.nextToken()); // 정수
            float time = Float.parseFloat(st.nextToken()); // 단위 초

            //조건부
            if(rpm == 0)
                break;

            //연산부
            float distance = (float) (radius * rpm * 3.1415927 / 12 / 5280);

            //출력부
            bw.write("Trip #"+index+": ");
            bw.write(String.format("%.2f", distance)+" "+String.format("%.2f", distance * (3600 / time))+"\n");
            index++;
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
