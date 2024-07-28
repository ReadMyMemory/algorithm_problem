package solved.bronze.B3;
import java.io.*;
import java.util.StringTokenizer;

public class B3_25965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        int N = Integer.parseInt(br.readLine());
        while(N --> 0) {
            int M = Integer.parseInt(br.readLine());
            long total = 0;
            int[] K_mission = new int[M];
            int[] D_mission = new int[M];
            int[] A_mission = new int[M];
            int i = 0;
            int M_temp = M;
            while (M --> 0) {
                st = new StringTokenizer(br.readLine());
                K_mission[i] = Integer.parseInt(st.nextToken());
                D_mission[i] = Integer.parseInt(st.nextToken());
                A_mission[i] = Integer.parseInt(st.nextToken());
                i++;
            }
            st = new StringTokenizer(br.readLine());
            long K_score = Integer.parseInt(st.nextToken());
            long D_score = Integer.parseInt(st.nextToken());
            long A_score = Integer.parseInt(st.nextToken());
            i = 0;
            while (M_temp --> 0) {
                long mission_total = K_score * K_mission[i] - D_score * D_mission[i] + A_score * A_mission[i];
                if(mission_total > 0) // 미션당 점수가 0점 이상이면 더하기
                    total += mission_total;
                i++;
            }
            bw.write(total + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
