package solved.bronze.B3;
import java.io.*;
import java.util.StringTokenizer;

public class B3_4493 {
    static int player_1;
    static int player_2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int Testcase = Integer.parseInt(br.readLine());
        while(Testcase --> 0) {
            int repeat = Integer.parseInt(br.readLine());
            player_1 = 0;
            player_2 = 0;
            for(int i = 0; i < repeat; i++) {
                st = new StringTokenizer(br.readLine());
                calculator(st.nextToken(), st.nextToken());
            }
            bw.write(whoWins()+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
    static void calculator(String a, String b) {
        if(a.equals(b)) {
            player_1++;
            player_2++;
        } else if(a.equals("R") && b.equals("S") || a.equals("P") && b.equals("R") || a.equals("S") && b.equals("P")) {
            player_1++;
        } else if(a.equals("R") && b.equals("P") || a.equals("P") && b.equals("S") || a.equals("S") && b.equals("R")) {
            player_2++;
        }
    }

    static String whoWins() {
        if(player_1 == player_2)
            return "TIE";
        else if(player_1 > player_2)
            return "Player 1";
        else
            return "Player 2";
    }
}
