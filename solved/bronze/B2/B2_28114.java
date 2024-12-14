package solved.bronze.B2;
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B2_28114 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] P = new int[3];
        int[] Y = new int[3];
        String[] S = new String[3];

        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            P[i] = Integer.parseInt(st.nextToken());
            Y[i] = Integer.parseInt(st.nextToken());
            S[i] = st.nextToken();
        }

        Arrays.sort(Y);

        for(int i = 0; i < 3; i++) bw.write(String.valueOf(Y[i] % 100));
        bw.write("\n");

        HashMap<Integer, String> map = new HashMap<>();
        map.put(P[0], S[0]);
        map.put(P[1], S[1]);
        map.put(P[2], S[2]);
        Arrays.sort(P);
        bw.write(String.valueOf(map.get(P[2]).charAt(0)));
        bw.write(String.valueOf(map.get(P[1]).charAt(0)));
        bw.write(String.valueOf(map.get(P[0]).charAt(0)));
        bw.flush();
        br.close();
        bw.close();
    }
}
