package solved.bronze.B4;
import java.io.*;

public class B4_29738 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int i = 1; i <= T; i++) {
            int round = round(Integer.parseInt(br.readLine()));
            if(round <= 3)
                bw.write("Case #" + i + ": Round " + round + "\n");
            else
                bw.write("Case #" + i + ": World Finals\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static int round(int n) {
        if(n > 4500)
            return 1;
        else if(n > 1000)
            return 2;
        else if(n > 25)
            return 3;
        else
            return 4;
    }
}
