package solved.bronze.B1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1_9946 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int caseNumber = 1;

        while (true) {
            String a = br.readLine();
            String b = br.readLine();

            if (a.equals("END") && b.equals("END")) {
                break;
            }

            int[] count = new int[26];

            for (int i = 0; i < a.length(); i++) {
                count[a.charAt(i) - 'a']++;
            }

            for (int i = 0; i < b.length(); i++) {
                count[b.charAt(i) - 'a']--;
            }

            boolean same = true;
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    same = false;
                    break;
                }
            }

            sb.append("Case ").append(caseNumber).append(": ")
                    .append(same ? "same" : "different").append('\n');

            caseNumber++;
        }
        System.out.print(sb);
    }
}