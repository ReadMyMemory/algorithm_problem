package solved.silver.S3;
import java.io.*;
import java.util.StringTokenizer;

public class S3_11332 {
    static int C;
    static String S;
    static int N;
    static int T;
    static int L;
    static final int Standard = 100000000;
    static boolean isPass;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        C = Integer.parseInt(br.readLine());
        for(int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            S = st.nextToken();
            N = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            if(checkIsPass())
                bw.write("May Pass.\n");
            else
                bw.write("TLE!\n");
        }
        bw.flush();
    }

    static boolean checkIsPass() {
        double caseTime = (L * Standard) / T;
        isPass = true;
        long temp;
        if(S.equals("O(N)")) {
            if(caseTime < N)
                isPass = false;
        }
        else if(S.equals("O(N^2)")) {
            if((caseTime / N) < N)
                isPass = false;
        }
        else if(S.equals("O(N^3)")) {
            if(((caseTime / N) / N) < N)
                isPass = false;
        }
        else if(S.equals("O(2^N)")) {
            temp = 1;
            for(int i = 0; i < N; i++) {
                temp = temp << 1;
                if(temp > caseTime) {
                    isPass = false;
                    break;
                }
            }
        }
        else if(S.equals("O(N!)")) {
            temp = 1;
            for(int i = 2; i <= N; i++) {
                temp = temp * i;
                if(temp > caseTime) {
                    isPass = false;
                    break;
                }
            }
        }
        return isPass;
    }


}
