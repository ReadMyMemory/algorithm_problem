package solved.bronze.B3;
import java.io.*;
import java.util.StringTokenizer;

public class B3_30032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        String[] grid = new String[N];
        for(int i = 0; i < N; i++)
            grid[i] = br.readLine();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++)
                bw.write(Change(grid[i].charAt(j), D));
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static String Change(char c, int D) {
        if(D == 1) {
            if(c == 'd')
                return "q";
            if(c == 'b')
                return "p";
            if(c == 'q')
                return "d";
            if(c == 'p')
                return "b";
        } else {
            if(c == 'd')
                return "b";
            if(c == 'b')
                return "d";
            if(c == 'q')
                return "p";
            if(c == 'p')
                return "q";
        }
        return "";
    }

}
