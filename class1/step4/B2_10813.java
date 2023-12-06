package class1.step4;

import java.io.*;
import java.util.StringTokenizer;

public class B2_10813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 바구니 개수
        int M = Integer.parseInt(st.nextToken()); // 공의 위치를 바꾸는 횟수

        // 바구니 번호에 맞게 인덱스 번호 넣기. 배열은 알아보기 쉽게 크기를 1 크게 한다.
        int[] arr = new int[N+1];
        for(int i = 1; i <= N; i++) {
            arr[i] = i;
        }
        // 이번엔 StringTokenizer를 쓰지 않고, charAt을 이용하기.
        // 여러번 반복하는 경우 StringTokenizer보다 효율적일 수 있음.
        // 이었으나 자꾸 ArrayIndexOutOfBoundsException 에러 뜨길래 뭐지 했는데 다시보니
        // 인덱스가 2자리 이상의 수가 들어가면 이건 못씀. 걍 StringTokenizer 쓰자.


//        String str;
        int bound = 0;

        for(int j = 0; j < M; j++) { // 공 위치 교환. M번 반복
//            str = br.readLine();
//            int A = str.charAt(0) - '0';
//            int B = str.charAt(2) - '0';
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st2.nextToken());
            int B = Integer.parseInt(st2.nextToken());
            bound = arr[A];
            arr[A] = arr[B];
            arr[B] = bound;
        }

        for(int p = 1; p <= N; p++) {
            bw.write(arr[p]+" ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
