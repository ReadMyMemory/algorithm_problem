package solved.bronze.B1;
import java.io.*;

public class B1_4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseNumber = 1;
        while (true) {
            String[] input = br.readLine().split(" ");
            int L = Integer.parseInt(input[0]);
            int P = Integer.parseInt(input[1]);
            int V = Integer.parseInt(input[2]);

            if (L == 0 && P == 0 && V == 0) {
                break;
            }

            int fullCycles = V / P;
            int remainingDays = V % P;
            int maxCampingDays = (fullCycles * L) + Math.min(remainingDays, L);

            bw.write("Case " + caseNumber + ": " + maxCampingDays + "\n");
            caseNumber++;
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
