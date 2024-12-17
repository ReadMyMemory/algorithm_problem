package solved.bronze.B1;
import java.io.*;
import java.util.StringTokenizer;

public class B1_14467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        boolean[][] count = new boolean[N+1][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            if(!count[cow][value]) {
                if(value == 1) {
                    if (count[cow][0]) {
                        count[cow][0] = false;
                        answer++;
                    }
                } else if(value == 0) {
                    if (count[cow][1]) {
                        count[cow][1] = false;
                        answer++;
                    }
                }
                count[cow][value] = true;
            }
        }
        System.out.println(answer);

    }
}
