package solved.bronze.B3;
import java.io.*;
import java.util.StringTokenizer;

public class B3_12790 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int testcase = Integer.parseInt(br.readLine());
        for(int i = 0; i < testcase; i++) {
            st = new StringTokenizer(br.readLine());
            int hp = Integer.parseInt(st.nextToken());
            int mp = Integer.parseInt(st.nextToken());
            int attack = Integer.parseInt(st.nextToken());
            int defense = Integer.parseInt(st.nextToken());
            hp += Integer.parseInt(st.nextToken());
            mp += Integer.parseInt(st.nextToken());
            attack += Integer.parseInt(st.nextToken());
            defense += Integer.parseInt(st.nextToken());
            if(hp < 1) hp = 1;
            if(mp < 1) mp = 1;
            if(attack < 0) attack = 0;
            bw.write((hp + 5 * mp + 2 * attack + 2 * defense)+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
