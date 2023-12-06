package class1.step4;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B2_10811 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 바구니 개수
        int M = Integer.parseInt(st.nextToken()); // 바구니의 위치를 역순으로 바꾸는 횟수

        // 바구니 번호에 맞게 인덱스 번호 넣기. 배열은 알아보기 쉽게 크기를 1 크게 한다.
        Integer[] arr = new Integer[N+1];
        for(int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        int num = 0;

        while(num < M) { //가독성을 위해 while문 사용.
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st2.nextToken());
            //새로운 아이디어 Arrays.copyOfRange를 사용해 부분 배열을 빼와서 역순 정렬 전달
            // 이거 쓴다고 int 배열을 Integer 배열로 바꿨는데..
            //다시 해보니 그냥 내가 직접 부분 배열 만드는 게 나을 거 같다.

            // 부분 배열 복사
            //ex. 1 4라면 start = 1; end =4;
            //배열의 subArray[1] = arr[1], subArray[2] = arr[2]...
            Integer[] subArray = new Integer[end+1];
            for(int j = start; j <= end; j++) {
                subArray[j] = arr[j];
            }
            for(int i = 0; i <= end - start; i++) {
                arr[start + i] = subArray[end-i];
            }
            num++;
        }
        for(int p = 1; p <= N; p++) {
            bw.write(arr[p]+" ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
