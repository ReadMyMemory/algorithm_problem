package solved.bronze.B2;
import java.io.*;
import java.util.StringTokenizer;
/*
펫이 행복하려면
0.5 * 적정 체중 < 현재 체중 < 2 * 적정 체중

펫은 체중이 0이 되면 펫은 사망.
 */

public class B2_1362 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int scenario_number = 1;

        while(true) {
            st = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(st.nextToken()); // 적정 체중 o
            int w = Integer.parseInt(st.nextToken()); // 실제 체중 w
            if(o == 0) // 전체 시나리오 종료.
               break;
            bw.write(scenario_number+" ");
            scenario_number++;
            boolean deadStatus = false;
            while(true) {
                st = new StringTokenizer(br.readLine());
                String action = st.nextToken();
                if(action.equals("#")) { // 시나리오 탈출
                    bw.write(statusJudgement(o, w)+"\n");
                    st.nextToken();
                    break;
                }
                int time = Integer.parseInt(st.nextToken());
                if(!deadStatus) { // 펫이 죽지 않았다면 작용 실행
                    if (action.equals("F"))
                        w += time;
                    else
                        w -= time;
                    if (w <= 0)
                        deadStatus = true; // 죽으면 더이상 펫에게 작용하지 않음.
                }
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
    static String statusJudgement (int o, int w) {
        if(w <= 0)
            return "RIP";
        else if((double) 0.5 * o < (double) w && w < 2 * o)
            return ":-)";
        else
            return ":-(";
    }
}
