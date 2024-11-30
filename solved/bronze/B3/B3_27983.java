package solved.bronze.B3;
import java.io.*;
import java.util.StringTokenizer;

public class B3_27983 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean status = false;
        int N = Integer.parseInt(br.readLine());
        int idx = N;
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        Long[] X = new Long[N];
        Long[] L = new Long[N];
        char[] C = new char[N];
        while(idx --> 0) {
            X[N - idx - 1] = Long.parseLong(st1.nextToken());
            L[N - idx - 1] = Long.parseLong(st2.nextToken());
            C[N - idx - 1] = st3.nextToken().charAt(0);
        }
        for(int i = 0; i < N; i++) {
            for(int j = i; j < N; j++) {
                if(Math.abs(X[i] - X[j]) <= L[i] + L[j] && C[i] != C[j]) {
                    status = true;
                    bw.write((i+1)+" "+(j+1)+"\n"); // 인덱스는 0부터 시작했지만, 실제 출력은 1부터임.
                    break;
                }
            }
            if(status)
                break;
        }
        if(status)
            System.out.println("YES");
        else
            System.out.println("NO");

        bw.flush();
        br.close();
        bw.close();
    }
}
