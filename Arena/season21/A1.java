package Arena.season21;
import java.io.*;
import java.util.StringTokenizer;

public class A1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testcase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        /*
        도훈이는 A, B 둘 다 가능
        상혁이는 A만 가능
        도훈이 먼저 B 끝내고 A 합류하면 상혁이랑 시간 차이 날 가능성 있음
         */

        while(testcase --> 0) {
            st = new StringTokenizer(br.readLine());
            int time = 0;
            int Ta = Integer.parseInt(st.nextToken());
            int Tb = Integer.parseInt(st.nextToken());
            int Va = Integer.parseInt(st.nextToken());
            int Vb = Integer.parseInt(st.nextToken());
            int verify_onlyB = Tb * Vb;
            int while_verify_b = 0;
            int num = 0;
            time += verify_onlyB;
            while(while_verify_b <= verify_onlyB) {
                while_verify_b += Ta;
                num++;
                if(num == Va)
                    break;
            }
            int left = Va - num + 1; // 남은 A 개수
            int remain_time = 0;
            if(while_verify_b > verify_onlyB)
                remain_time = while_verify_b - verify_onlyB; // A 작업을 B작업 이상으로 가장 빠르게 끝냈을 때 시간.
            int diff_time = Ta - remain_time;
            while(left != 0) {
                time += remain_time; // 먼저 시작한 상혁이 끝
                left--;
                if(left == 0)
                    break;
                time += diff_time; // 늦게 시작한 도훈이 끝
                left--;
            }
            bw.write(time+"\n");
        }
        bw.flush();
    }
}
