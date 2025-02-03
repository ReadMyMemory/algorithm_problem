package solved.bronze.B1;
import java.io.*;

public class B1_16968 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String format = br.readLine();
        br.close();

        int result = countPossiblePlates(format);
        System.out.println(result);
    }

    private static int countPossiblePlates(String format) {
        int numWays = 1;
        char prev = ' '; // 이전 문자 저장

        for (char ch : format.toCharArray()) {
            if (ch == 'c') {
                numWays *= (prev == 'c') ? 25 : 26;
            } else if (ch == 'd') {
                numWays *= (prev == 'd') ? 9 : 10;
            }
            prev = ch;
        }

        return numWays;
    }
}
