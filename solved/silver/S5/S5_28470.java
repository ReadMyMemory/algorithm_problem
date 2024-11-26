package solved.silver.S5;
import java.io.*;
import java.util.StringTokenizer;

// 삽질 엄청 했었는데 그냥 보니까 아드레날린 수치가 int 범위를 넘을 수 있었다. 바보인가...

public class S5_28470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] attack = new int[N];
        int[] defend = new int[N];
        float[] dx = new float[N];
        Long adrenaline = 0L;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            attack[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            defend[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            dx[i] = Float.parseFloat(st.nextToken());

        for (int i = 0; i < N; i++) {
            if(dx[i] >= 1) {
                adrenaline += (int) (attack[i] * (dx[i] * 10)) / 10;
                adrenaline -= defend[i];
            }
            else {
                adrenaline += attack[i];
                adrenaline -= (int) (defend[i] * (dx[i] * 10)) / 10;
            }
        }
        System.out.println(adrenaline);
    }
}
