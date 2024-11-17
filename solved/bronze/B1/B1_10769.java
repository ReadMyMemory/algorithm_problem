package solved.bronze.B1;
import java.io.*;

public class B1_10769 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solution(s));
    }

    private static String solution(String s) {
        int length = s.length();
        int smile = 0;
        int sad = 0;
        for(int i = 0; i < length; i++) {
            if(s.charAt(i) == ':') {
                if(i + 1 < length) {
                    if(s.charAt(i + 1) == '-') {
                        if(i + 2 < length) {
                            if(s.charAt(i + 2) == ')') {
                                smile++;
                                i += 2;
                            } else if(s.charAt(i + 2) == '(') {
                                sad++;
                                i += 2;
                            }
                        }
                    }
                }
            }
        }
        if(smile == 0 && sad == 0)
            return "none";
        else if(smile == sad)
            return "unsure";
        else if(smile > sad)
            return "happy";
        else
            return "sad";
    }
}
