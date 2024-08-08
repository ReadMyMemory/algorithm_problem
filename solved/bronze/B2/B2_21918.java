package solved.bronze.B2;
import java.io.*;
import java.util.StringTokenizer;

public class B2_21918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //첫 번째 줄 입력
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //두 번째 줄 입력
        st = new StringTokenizer(br.readLine());
        boolean[] bulb = new boolean[N];
        for(int i = 0; i < N; i++) {
            if(Integer.parseInt(st.nextToken()) == 1)
                bulb[i] = true;
        }

        //세 번째 줄 입력
        while(M --> 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 이후 명령어 처리
            switch (a) {
                case 1:
                    if(c == 1)
                        bulb[b-1] = true;
                    else
                        bulb[b-1] = false;
                    break;
                case 2:
                    for(int i = b-1; i <= c-1; i++) {
                        if(bulb[i])
                            bulb[i] = false;
                        else
                            bulb[i] = true;
                    }
                    break;
                case 3:
                    for(int i = b-1; i <= c-1; i++)
                        bulb[i] = false;
                    break;
                case 4:
                    for(int i = b-1; i <= c-1; i++)
                        bulb[i] = true;
                    break;
            }
        }

        for(boolean a : bulb) {
            if(a)
                System.out.print(1+" ");
            else
                System.out.print(0+" ");
        }
    }
}
