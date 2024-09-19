package solved.bronze.B3;
import java.io.*;
import java.util.StringTokenizer;

public class B3_4435 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int battle_count = 1;
        while(T --> 0) {
            // 초기화
            int gandalf_point = 0;
            int sauron_point = 0;
            int[] gandalf_tribe = {1, 2, 3, 3, 4, 10};
            int[] sauron_tribe = {1, 2, 2, 2, 3, 5, 10};

            //종족 점수 계산
            st = new StringTokenizer(br.readLine());
            int i = 0;
            while(st.hasMoreTokens()) {
                gandalf_point += gandalf_tribe[i] * Integer.parseInt(st.nextToken());
                i++;
            }
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while(st.hasMoreTokens()) {
                sauron_point += sauron_tribe[j] * Integer.parseInt(st.nextToken());
                j++;
            }

            // 출력부
            if(gandalf_point > sauron_point)
                bw.write("Battle "+battle_count+": Good triumphs over Evil\n");
            else if(gandalf_point == sauron_point)
                bw.write("Battle "+battle_count+": No victor on this battle field\n");
            else
                bw.write("Battle "+battle_count+": Evil eradicates all trace of Good\n");
            battle_count++;
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
