package solved_ac_step.class2;
import java.io.*;
import java.util.StringTokenizer;

public class B2_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        boolean[] map = new boolean[1001]; // 문제조건이 1000이하의 자연수니까, true면 제거된 값(소수 X), false면 살아있는 값(소수)
        int size = 1000;

        int testcase = Integer.parseInt(br.readLine());

        map[1] = true; // 1은 그냥 소수가 아님

        //소수만 남기기
        for(int i = 2; i < 1000; i++) {
            if(map[i]) continue;
            else {
                int value = i;
                value += i; // 배수를 체크하는 처음 값은 제거하지 않음.
                while(value <= size) {
                    map[value] = true;
                    value += i;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int count = 0; // 소수 개수 세는 변수
        while(testcase > 0) {
            int index = Integer.parseInt(st.nextToken());
            if(!map[index]) count++;
            testcase--;
        }

        bw.write(count+"");
        bw.flush();
        br.close();
        bw.close();


    }
}
